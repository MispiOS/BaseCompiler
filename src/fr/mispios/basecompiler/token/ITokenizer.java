package fr.mispios.basecompiler.token;

import java.util.List;

public interface ITokenizer {
    List<IToken> tokenize(String content);
}
