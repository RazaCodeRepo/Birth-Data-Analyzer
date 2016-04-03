

import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class averageRank {
     public double getAverageRank(String name,String gender){
        DirectoryResource dr = new DirectoryResource();
        int fileCount = 0;
        int count = 0;
        String fileName = "";
        int rankSum = 0;
        
        for(File f : dr.selectedFiles()){
            int rank = 0;
            
           FileResource fr = new FileResource(f);
            StorageResource male_store = new StorageResource();
            StorageResource female_store = new StorageResource();
           
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
           //System.out.println(rank);
           if(rank != 0){
               rankSum += rank;
               fileCount++;
           }
           
    }
    //System.out.println("file count:" + fileCount);
    //System.out.println("sum : " + rankSum);
    double average = (double)rankSum/(double)fileCount;
    return average;
}

public void test(){
    double result = getAverageRank("Mason","M");
    System.out.println(result);
}
}
