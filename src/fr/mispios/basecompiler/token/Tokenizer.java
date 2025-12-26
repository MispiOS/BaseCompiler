package fr.mispios.basecompiler.token;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer implements ITokenizer {
    public static List<IToken> tokenize(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        Reader buffer = new BufferedReader(new FileReader(file)); // throws FileNotFoundException

        ArrayList<IToken> tokens = new ArrayList<>();

        int lineNumber = 1;
        int columnNumber = 1;

        char previous = ' ';
        char current;
        int r;
        StringBuilder word = new StringBuilder();

        try {
            while ((r = buffer.read()) != -1) {
                current = (char) r;
                TokenType tokenType = TokenType.fromSymbol(current);

                if(tokenType == TokenType.OTHER) {
                    if(current == ' ' || current == '\n') {
                        if(word.length() != 0) {
                            tokens.add(
                                    new Token(fileName, lineNumber, columnNumber - word.length(), word.toString())
                            );
                            word = new StringBuilder();
                            if(current == '\n') {
                                lineNumber++;
                                columnNumber = 1;
                            }
                        }
                    } else {
                        word.append(current);
                    }
                } else {
                    if(word.length() != 0) {
                        tokens.add(
                                new Token(fileName, lineNumber, columnNumber - word.length(), word.toString())
                        );
                        word = new StringBuilder();
                    }

                    if(current == '/' && previous == '/') { // inline comment
                        tokens.remove(tokens.size() - 1); // the last '/' was not the operator
                        do {
                            r = buffer.read();
                        } while (r != -1 && (char) r != '\n'); // we wait to be at the end of the line
                        lineNumber++;
                        columnNumber = 0;
                    } else if(current == '*' && previous == '/') { // (possibly) multiple line comment
                        tokens.remove(tokens.size() - 1); // the last '/' was not the operator
                        r = buffer.read();
                        if(r != -1) { // skip the '*' to be previous because we can have "/*/ something */" (yeah that's weird)
                            columnNumber++;

                            current = (char) r;
                            boolean stop = false;
                            while((r = buffer.read()) != -1 && !stop) {
                                columnNumber += 1;
                                previous = current;
                                current = (char) r;
                                if(current == '\n') {
                                    lineNumber++;
                                    columnNumber = 1;
                                }
                                if(current == '/' && previous == '*') stop = true; // end of comment

                            }
                        }
                    } else if(tokenType == TokenType.QUOTE || tokenType == TokenType.CHAR_QUOTE) {
                        int startLine = lineNumber;
                        int statColumn = columnNumber - 1;

                        boolean stop = false;
                        while((r = buffer.read()) != -1 && !stop) {
                            columnNumber++;
                            previous = current;
                            current = (char) r;
                            if(
                                    (
                                            current == '"' && tokenType == TokenType.QUOTE ||
                                            current == '\'' && tokenType == TokenType.CHAR_QUOTE
                                    )
                                            && previous != '\\'
                            ) {
                                stop = true;
                            } else {
                                if(current == '\n') {
                                    lineNumber++;
                                    columnNumber = 1;
                                } else {
                                    word.append(current);
                                }
                            }
                        }
                        tokens.add(
                                new Token(
                                        fileName,
                                        startLine,
                                        statColumn,
                                        (tokenType == TokenType.QUOTE || 1 < word.length()) ? TokenType.STRING : TokenType.CHAR,
                                        word.toString()
                                )
                        );
                        word = new StringBuilder();
                    } else {
                        tokens.add(
                                new Token(fileName, lineNumber, columnNumber - 1, tokenType, String.valueOf(current))
                        );
                    }
                }

                previous = current;
                columnNumber++;
            }
            if(word.length() != 0) {
                tokens.add(
                        new Token(fileName, lineNumber, columnNumber - word.length(), word.toString())
                );
            }
        } catch (IOException ioe) {
            tokens = null;
        }
        return tokens;
    }
}
