import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class dayNine {

   private static int[] headPos = {0, 0};
   private static int[] tailPos = {0, 0};
   private static ArrayList<int[]> locations = new ArrayList<>();

   private static void handleTail() {
      boolean dontAdd = false;
      for(int i = 0; i < locations.size(); i++) {
         if(locations.get(i)[0] == tailPos[0] && locations.get(i)[1] == tailPos[1]) dontAdd = true;
      }

      if(!dontAdd){
         locations.add(new int[]{tailPos[0], tailPos[1]});
      }

      if(headPos[0] < 0 || headPos[1] < 0){
         if(headPos[0] != tailPos[0] ^ headPos[1] != tailPos[1]){
            if(Math.abs(headPos[0])-Math.abs(tailPos[0]) == 2) tailPos[0] -= 1;
            else if(Math.abs(headPos[0])-Math.abs(tailPos[0]) == -2) tailPos[0] += 1;
            else if(Math.abs(headPos[1])-Math.abs(tailPos[1]) == -2) tailPos[1] += 1;
            else if(Math.abs(headPos[1])-Math.abs(tailPos[1]) == 2) tailPos[1] -= 1;
         }
         else{
            if(Math.abs(headPos[0])-Math.abs(tailPos[0]) == 2){
               tailPos[0] -= 1;
               tailPos[1] = headPos[1];
            } 
            else if(Math.abs(headPos[0])-Math.abs(tailPos[0]) == -2) {
               tailPos[0] += 1;
               tailPos[1] = headPos[1];
            }
            else if(Math.abs(headPos[1])-Math.abs(tailPos[1]) == -2) {
               tailPos[1] += 1;
               tailPos[0] = headPos[0];
            }
            else if(Math.abs(headPos[1])-Math.abs(tailPos[1]) == 2) {
               tailPos[1] -= 1;
               tailPos[0] = headPos[0];
            }
         }
      }
      else{
         if(headPos[0] != tailPos[0] ^ headPos[1] != tailPos[1]){
            if(headPos[0]-tailPos[0] == 2) tailPos[0] += 1;
            else if(headPos[0]-tailPos[0] == -2) tailPos[0] -= 1;
            else if(headPos[1]-tailPos[1] == -2) tailPos[1] -= 1;
            else if(headPos[1]-tailPos[1] == 2) tailPos[1] += 1;
         }
         else{
            if(headPos[0]-tailPos[0] == 2){
               tailPos[0] += 1;
               tailPos[1] = headPos[1];
            } 
            else if(headPos[0]-tailPos[0] == -2) {
               tailPos[0] -= 1;
               tailPos[1] = headPos[1];
            }
            else if(headPos[1]-tailPos[1] == -2) {
               tailPos[1] -= 1;
               tailPos[0] = headPos[0];
            }
            else if(headPos[1]-tailPos[1] == 2) {
               tailPos[1] += 1;
               tailPos[0] = headPos[0];
            }
         }
      }

   }

   public static void main(String[] args) {
      
      ArrayList<String> moves = new ArrayList<>();

      try {
         
         File data = new File("input-day9.txt");
         Scanner reader = new Scanner(data);

         while(reader.hasNextLine()) {
            moves.add(reader.nextLine());
         }

      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      for(int currentMove = 0; currentMove < moves.size(); currentMove++) {
         Scanner reader = new Scanner(moves.get(currentMove));
         char temp = reader.next().charAt(0);
         int tempInt;

         
         switch(temp){
            case 'U':
            tempInt = reader.nextInt();
            for(int i = 0; i < tempInt; i++) {
               headPos[1] += 1;
               handleTail();
            }
            break;

            case 'R':
            tempInt = reader.nextInt();
            for(int i = 0; i < tempInt; i++) {
               headPos[0] += 1;
               handleTail();
            }
            break;

            case 'D':
            tempInt = reader.nextInt();
            for(int i = 0; i < tempInt; i++) {
               headPos[1] -= 1;
               handleTail();
            }
            break;

            case 'L':
            tempInt = reader.nextInt();
            for(int i = 0; i < tempInt; i++) {
               headPos[0] -= 1;
               handleTail();
            }
            break;
         }
         
      }

      

      System.out.println(locations.size());

   }

}