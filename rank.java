import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class rank {
    public int getRank(int year,String name,String gender){
       int rank = 0;
        String csv_gender = "";
        
        FileResource fr = new FileResource();//new FileResource("D:\\Windows D\\Coursera\\Java Programming\\Week 4\\mini project - programming exercise guide\\question files\\us_babynames_by_year\\yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        StorageResource male_store = new StorageResource();
        StorageResource female_store = new StorageResource();
       for(CSVRecord record : parser){
          if(record.get(1).equals("F")){
             female_store.add(record.get(0));
          }
          else{
              male_store.add(record.get(0));
          }
       }

       if(gender.equals("F")){
           if(female_store.contains(name) == true){
               for(String line : female_store.data()){
                   rank++;
                   if(line.equals(name)){
                       break;
                    }
                }
            }
        }
        
        else{
           if(male_store.contains(name) == true){
               for(String line : male_store.data()){
                   rank++;
                   if(line.equals(name)){
                       break;
                    }
                }
            }
        }
        
        if(rank == 0){
            rank = -1;
        }
        return rank;
    }
        
   
    
    public void testGetRank(){
        int rank = getRank(2012,"Mason","M");
        System.out.println(rank);
    }
}
