import java.lang.Character.UnicodeBlock;

public class UnicodeFind {

    public boolean Ufind_P(char c) {
        //char c = line.charAt(0); // String to char
        UnicodeBlock Is = Character.UnicodeBlock.of(c);
        String check = Is.toString();
        // if (check.equals("HIRAGANA")) {
        //     System.out.println(line + ":" + "HIRAGANA");
        // } else if (check.equals("KATAKANA")) {
        //     System.out.println(line + ":" + "KATAKANA");
        // } else if (check.equals("BASIC_LATIN")) {
        //     if (Character.isDigit(c)) {
        //         System.out.println(line + ":" + "Number");
        //     } else if (Character.isLetter(c)) {
        //         System.out.println(line + ":" + "Alphabet");
        //     } else {
        //         System.out.println(line + ":" + "Other");
        //     }
        // } else if (check.equals("CJK_UNIFIED_IDEOGRAPHS")) {
        //     System.out.println(line + ":" + "Kanji");
        // } else if (check.equals("HALFWIDTH_AND_FULLWIDTH_FORMS")) {
        //     if (Character.isDigit(c)) {
        //         System.out.println(line + ":" + "Number");
        //     } else if ((int) c > 65291) {
        //         System.out.println(line + ":" + "Alphabet");

        //     } else {
        //         System.out.println(line + ":" + "Other");
        //     }
        // } else {
        //     System.out.println(line + ":" + "Other");
        // }
        int ic = (int)c;
        if(check.equals("CJK_UNIFIED_IDEOGRAPHS"))
        {
            return true;
        }
        else if (check.equals("BASIC_LATIN"))
        {
            if(Character.isDigit(c))
            {
                return true;
            }
            else if ((ic>=91&&ic<=122)||(ic>=65&&ic<=90))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (check.equals("HALFWIDTH_AND_FULLWIDTH_FORMS"))
        {
            if(Character.isDigit(c))
            {
                return true;
            }
            else if((ic>=65313&&ic<=65338)||(ic>=65345&&ic<=65370))
            {
                return true;
            }
            else 
            {
                return false;
            }
            
        }
        else 
        {
            return false;
        }
       

    }
    public boolean Ufind(char c)
    {
        UnicodeBlock Is = Character.UnicodeBlock.of(c);
        String check = Is.toString();
        if(check.equals("CJK_UNIFIED_IDEOGRAPHS"))
        {
            return true;
        }
        else{
            return false;
        }
    }

}