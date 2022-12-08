import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dayEight {

   private static int[][] treeArray = new int[99][99];

   private static boolean isVisible(int x, int y) {
      int value = treeArray[x][y];
      for(int i = x-1; i >= 0; i--){
         if(treeArray[i][y] >= value) {
            break;
         }
         else if(i == 0) {
            return true;
         }
      }
      for(int i = y-1; i >= 0; i--){
         if(treeArray[x][i] >= value) {
            break;
         }
         else if(i == 0) {
            return true;
         }
      }
      for(int i = x+1; i < treeArray.length; i++){
         if(treeArray[i][y] >= value) {
            break;
         }
         else if(i == treeArray.length-1) {
            return true;
         }
      }
      for(int i = y+1; i < treeArray[x].length; i++){
         if(treeArray[x][i] >= value) {
            break;
         }
         else if(i == treeArray.length-1) {
            return true;
         }
      }
      return false;
   }

   private static int scenicScore(int x, int y) {
      int value = treeArray[x][y];
      int up = 0; int down = 0; int left = 0; int right = 0;
      for(int i = x-1; i >= 0; i--){
         up++;
         if(treeArray[i][y] >= value) {
            break;
         }
      }
      for(int i = y-1; i >= 0; i--){
         left++;
         if(treeArray[x][i] >= value) {
            break;
         }
      }
      for(int i = x+1; i < treeArray.length; i++){
         down++;
         if(treeArray[i][y] >= value) {
            break;
         }
      }
      for(int i = y+1; i < treeArray[x].length; i++){
         right++;
         if(treeArray[x][i] >= value) {
            break;
         }
      }
      return up*down*right*left;
   }

   public static void main(String[] args) {

      try {
         File data = new File("input-day8.txt");
         Scanner reader = new Scanner(data);

         for(int i = 0; i < 99; i++) {
            String temp = reader.nextLine();
            for(int j = 0; j < 99; j++) {
               treeArray[i][j] = Integer.parseInt(temp.substring(j, j+1));
            }
         }
         
         reader.close();
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      //Part 1
      //Since all edges are visible and we don't check edges we add the number of edge trees
      int count = 392;

      for(int i = 1; i < 98; i++) {
         for(int j = 1; j < 98; j++) {
            if(isVisible(i, j)) {
               count++;
            }
         }
      }

      System.out.println("Count of visible trees: "+count);

      //Part 2
      int best = Integer.MIN_VALUE;

      for(int i = 1; i < 98; i++) {
         for(int j = 1; j < 98; j++) {
            if(scenicScore(i, j) > best) {
               best = scenicScore(i, j);
            }
         }
      }

      System.out.println("Score of most scenic tree: "+best);

   }

}