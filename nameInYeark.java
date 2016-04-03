

import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class nameInYeark {
    
    public void whatIsNameInYear(String name,int year,int newYear,String gender){
        FileResource fr = new FileResource();//new FileResource("D:\\Windows D\\Coursera\\Java Programming\\Week 4\\mini project - programming exercise guide\\question files\\us_babynames_by_year\\yob"+year+".csv");
        FileResource fr2 = new FileResource();//new FileResource("D:\\Windows D\\Coursera\\Java Programming\\Week 4\\mini project - programming exercise guide\\question files\\us_babynames_by_year\\yob"+newYear+".csv");
        CSVParser parser_oldYear = fr.getCSVParser(false);
        CSVParser parser_newYear = fr2.getCSVParser(false);
        int old_rank = 0;
        int new_rank = 0;
        StorageResource old_male_store = new StorageResource();
        StorageResource old_female_store = new StorageResource();
        StorageResource new_male_store = new StorageResource();
        StorageResource new_female_store = new StorageResource();
        String new_name = "";
        
        for(CSVRecord record : parser_oldYear){
        if(record.get(1).equals("F")){
            old_female_store.add(record.get(0));
        }
        else{
            old_male_store.add(record.get(0));
        }
    }
    
    for(CSVRecord record2 : parser_newYear){
        if(record2.get(1).equals("F")){
            new_female_store.add(record2.get(0));
        }
        else{
            new_male_store.add(record2.get(0));
        }
    }
    
    if(gender.equals("F")){
        for(String line : old_female_store.data()){
            old_rank++;
            if(line.equals(name)){
                break;
            }
        }
    }
    else{
        for(String line : old_male_store.data()){
            old_rank++;
            if(line.equals(name)){
                break;
            }
        }
    }
    
    if(gender.equals("F")){
        for(String line : new_female_store.data()){
            new_rank++;
            if(new_rank == old_rank){
                new_name = line;
                break;
            }
        }
        
    }
    else{
        for(String line : new_male_store.data()){
            new_rank++;
            if(new_rank == old_rank){
                new_name = line;
                break;
            }
        }
    }
    
    System.out.println(name + " born in " + year + " would be " + new_name + " if she was born in " + newYear);

}

public void test(){
    whatIsNameInYear("Isabella",2012,2014,"F");
}

}
