import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class dayFive {

   public static void main(String[] args) {
      
      //This is not a good way of doing this just felt like i should clarify i know that
      char[][] craneArea = 
      {
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' ,' '},
         {'N', ' ', ' ', 'C', ' ', 'Z', ' ', ' ' ,' '},
         {'Q', 'G', ' ', 'V', ' ', 'S', ' ', ' ' ,'V'},
         {'L', 'C', ' ', 'M', ' ', 'T', ' ', 'W', 'L'},
         {'S', 'H', ' ', 'L', ' ', 'C', 'D', 'H', 'S'},
         {'C', 'V', 'F', 'D', ' ', 'D', 'B', 'Q', 'F'},
         {'Z', 'T', 'Z', 'T', 'C', 'J', 'G', 'S', 'Q'},
         {'P', 'P', 'C', 'W', 'W', 'F', 'W', 'J', 'C'},
         {'T', 'L', 'D', 'G', 'P', 'P', 'V', 'N', 'R'},
      };

      int countinit= 0;
      int countfinal = 0;

      for(int x = 0; x < craneArea[0].length; x++){
         for(int y = 0; y < craneArea.length; y++){
            if(craneArea[y][x]!=' ') countinit++;
         }
      }

      try {
         
         File data = new File("input-day3.txt");
         Scanner reader = new Scanner(data);

         int countToMove;
         int from;
         int to;

         while(reader.hasNextInt()){

            ArrayList<Character> valuesToMove = new ArrayList<Character>();
            int startPoint = 61;
            
            countToMove = reader.nextInt();
            from = reader.nextInt()-1;
            to = reader.nextInt()-1;

            for(int i = 0; i < craneArea.length; i++){
               if(craneArea[i][to] != ' '){
                  startPoint = i-1;
                  break;
               }
            }

            for(int i = 0; i < craneArea.length && countToMove != 0; i++){
               if(craneArea[i][from] != ' '){
                  //Part 2 <-
                  //made the array list add at index of 0 for part 2 as opposed to not including an index in part 1
                  valuesToMove.add(0, craneArea[i][from]);
                  craneArea[i][from] = ' ';
                  countToMove--;
               }
            }

            int indexForList = 0;
            
            for(int i = startPoint; i > -1 && indexForList != valuesToMove.size(); i--){
               craneArea[i][to] = valuesToMove.get(indexForList);
               indexForList++;
            }
            
            /* 
            for(int x = 0; x < craneArea[0].length; x++){
               for(int y = 0; y < craneArea.length; y++){
                  System.out.print(craneArea[y][x]+",");
               }
               System.out.println();
            }
            System.out.println(startPoint);
            System.out.println();
            */

         }

         reader.close();

      } catch (FileNotFoundException e) {
         
         System.out.println("File not found");

      }

      String message = "";

      for(int x = 0; x < craneArea[0].length; x++){
         for(int y = 0; y < craneArea.length; y++){
            if(craneArea[y][x] != ' '){
               message += craneArea[y][x];
               break;
            }
         }
      }

      for(int x = 0; x < craneArea[0].length; x++){
         for(int y = 0; y < craneArea.length; y++){
            if(craneArea[y][x]!=' ') countfinal++;
         }
      }

      System.out.println(message);

      System.out.println(countinit);
      System.out.println(countfinal);

   }

}