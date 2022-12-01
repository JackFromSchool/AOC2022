import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class dayOne {

   public static void main(String[] args) {
      
      ArrayList<Integer> numbers = new ArrayList<Integer>();

      try {
         File data = new File("input-day1.txt");
         Scanner reader = new Scanner(data);

         String temp;
         while(reader.hasNextLine()){
            temp = reader.nextLine();
            if(temp != ""){
               numbers.add(Integer.parseInt(temp));
            }else{
               numbers.add(-1);
            }
         }

         reader.close();
      } catch (FileNotFoundException e) {
         System.out.println("File was not found");
      }

      int i = 0;
      int current = 0;
      
      ArrayList<Integer> caloriesOfEachElf = new ArrayList<Integer>();

      while(i < numbers.size()){
         if(numbers.get(i) != -1){
            current += numbers.get(i);
         }else{
            caloriesOfEachElf.add(current);
            current = 0;
         }
         i++;
      }

      Collections.sort(caloriesOfEachElf);

      int sum = 0;
      for(int j = caloriesOfEachElf.size()-1; j > caloriesOfEachElf.size()-4; j--){
         sum += caloriesOfEachElf.get(j);
      }

      System.out.println(sum);
   }
   
}