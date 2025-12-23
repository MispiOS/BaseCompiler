package fr.mispios.basecompiler;

import fr.mispios.basecompiler.console.Console;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) { // the only needed argument is the base file
            Console.printError("Invalid arguments number ! Got 0, minimum 1.");
            return;
        }
        // TODO
    }
}
