package fr.mispios.basecompiler.token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents all the types Tokens can have identified by there symbols
 */
@SuppressWarnings("unused")
public enum TokenType {
    OTHER,
    KEYWORD,
    TYPE,
    STRING,
    CHAR,
    EQUALS('='),
    QUOTE('"'),
    CHAR_QUOTE('\''),
    OPERATOR('+', '-', '/', '*', '%'),
    COMPARATOR('<', '>', '&', '|', '^', '!'),
    BRACKET('[', ']'),
    BRACE('{', '}'),
    PARENTHESIS('(', ')'),
    NUMBER('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
    DOT('.'),
    SEMICOLON(';'),
    POINTER('$');

    private final List<Character> symbol;
    TokenType(char... symbols) {
        symbol = new ArrayList<>();
        for(char s : symbols) {
            symbol.add(s);
        }
    }

    public List<Character> getSymbols() { return symbol; }

    private static final List<String> keywords = Arrays.asList(
            "import", "if", "else", "while", "do", "break", "continue", "fnct", "return", "object", "init", "self"
    );
    private static final List<String> types = Arrays.asList("int", "float", "char", "void");

    /**
     * Give the <code>TokenType</code> associated with the given symbol
     * @param symbol The symbol you search the associated <code>TokenType</code>
     * @return The associated <code>TokenType</code> if it exists, <code>TokenType.OTHER</code> else
     */
    public static TokenType fromSymbol(char symbol) {
        TokenType[] values = values();
        int i = 0;
        TokenType res = OTHER;
        TokenType tmp;
        while(i < values.length && res.equals(OTHER)) {
            tmp = values[i];
            if(tmp.getSymbols().contains(symbol)) {
                res = tmp;
            }
            i++;
        }
        return res;
    }

    /**
     * Give the <code>TokenType</code> associated with the given word
     * @param word The word you search the associated <code>TokenType</code>
     * @return The associated <code>TokenType</code> if it exists, <code>TokenType.OTHER</code> else
     */
    public static TokenType fromWord(String word) {
        TokenType res = OTHER;

        if(keywords.contains(word.toLowerCase())) {
            res = KEYWORD;
        } else if (types.contains(word.toLowerCase())) {
            res = TYPE;
        }
        return res;
    }
}
