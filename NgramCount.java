
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class NgramCount {
    StringBuffer line =new StringBuffer();
    Map<String,Integer> map = new HashMap<>();
    
    private int N=0;
    public NgramCount(StringBuffer line,int N) {
        this.line =line ;
        this.N = N;

    }
    public Map<String,Integer> mapCount()
    {
        for (int i = 0; i < line.length(); i++) {
            String x = new String();
            if (i+N>line.length()) {
                x = null;
                break;
            }
            else{
                x = line.substring(i, i+N);

            }
          
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                int times = map.get(x) + 1;
                map.remove(x);
                map.put(x, times);
            }
        }
        return map;

    }
    public void print() {
        Collection<Integer> Key = map.values();
        int maxCount = Collections.max(Key);
        for (Map.Entry<String, Integer> kmap : map.entrySet()) {
            if (maxCount == kmap.getValue()) {
                System.out.printf("%s %d\n", kmap.getKey(), maxCount);

            }
        }
    }
  
    public void PandC()
    {
        map = mapCount();
        print();
       


    }

    

}