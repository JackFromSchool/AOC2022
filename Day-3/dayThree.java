import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class dayThree {
   
   public static void main(String[] args) {
      
      ArrayList<String> itemsLists = new ArrayList<String>();
      int points = 0;

      try {
         File data = new File("input-day3.txt");
         Scanner reader = new Scanner(data);

         reader.close();
         while(reader.hasNextLine()){
            itemsLists.add(reader.next());
         }


      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      //Part 1
      /*

      boolean succeeded = false;

      for(int z = 0; z < itemsLists.size(); z++){

         for(int i = 0; i < itemsLists.get(z).length()/2; i++){

            for(int j = itemsLists.get(z).length()/2; j < itemsLists.get(z).length(); j++){

               if(itemsLists.get(z).charAt(i) == itemsLists.get(z).charAt(j) && !succeeded){

                  if(itemsLists.get(z).charAt(i) >= 65 && itemsLists.get(z).charAt(i) <= 90){
                     points += (itemsLists.get(z).charAt(i)%64)+26;
                     succeeded = true;
                     break;
                  }else{
                     points += itemsLists.get(z).charAt(i)%96;
                     succeeded = true;
                     break;
                  }
               }
            }
         }
         succeeded = false;
      }
      */

      //Part 2
      char winner = ' ';

      for(int x = 0; x < itemsLists.size(); x += 3){

         for(int y = 0; y < itemsLists.get(x).length(); y++){

            for(int z = 0; z < itemsLists.get(x+1).length(); z++){

               if(itemsLists.get(x).charAt(y) == itemsLists.get(x+1).charAt(z)){

                  for(int zz = 0; zz < itemsLists.get(x+2).length(); zz++){

                     if(itemsLists.get(x).charAt(y) == itemsLists.get(x+2).charAt(zz)){
                        winner = itemsLists.get(x).charAt(y);
                     }
                  }
               }
            }
         }
         if(winner >= 65 && winner <= 90){
            points += (winner%64)+26;
         }else{
            points += winner%96;
         }
      }

      System.out.println(points);

   }

}
