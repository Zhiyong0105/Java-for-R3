import java.lang.Character.UnicodeBlock;

public class UnicodeFind {

    public void Ufind(String line) {
        char c = line.charAt(0); // String to char
        UnicodeBlock Is = Character.UnicodeBlock.of(c);
        String check = Is.toString();
        if (check.equals("HIRAGANA")) {
            System.out.println(line + ":" + "HIRAGANA");
        } else if (check.equals("KATAKANA")) {
            System.out.println(line + ":" + "KATAKANA");
        } else if (check.equals("BASIC_LATIN")) {
            if (Character.isDigit(c)) {
                System.out.println(line + ":" + "Number");
            } else if ((int) c > 64) {
                System.out.println(line + ":" + "Alphabet");
            } else {
                System.out.println(line + ":" + "Other");
            }
        } else if (check.equals("CJK_UNIFIED_IDEOGRAPHS")) {
            System.out.println(line + ":" + "Kanji");
        } else if (check.equals("HALFWIDTH_AND_FULLWIDTH_FORMS")) {
            if (Character.isDigit(c)) {
                System.out.println(line + ":" + "Number");
            } else if ((int) c > 65291) {
                System.out.println(line + ":" + "Alphabet");

            } else {
                System.out.println(line + ":" + "Other");
            }
        } else {
            System.out.println(line + ":" + "Other");
        }

    }

}