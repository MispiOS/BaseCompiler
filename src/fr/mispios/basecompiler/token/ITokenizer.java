package fr.mispios.basecompiler.token;

import java.io.FileNotFoundException;
import java.util.List;

public interface ITokenizer {
    List<IToken> tokenize(String fileName) throws FileNotFoundException;
}
