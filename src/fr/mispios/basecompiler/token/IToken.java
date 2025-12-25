package fr.mispios.basecompiler.token;

public interface IToken {
    String getFile();
    int getLine();
    int getColumn();
    TokenType getType();
    String getValue();
}
