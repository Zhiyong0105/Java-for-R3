
import java.util.HashMap;
import java.util.Map;

public class NgramCount {
    StringBuffer line =new StringBuffer();
    Map<String,Integer> map = new HashMap<>();
    public NgramCount(StringBuffer line) {
        this.line =line ;

    }
    public Map<String,Integer> mapCount()
    {
        for (int i = 0; i < line.length(); i++) {
            String x = new String();
            if (i+6>line.length()) {
                int m = line.length()-i;
                x =line.substring(i,i+m);
            }
            else{
                x = line.substring(i, i+6);

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
    public void PandC()
    {
        map = mapCount();
        System.out.println(map);

    }

    

}