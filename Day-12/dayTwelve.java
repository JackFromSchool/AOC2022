import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dayTwelve {

   public static char[][] map;
   public static int SXPOS;
   public static int SYPOS;
   public static int EXPOS;
   public static int EYPOS;
   
   public static void main(String[] args) {
      
      try {
         File data = new File("input-day12.txt");
         Scanner reader = new Scanner(data);

         int xlen = reader.nextLine().length();
         int ylen = 1;
         while(reader.hasNextLine()) {
            ylen++;
            reader.nextLine();
         }

         map = new char[xlen][ylen];

         reader.close();
         reader = new Scanner(data);

         for(int y = 0; y < map[0].length; y++) {
            String temp = reader.nextLine();
            for(int x = 0; x < map.length; x++) {
               map[x][y] = temp.charAt(x);
            }
         }

         reader.close();
         
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      for(int y = 0; y < map[0].length; y++) {
         for(int x = 0; x < map.length; x++) {
            if(map[x][y] == 'S') {
               SXPOS = x;
               SYPOS = y;
            }
            if(map[x][y] == 'E') {
               EXPOS = x;
               EYPOS = y;
            }
         }
      }

   }

   public static void printMap() {
      for(int y = 0; y < map[0].length; y++) {
         for(int x = 0; x < map.length; x++) {
            System.out.print(map[x][y]);
         }
         System.out.println();
      }
   }

   private static int getFVal(int x, int y, int previousGVal) {
      int hVal = Math.abs(EXPOS-x)+Math.abs(EYPOS-y);
      int gVal = previousGVal++;
      return hVal+gVal;
   }

   private static int doSearch() {
      

      return 0;
   }

}
