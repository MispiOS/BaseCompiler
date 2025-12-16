package fr.mispios.basecompiler.console;

/**
 * Use this class as a quick <code>System.out</code> with some colors
 */
@SuppressWarnings("unused")
public class Console {
    public static void print(String toPrint) {
        System.out.print(toPrint);
    }

    public static void println(String toPrint) {
        print(toPrint + "\n");
    }

    public static void printError(String error) {
        println(Color.BOLD_RED + "ERROR : " + Color.RED + error + Color.RESET);
    }

    public static void printInfo(String info) {
        println(Color.BOLD_BLUE + "INFO : " + Color.BLUE + info + Color.RESET);
    }

    public static void printWarning(String warning) {
        println(Color.BOLD_YELLOW + "WARNING : " + Color.YELLOW + warning + Color.RESET);
    }
}