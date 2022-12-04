import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dayFour {
   
   public static void main(String[] args) {

      int count = 0;

      try {
         
         File data = new File("input-day4.txt");
         Scanner reader = new Scanner(data);

         int firstElfStart;
         int firstElfEnd;
         int secondElfStart;
         int secondElfEnd;

         //Part 1
         /*else if((secondElfStart <= firstElfStart && secondElfEnd >= firstElfStart) || (secondElfStart <= secondElfEnd && secondElfEnd <= secondElfEnd)){
               count++;
            }
         while(reader.hasNextInt()){
            firstElfStart = reader.nextInt();
            firstElfEnd = reader.nextInt();
            secondElfStart = reader.nextInt();
            secondElfEnd = reader.nextInt();

            if(firstElfEnd >= secondElfEnd && firstElfStart <= secondElfStart){
               count++;
            }
            else if(secondElfEnd >= firstElfEnd && secondElfStart <= firstElfStart){
               count++;
            }
         }
         */

         //Part 2
         while(reader.hasNextInt()){
            firstElfStart = reader.nextInt();
            firstElfEnd = reader.nextInt();
            secondElfStart = reader.nextInt();
            secondElfEnd = reader.nextInt();

            int[] firstElfNums = new int[firstElfEnd-firstElfStart+1];

            for(int i = 0; i < firstElfNums.length; i++){
               firstElfNums[i] = i+firstElfStart;
            }

            boolean notFound = true;

            for(int i = secondElfStart; i <= secondElfEnd && notFound; i++){
               
               for(int j = 0; j < firstElfNums.length && notFound; j++){
                  if(i == firstElfNums[j]){
                     count++;
                     notFound = false;
                  }
               }
            }

         }

         reader.close();

      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      System.out.println(count);

   }

}
