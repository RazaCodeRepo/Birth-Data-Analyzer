

import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class birthsRankedHigher {
    public int getRank(int year,String name,String gender, FileResource fr){
       int rank = 0;
        String csv_gender = "";
        
        //FileResource fr = new FileResource();//new FileResource("D:\\Windows D\\Coursera\\Java Programming\\Week 4\\mini project - programming exercise guide\\question files\\us_babynames_by_year\\yob"+year+".csv");
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
    public void getTotalBirthsRankedHigher(int year,String name,String gender){
        
        FileResource fr = new FileResource();
        int original_rank = getRank(year,name,gender, fr);
        int lineCount = 0;
        //FileResource fr = new FileResource();//new FileResource("D:\\Windows D\\Coursera\\Java Programming\\Week 4\\mini project - programming exercise guide\\question files\\us_babynames_by_year\\yob"+year+".csv");
        
        CSVParser parser = fr.getCSVParser(false);
        
        StorageResource store_male = new StorageResource();
        StorageResource store_female = new StorageResource();
        
        int sum = 0;
        
        for(CSVRecord record : parser){
            if(record.get(1).equals("F")){
                store_female.add(record.get(2));
                
            }
            else{
                store_male.add(record.get(2));
            }
        }
       // System.out.println(store_male.data());
        if(gender.equals("M")){
            
            
                
                for(String line : store_male.data()){
                    
                   
                    int num = Integer.parseInt(line);
                    
                    sum += num;
                   
                    
                    
                    lineCount++;
  
                    if(lineCount == (original_rank-1)){
                        break;
                    }
                   
                }
            
        }
        else{
              for(String line : store_female.data()){
                    
                   
                    int num = Integer.parseInt(line);
                    
                    sum += num;
                   
                    
                    
                    lineCount++;
  
                    if(lineCount == (original_rank-1)){
                        break;
                    }
                   
                }
        
        }
        
        System.out.println("Total Birth Names Ranked Higher Than The Name Ethan: " + sum);
        
        
   }
    
    public void test(){
       getTotalBirthsRankedHigher(2012,"Ethan","M");
    }
}
