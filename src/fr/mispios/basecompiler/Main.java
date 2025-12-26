package fr.mispios.basecompiler;

import fr.mispios.basecompiler.console.Console;
import fr.mispios.basecompiler.token.IToken;
import fr.mispios.basecompiler.token.Tokenizer;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) { // the only needed argument is the base file
            Console.printError("Invalid arguments number ! Got 0, minimum 1.");
            return;
        }

        HashMap<String, List<IToken>> filesTokens = new HashMap<>();

        for(String file : args) {
            Console.printInfo("Tokenization of " + file + "...");
            try {
                List<IToken> tokens = Tokenizer.tokenize(file);
                if(tokens != null) {
                    filesTokens.put(file, tokens);
                }
                Console.printInfo(file + " successfully tokenized");
            } catch (FileNotFoundException e) {
                Console.printError(file + " is not a file !");
            }
        }
    }
}
