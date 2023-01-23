import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class read {
    public static void main(String[] args) {
        FileReader reader = null;
		BufferedReader breader = null;
        Map<String,String> Data = new HashMap<>();
        try {
           
			reader = new FileReader("2.txt");
			breader = new BufferedReader(reader);
			while(breader.readLine()!=null)
			{
				String[] spl = breader.readLine().split("\t");
				Data.put(spl[0], spl[1]);
			}
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally {
			try {
				breader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
        System.out.println();
    }
    
}
