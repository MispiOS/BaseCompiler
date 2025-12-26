package fr.mispios.basecompiler.token;

/**
 * This class represents Tokens. A Token is identified by the file it comes from, the line and the column number it has been created, its TokenType, and its content
 */
public class Token implements IToken {
    private final String file;
    private final int line;
    private final int column;
    private final TokenType type;
    private final String value;

    public Token(String file, int line, int column, TokenType type, String value) {
        this.file = file;
        this.line = line;
        this.column = column;
        this.type = type;
        this.value = value;
    }

    public Token(String file, int line, int column, String value) {
        this(
                file,
                line,
                column,
                value.length() == 1 ? TokenType.fromSymbol(value.charAt(0)) : TokenType.fromWord(value),
                value
        );
    }

    public String getFile() { return file; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
    public TokenType getType() { return type; }
    public String getValue() { return value; }

    @Override
    public String toString() {
        return getType() + " " + getValue() + " in " + getFile() + " at " + getLine() + ":" + getColumn();
    }
}
