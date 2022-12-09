import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class dayNine {

   private static int[] headdPos = {1000, 1000};
   private static int[] tail1Pos = {1000, 1000};
   private static int[] tail2Pos = {1000, 1000};
   private static int[] tail3Pos = {1000, 1000};
   private static int[] tail4Pos = {1000, 1000};
   private static int[] tail5Pos = {1000, 1000};
   private static int[] tail6Pos = {1000, 1000};
   private static int[] tail7Pos = {1000, 1000};
   private static int[] tail8Pos = {1000, 1000};
   private static int[] tail9Pos = {1000, 1000};
   private static ArrayList<int[]> allNodes = new ArrayList<>();

   private static ArrayList<int[]> locations = new ArrayList<>();

   private static void handleTail(int[] headPos, int[] tailPos) {
      boolean dontAdd = false;
      for(int i = 0; i < locations.size(); i++) {
         if(locations.get(i)[0] == tailPos[0] && locations.get(i)[1] == tailPos[1]) dontAdd = true;
      }

      if(!dontAdd && tailPos[0] == tail9Pos[0] && tailPos[1] == tail9Pos[1]){
         locations.add(new int[]{tailPos[0], tailPos[1]});
      }

      if((headPos[0]-tailPos[0] == -2 || headPos[0]-tailPos[0] == 2) && ){
         if(headPos[0]-tailPos[0] == 2){
            tailPos[0] += 1;
            tailPos[1] += 1;
         }
         else if(headPos[0]-tailPos[0] == -2) {
            tailPos[0] += 1;
            tailPos[1] += 1;
         }
         else if(headPos[1]-tailPos[1] == -2) {
            tailPos[0] += 1;
            tailPos[1] += 1;
         }
         else if(headPos[1]-tailPos[1] == 2) {
            tailPos[0] += 1;
            tailPos[1] += 1;
         }
      }
      else if(headPos[0] != tailPos[0] ^ headPos[1] != tailPos[1]){
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

   public static void main(String[] args) {
      
      ArrayList<String> moves = new ArrayList<>();
      allNodes.add(headdPos);
      allNodes.add(tail1Pos);
      allNodes.add(tail2Pos);
      allNodes.add(tail3Pos);
      allNodes.add(tail4Pos);
      allNodes.add(tail5Pos);
      allNodes.add(tail6Pos);
      allNodes.add(tail7Pos);
      allNodes.add(tail8Pos);
      allNodes.add(tail9Pos);


      try {
         
         File data = new File("input-day9.txt");
         Scanner reader = new Scanner(data);

         while(reader.hasNextLine()) {
            moves.add(reader.nextLine());
         }
         reader.close();

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
               headdPos[1] += 1;
               for(int k = 0; k < allNodes.size()-1; k++) {
                  handleTail(allNodes.get(k), allNodes.get(k+1));
               }
            }
            break;

            case 'R':
            tempInt = reader.nextInt();
            for(int i = 0; i < tempInt; i++) {
               headdPos[0] += 1;
               for(int k = 0; k < allNodes.size()-1; k++) {
                  handleTail(allNodes.get(k), allNodes.get(k+1));
               }
            }
            break;

            case 'D':
            tempInt = reader.nextInt();
            for(int i = 0; i < tempInt; i++) {
               headdPos[1] -= 1;
               for(int k = 0; k < allNodes.size()-1; k++) {
                  handleTail(allNodes.get(k), allNodes.get(k+1));
               }
            }
            break;

            case 'L':
            tempInt = reader.nextInt();
            for(int i = 0; i < tempInt; i++) {
               headdPos[0] -= 1;
               for(int k = 0; k < allNodes.size()-1; k++) {
                  handleTail(allNodes.get(k), allNodes.get(k+1));
               }
            }
            break;
         }
         
      }

      for(int k = 0; k < allNodes.size()-1; k++) {
         handleTail(allNodes.get(k), allNodes.get(k+1));
      }

      
      for(int i = 0; i < locations.size(); i++) {
         System.out.println((locations.get(i)[0]-1000)+" "+(locations.get(i)[1]-1000));
      }
      

      System.out.println(locations.size());

      //2175 too low works with example case
   }

}