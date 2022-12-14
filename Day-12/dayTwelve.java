import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
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
      System.out.println(EXPOS+" "+EYPOS);

      System.out.println(doSearch());

   }

   public static void printMap() {
      for(int y = 0; y < map[0].length; y++) {
         for(int x = 0; x < map.length; x++) {
            System.out.print(map[x][y]);
         }
         System.out.println();
      }
   }

   private static int doSearch() {
      
      ArrayList<Node> open = new ArrayList<>();
      ArrayList<Node> closed = new ArrayList<>();

      open.add(new Node(SXPOS, SYPOS, 0, 'a'));

      while(!open.isEmpty()) {
         Node current = open.get(0);
         for(Node node : open) {
            if(node.fVal(EXPOS, EYPOS) == current.fVal(EXPOS, EYPOS)) {
               if(node.gVal < current.gVal) {
                  current = node;
               }
            } else {
               if(node.fVal(EXPOS, EYPOS) < current.fVal(EXPOS, EYPOS)) {
                  current = node;
               }
            } 
         }
         
         ArrayList<Node> neighbors = new ArrayList<>();

         closed.add(current);
         open.remove(current);

         //System.out.println(current.x+" "+current.y);
         if(current.x == EXPOS && current.y == EYPOS) {
            System.out.println("reached the end");
            return current.gVal;
         }
         int xToCheck = 0;
         int yToCheck = 0;
         for(int i = 0; i < 4; i++) {
            if(i == 0){
               xToCheck = current.x+1; yToCheck = current.y;
            }
            if(i == 1) {
               xToCheck = current.x; yToCheck = current.y+1;
            }
            if(i == 2) {
               xToCheck = current.x-1; yToCheck = current.y;
            }
            if(i == 3) {
               xToCheck = current.x; yToCheck = current.y-1;
            }
            if(xToCheck < map.length && xToCheck > -1 && yToCheck > -1 && yToCheck < map[0].length){
               if(map[xToCheck][yToCheck] == current.height || map[xToCheck][yToCheck] == current.height+1 || (map[xToCheck][yToCheck] == 'E' && current.height == 'z' || current.height == 'y')) {
                  boolean isClosed = false;
                  for(Node node : closed) {
                     if(node.x == xToCheck && node.y == yToCheck) {
                        isClosed = true;
                     }
                  }
                  if(!isClosed) {
                     neighbors.add(new Node(xToCheck, yToCheck, current.gVal+1, map[xToCheck][yToCheck]));
                  }
               }
            } 
         } 
         
         for(Node node : neighbors) {
            if(node.gVal > current.gVal+1) {
               node.gVal = current.gVal+1;
            }
            boolean inList = false;
            for(Node node2 : open) {
               if(node2.x == node.x && node2.y == node.y) {
                  inList = true;
               }
            }
            if(!inList) {
               open.add(node);
            }
         }
      }
      
      return 0;
      
   }

}
