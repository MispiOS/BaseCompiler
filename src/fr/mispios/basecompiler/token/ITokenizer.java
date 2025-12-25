package fr.mispios.basecompiler.token;

import java.io.FileNotFoundException;
import java.util.List;

public interface ITokenizer {
    /**
     * Transfrom the content of a file to a Token's list
     * @param fileName The name of the file you want to transform into a Token's list
     * @return A List of Tokens
     * @throws FileNotFoundException
     */
    static List<IToken> tokenize(String fileName) throws FileNotFoundException {return null;};
}
