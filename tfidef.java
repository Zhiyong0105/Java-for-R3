import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class tfidef {
    ArrayList<String> list = new ArrayList<>();
    UnicodeFind uf = new UnicodeFind();
    Map<Character, Integer> map = new HashMap<>();

    public tfidef(ArrayList<String> list) {
        this.list = list;

    }

    public int Kanji_count(String str) {
        int len = str.length();
        int Kanji_count = 0;
        for (int i = 0; i < len; i++) {
            if (uf.Ufind(str.charAt(i))) {
                Kanji_count++;
            }

        }
        return Kanji_count;

    }

    public Map<Character, Integer> map_count(Map<Character, Integer> tmp, char s) {

        if (!(tmp.containsKey(s))) {
            tmp.put(s, 1);
        } else {
            int times = map.get(s) + 1;
            tmp.remove(s);
            tmp.put(s, times);
        }

        return tmp;

    }

    public Map<Character, Integer> map_count1(Map<Character, Integer> tmp, String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char s = str.charAt(i);
            if (!(tmp.containsKey(s))) {
                tmp.put(s, 1);
            } else {
                int times = tmp.get(s) + 1;
                tmp.remove(s);
                tmp.put(s, times);
            }
        }
        return tmp;
    }

    public double tf_cal(String str, char c) {
        int count = str.length();
        Map<Character, Integer> map1 = new HashMap<>();
        map1 = map_count1(map1, str);

        return (double) map1.get(c) / (double) count;
    }

    public void df_count() {
        for (String string : list) {
            Set<Character> set = new HashSet<>();
            int len = string.length();
            for (int i = 0; i < len; i++) {
                char s = string.charAt(i);
                set.add(s);
            }
            Character[] str1 = set.toArray(new Character[set.size()]);
            for (Character character : str1) {
                map = map_count(map, character);
            }

        }

    }

    public void Find_two_max(String str, Map<Character, Double> fmap) {
        System.out.println(str);
        for (int i = 0; i < 2; i++) {
            Collection<Double> key_c = fmap.values();
            double maxcount = Collections.max(key_c);
            for (Map.Entry<Character, Double> double1 : fmap.entrySet()) {
                if (maxcount == double1.getValue()) {
                    System.out.printf("%c %.4f\n", double1.getKey(), maxcount);
                    fmap.remove(double1.getKey());
                    break;

                }
            }

        }

    }
    // public int Find_D(String str)
    // {
    // int len = str.length();
    // int count =0;
    // for(int i=0;i<len;i++)
    // {
    // char c = str.charAt(i);
    // if(uf.Ufind_P(c))
    // {
    // count++;
    // }

    // }
    // return count ;
    // }

    public void tf_idf() {
        int df = 0;
        double tf = 0.0;
        double tf_idf = 0.0;
        double idf = 0.0;
        df_count();
        // System.out.println(map);
        int m = 0;
        for (String string : list) {
            int len = string.length();
            int D = list.size();
            
            

            Map<Character, Double> fmap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                char c = string.charAt(i);
                if (uf.Ufind(c)) {
                    df = map.get(c);
                    tf = tf_cal(string, c);

                    idf = Math.log((double) D / df);
                    tf_idf = idf * tf;
                    if (!(fmap.containsKey(c))) {
                        fmap.put(c, tf_idf);
                    }
                }

            }
            m++;
            if (m == 999 || m == 1000) {
                Find_two_max(string, fmap);

            }

        }

    }

}