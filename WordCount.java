
import java.util.Collection;
import java.util.Collections;

import java.util.HashMap;

import java.util.Map;

public class WordCount {
    Map<Character,Integer> map = new HashMap<>();
 
    public WordCount(Map<Character,Integer> map) {
        this.map =map ;

    }
    public void print() {
        Collection<Integer> Key = map.values();
        int maxCount = Collections.max(Key);
        for (Map.Entry<Character, Integer> kmap : map.entrySet()) {
            if (maxCount == kmap.getValue()) {
                System.out.printf("%s %d\n", kmap.getKey(), maxCount);

            }
        }
    }
    public void printB() {
        Collection<Integer> Key = map.values();
        int maxCount = Collections.min(Key);
        int count = 0;
        for (Map.Entry<Character, Integer> kmap : map.entrySet()) {
            if (maxCount == kmap.getValue()) {
                count++;
                
                

            }
        }
        System.out.println(count);
        for (Map.Entry<Character, Integer> kmap : map.entrySet()) {
            if (maxCount == kmap.getValue()) {
                System.out.println( kmap.getKey());
                
                break;

            }
        }
    }

}
