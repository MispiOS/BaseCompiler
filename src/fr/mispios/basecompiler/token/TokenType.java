package fr.mispios.basecompiler.token;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents all the types Tokens can have identified by there symbols
 */
public enum TokenType {
    NONE,
    EQUALS('=');

    private final List<Character> symbol;
    TokenType(char... symbols) {
        symbol = new ArrayList<>();
        for(char s : symbols) {
            symbol.add(s);
        }
    }

    TokenType() {
        this(' ');
    }

    public List<Character> getSymbols() { return symbol; }

    /**
     * Give the TokenType associated with the given symbol
     * @param symbol The symbol you search the associated <code>TokenType</code>
     * @return The associeated <code>TokenType</code> if it exists else <code>TokenType.NONE</code>
     */
    public static TokenType fromSymbol(char symbol) {
        TokenType[] values = values();
        int i = 0;
        TokenType res = NONE;
        TokenType tmp;
        while(i < values.length && res.equals(NONE)) {
            tmp = values[i];
            if(tmp.getSymbols().contains(symbol)) {
                res = tmp;
            }
            i++;
        }
        return res;
    }
}
