

import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class highestRank {
    public int highest(String name,String gender){
        int highestRank = 0;
        int tempRank = 0;
        int rank =0;
        String highestName = "";
        DirectoryResource dr = new DirectoryResource();
        StorageResource male_name = new StorageResource();
        StorageResource female_name = new StorageResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            for(CSVRecord record : parser){
                if(record.get(1).equals("F")){
                    female_name.add(record.get(0));
                }
                else{
                    male_name.add(record.get(0));
                }
            }
            if(gender.equals("M")){
                if(male_name.contains(name)==true){
                    for(String line : male_name.data()){
                        rank++;
                        if(line.equals(name)){
                            break;
                        }
                    }
                }
            }
            else{
                if(female_name.contains(name) == true){
                    for(String line : female_name.data()){
                        rank++;
                        if(line.equals(name)){
                            break;
                        }
                    }
                }
            }
            if(rank != 0){
                if(highestRank == 0){
                    highestRank = rank;
                    highestName = f.getName();
                }
                else if (rank < highestRank){
                    highestName = f.getName();
                }
            }
           
        }
        if(highestName == ""){
            return -1;
        }
        else{
            int index1 = highestName.indexOf("b");
        
            String sub_highestname = highestName.substring(index1+1,index1+5);
            int year = Integer.parseInt(sub_highestname);
            return year;
        }
        
    }
    public void test(){
       int result = 0;
       result =  highest("Mason","M");
       System.out.println("The name Mason had highest ranking in year: " + result);
    }
}
