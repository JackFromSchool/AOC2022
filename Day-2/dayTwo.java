import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.plaf.OptionPaneUI;

/*
 * Rules:
 * A = Rock
 * B = Paper
 * C = Scissors
 * 
 * X = Rock 1pt
 * Y = Paper 2pt
 * Z = Scissors 3pt
 * 
 * 3 pt draw
 * 6 pt win
 * 
 * Part 2
 * X = lose
 * Y = draw
 * Z = win
 */

public class dayTwo {
   
   public static void main(String[] args) {
      
      int pointTally = 0;

      try {
         File data = new File("input-day2.txt");
         Scanner reader = new Scanner(data);
         
         //Part 1
         /* 
         char oponentMove;
         char myMove;

         while(reader.hasNext()){
            oponentMove = reader.next().charAt(0);
            myMove = reader.next().charAt(0);

            pointTally += myMove%'W';

            if(myMove == 'X' && oponentMove == 'A' || myMove == 'Y' && oponentMove == 'B' || myMove == 'Z' && oponentMove == 'C'){
               pointTally += 3;
            }else if(myMove == 'Y' && oponentMove == 'A' || myMove == 'Z' && oponentMove == 'B' || myMove == 'X' && oponentMove == 'C'){
               pointTally += 6;
            }
         }
         */

         //Part 2
         char oponentMove;

         while(reader.hasNext()){
            oponentMove = reader.next().charAt(0);
            
            switch(reader.next().charAt(0)){
               case 'X':
                  if(oponentMove == 'A'){
                     pointTally += 3;
                  }else if(oponentMove == 'B'){
                     pointTally += 1;
                  }else{
                     pointTally += 2;
                  }
               break;

               case 'Y':
                  pointTally += 3;
                  pointTally += oponentMove%64;
               break;

               case 'Z':
                  pointTally += 6;
                  if(oponentMove == 'A'){
                     pointTally += 2;
                  }else if(oponentMove == 'B'){
                     pointTally += 3;
                  }else{
                     pointTally += 1;
                  }
            }
         }

         reader.close();
      } catch (FileNotFoundException e) {
         System.out.println("Couldn't find file");
      }

      System.out.println(pointTally);
   }

}
