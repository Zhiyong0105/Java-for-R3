import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


 public class ReadFile {
//     public static  Map<Character,Integer> Mapsort(Map<Character,Integer> map)
//     {
//         List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
//         Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
//             public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2)
//             {
//                 return o2.getValue()- o1.getValue();
//             }
//         });
//         LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<>();
//         for(Map.Entry<Character,Integer> e: list)
//         {
//             lhm.put(e.getKey(),e.getValue());
//         }
//         return lhm;
      

//     }
//    public  void print(Map<Character,Integer> map)
//    {
//     map.values();
  
//    }

    public static void main(String[] args) {
        String filename = "1.txt";
        String encoding = "utf8";
       // UnicodeFind readfile = new UnicodeFind();
        InputStream is = null;
        ReadFile rd = new ReadFile();
        StringBuffer Aline = new StringBuffer();
        Map<Character,Integer> map = new HashMap<>();
        
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            throw (new Error(e));
        }

        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(is, encoding);
        } catch (UnsupportedEncodingException e) {
            throw (new Error(e));
        }

        BufferedReader br = new BufferedReader(isr);

        while (true) {
            String line = null;
            
           
            try {
                line = br.readLine();
                if (line == null)
                break;
                line.replace("\n", "");
                Aline.append(line);
               
                    // for (int i = 0; i < line.length(); i++) {
                    //     char x = line.charAt(i);
                    //     if (!map.containsKey(x)) {
                    //         map.put(x, 1);
                    //     } else {
                    //         int times = map.get(x) + 1;
                    //         map.remove(x);
                    //         map.put(x, times);
                    //     }
                    // }
                    
                    
            } catch (IOException e) {
                throw (new Error(e));
            }
        }
       //System.out.println(Aline);
        NgramCount nc = new NgramCount(Aline);
        nc.PandC();


        try {
            br.close();
        } catch (IOException e) {
            throw (new Error(e));
        }
        //WordCount wc = new WordCount(map);
        // RandomFile rf = new RandomFile(map);
        // rf.randomP();
      // wc.print();
    }
}
