

import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class name {
    public String getName(int year,int rank,String gender){
        FileResource fr = new FileResource();//new FileResource("D:\\Windows D\\Coursera\\Java Programming\\Week 4\\mini project - programming exercise guide\\question files\\us_babynames_by_year\\yob"+year+".csv");
        StorageResource male_store = new StorageResource();
        StorageResource female_store = new StorageResource(); 
        int csv_rank = 0;
        String name = "";
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser){
            if(record.get(1).equals("F")){
                female_store.add(record.get(0));
            }
                else{
                    male_store.add(record.get(0));
                }
            }
        if(gender.equals("F")){
           for(String line : female_store.data()){
               
               csv_rank++;
               if(csv_rank == rank){
                   name = line;
                   break;
                }
                else{
                    name = "no name";
                }
            }
        }
        else{
            for(String line : male_store.data()){
               csv_rank++;  
               if(csv_rank == rank){
                   name = line;
                   break;
                   
                }
                else{
                  name = "no name";  
                  }
            }
        }
        return name;
    }
    
    public void testGetName(){
        String result = getName(1982,2,"M");
        System.out.println("The 2nd most popular name in the year was: " + result);
    }
}

