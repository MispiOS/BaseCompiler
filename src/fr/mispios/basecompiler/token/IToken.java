package fr.mispios.basecompiler.token;

public interface IToken {
    /**
     * @return The file the Token has been generated from
     */
    String getFile();

    /**
     * @return The line of the file the Token has been generated from
     */
    int getLine();

    /**
     * @return The column of on the line the Token has been generated from
     */
    int getColumn();

    /**
     * @return The <code>TokenType</code> of the Token
     */
    TokenType getType();

    /**
     * @return The value of the Token
     */
    String getValue();
}
