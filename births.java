

import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class births {
     public void totalBirths(FileResource fr){
        int girlCount = 0;
        int boyCount = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            if(record.get(1).equals("F")){
                System.out.println(record.get(0));
                girlCount++;
            }
            else{
                System.out.println(record.get(0));
                boyCount++;
            }
            
        }
        System.out.println("Total boys count = " + boyCount);
        System.out.println("Totla girl count = " + girlCount);
        System.out.println("Total births in the year = " + (girlCount + boyCount));
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

}
