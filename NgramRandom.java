

import java.util.HashMap;
import java.util.Map;

public class NgramRandom {
    StringBuffer line = new StringBuffer();
    private int N;
    Map<String, Map<Character, Integer>> map = new HashMap<>();

    public NgramRandom(StringBuffer line, int N) {
        this.line = line;
        this.N = N;

    }

    public String str(int i) {
        String s = new String();
        int len = line.length();
        if (i + N > len) {
            s = null;
        } else {
            s = line.substring(i, i + N);
        }
        return s;

    }

    public void Count() {
        String s = new String();
        for (int i = 0; i < line.length(); i++) {
            s = str(i);
            if (s == null) {
                break;
            }
            Map<Character, Integer> cmap = new HashMap<>();
            String sN = s.substring(0, N - 1);
            String s1 = s.substring(N - 1);
            char c = s1.charAt(0);
            if (!(map.containsKey(sN))) {
                if (!(cmap.containsKey(c))) {
                    cmap.put(c, 1);
                }
                map.put(sN, cmap);
            } else {
                Map<Character, Integer> cmap1 = new HashMap<>();
                cmap1 = map.get(sN);
                if (!(cmap1.containsKey(c))) {
                    cmap1.put(c, 1);
                    map.put(sN,cmap1);
                } else {
                    int times = cmap1.get(c) + 1;
                    cmap1.remove(c);
                    cmap1.put(c, times);
                    map.remove(sN, cmap1);
                    map.put(sN, cmap1);
                }

            }
        }
    }

    public String Genstr(String ct) {
        int count = 1000;// 生成回数
        int len = 0;
        Map<Character, Integer> gmap = new HashMap<>();
        String tmp = ct;
        String c = new String();
        for (int i = 0; i < count; i++) {
            gmap = map.get(tmp);
            RandomFile rf = new RandomFile(gmap);
            /* 末尾の停止*/
            if (gmap == null) {
                return ct;
            }
            c = rf.random();
            ct += c;
            tmp = ct;
            len = tmp.length();

            tmp = tmp.substring(len - N + 1, len);
            // System.out.print(tmp);
        }

        return ct;
    }

    public void print() {
        Count();
        String context = new String();
        context = line.substring(0, N - 1);
        context = Genstr(context);
        System.out.println(context);

    }

}
