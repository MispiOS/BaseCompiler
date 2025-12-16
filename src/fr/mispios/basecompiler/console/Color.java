package fr.mispios.basecompiler.console;

@SuppressWarnings("unused")
public enum Color {
    RESET("\033[0m"),
    // Simple Color
    BLACK("\033[0;30m"),
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    PURPLE("\033[0;35m"),
    CYAN("\033[0;36m"),
    WHITE("\033[0;37m"),

    // Bold Color
    BOLD_BLACK("\033[1;30m"),
    BOLD_RED("\033[1;31m"),
    BOLD_GREEN("\033[1;32m"),
    BOLD_YELLOW("\033[1;33m"),
    BOLD_BLUE("\033[1;34m"),
    BOLD_PURPLE("\033[1;35m"),
    BOLD_CYAN("\033[1;36m"),
    BOLD_WHITE("\033[1;37m"),

    // Underline
    UNDERLINE_BLACK("\033[4;30m"),
    UNDERLINE_RED("\033[4;31m"),
    UNDERLINE_GREEN("\033[4;32m"),
    UNDERLINE_YELLOW("\033[4;33m"),
    UNDERLINE_BLUE("\033[4;34m"),
    UNDERLINE_PURPLE("\033[4;35m"),
    UNDERLINE_CYAN("\033[4;36m"),
    UNDERLINE_WHITE("\033[4;37m"),

    // Background
    BG_BLACK("\033[40m"),
    BG_RED("\033[41m"),
    BG_GREEN("\033[42m"),
    BG_YELLOW("\033[43m"),
    BG_BLUE("\033[44m"),
    BG_PURPLE("\033[45m"),
    BG_CYAN("\033[46m"),
    BG_WHITE("\033[47m"),

    // High Intensity
    HI_BLACK("\033[0;30m"),
    HI_RED("\033[0;31m"),
    HI_GREEN("\033[0;32m"),
    HI_YELLOW("\033[0;33m"),
    HI_BLUE("\033[0;34m"),
    HI_PURPLE("\033[0;35m"),
    HI_CYAN("\033[0;36m"),
    HI_WHITE("\033[0;37m"),

    // Bold High Intensity
    BOLD_HI_BLACK("\033[1;30m"),
    BOLD_HI_RED("\033[1;31m"),
    BOLD_HI_GREEN("\033[1;32m"),
    BOLD_HI_YELLOW("\033[1;33m"),
    BOLD_HI_BLUE("\033[1;34m"),
    BOLD_HI_PURPLE("\033[1;35m"),
    BOLD_HI_CYAN("\033[1;36m"),
    BOLD_HI_WHITE("\033[1;37m"),

    // High Intensity Background
    HI_BG_BLACK("\033[0;100m"),
    HI_BG_RED("\033[0;101m"),
    HI_BG_GREEN("\033[0;102m"),
    HI_BG_YELLOW("\033[0;103m"),
    HI_BG_BLUE("\033[0;104m"),
    HI_BG_PURPLE("\033[0;105m"),
    HI_BG_CYAN("\033[0;106m"),
    HI_BG_WHITE("\033[0;107m"),
    ;

    private final String value;

    Color(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
