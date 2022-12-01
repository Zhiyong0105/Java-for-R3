
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFile {
    Map<Character,Integer> map = new HashMap<>();
    Random random = new Random();
    public RandomFile(Map<Character,Integer>map)
    {
        this.map = map;
    }
    public int FindBound()
    {
        int nmax =0;
        Collection<Integer> values = map.values();
        Object[] va =  values.toArray();
        for(int i = 0;i<va.length;i++)
        {
            nmax += (int)va[i];

        }
        return nmax;
    }
    public void randomP()
    {
        int r =0;
        int nmax = FindBound();
        int count = 0;
        int keyi=0;
       


       
        for (Map.Entry<Character,Integer> kmap : map.entrySet()) {
            r = random.nextInt(nmax);
            keyi += kmap.getValue();
            
            if (r-keyi<0)
            {
                System.out.print(kmap.getKey());

            }
            count++;
            if (count>1000)
            {
                break;
            }
        }

        
    }
}
