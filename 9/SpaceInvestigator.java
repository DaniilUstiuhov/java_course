public class SpaceInvestigator {
    public static void main(String[] args) {
        String text = "  Hello , world.How  are you ? He said \"That's great! \" and left.She was 3 . 14 meters tall.It was well - done. ( nice work )  ";
        System.out.println("Original: [" + text + "]");
        System.out.println();
        String fixed = spaceInvestigator(text);
        System.out.println();
        System.out.println("Fixed:    [" + fixed + "]");
    }

    static String spaceInvestigator(String text) {
        text = fixLeadingTrailing(text);
        text = fixDoubleSpaces(text);
        text = fixSpaceBeforePunctuation(text);
        text = fixSpaceAfterPunctuation(text);
        text = fixDecimalPeriod(text);
        text = fixDashes(text);
        text = fixExclamationBeforeClosingQuote(text);
        text = fixSpaceInsideParentheses(text);
        return text;
    }

    // Rule 1: remove leading and trailing spaces
    static String fixLeadingTrailing(String text) {
        String fixed = text.strip();
        if (!fixed.equals(text)) System.out.println("Rule 1 applied: removed leading/trailing spaces");
        return fixed;
    }

    // Rule 2: replace multiple spaces with a single space
    static String fixDoubleSpaces(String text) {
        String fixed = text.replaceAll(" {2,}", " ");
        if (!fixed.equals(text)) System.out.println("Rule 2 applied: removed double spaces");
        return fixed;
    }

    // Rule 3: no space before punctuation marks
    static String fixSpaceBeforePunctuation(String text) {
        String fixed = text.replaceAll(" +([.,!?;:])", "$1");
        if (!fixed.equals(text)) System.out.println("Rule 3 applied: removed space before punctuation");
        return fixed;
    }

    // Rule 4: ensure space after punctuation when followed by a letter
    static String fixSpaceAfterPunctuation(String text) {
        String fixed = text.replaceAll("([.,!?;:])([A-Za-z])", "$1 $2");
        if (!fixed.equals(text)) System.out.println("Rule 4 applied: added space after punctuation");
        return fixed;
    }

    // Rule 5: no spaces around decimal period between numerals
    static String fixDecimalPeriod(String text) {
        String fixed = text.replaceAll("(\\d) *\\. *(\\d)", "$1.$2");
        if (!fixed.equals(text)) System.out.println("Rule 5 applied: removed spaces around decimal period");
        return fixed;
    }

    // Rule 6: no spaces around dash or hyphen between words or numerals
    static String fixDashes(String text) {
        String fixed = text.replaceAll("(\\w) - (\\w)", "$1-$2");
        if (!fixed.equals(text)) System.out.println("Rule 6 applied: removed spaces around dash/hyphen");
        return fixed;
    }

    // Rule 7: no space after ! or ? when followed by closing quote, paren or bracket
    static String fixExclamationBeforeClosingQuote(String text) {
        String fixed = text.replaceAll("([!?]) +([\")\\]])", "$1$2");
        if (!fixed.equals(text)) System.out.println("Rule 7 applied: removed space after ! or ? before closing quote");
        return fixed;
    }

    // Rule 8: no space inside parentheses
    static String fixSpaceInsideParentheses(String text) {
        String fixed = text.replaceAll("\\( +", "(").replaceAll(" +\\)", ")");
        if (!fixed.equals(text)) System.out.println("Rule 8 applied: removed spaces inside parentheses");
        return fixed;
    }
}
