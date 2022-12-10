import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class dayTen {

   private static int displayX = 0;
   private static int displayY = 0;
   private static int register = 1;

   private static void tick() {
      if(displayX == 40 && displayY == 5) return;

      if(displayX == 40) {
         System.out.println();
         displayX = 0;
         displayY++;
      }

      if(displayX <= register+1 && displayX >= register-1) {
         System.out.print("#");
      }
      else {
         System.out.print(".");
      }
      displayX++;
   }

   public static void main(String[] args) {
      
      ArrayList<String> commands = new ArrayList<>();

      try {
         File data = new File("input-day10.txt");
         Scanner reader = new Scanner(data);

         while(reader.hasNextLine()) {
            commands.add(reader.nextLine());
         }

         reader.close();
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      /* Part 1
      int sumStrength = 0;
      int cycle = 0;

      for(String command : commands) {
         Scanner reader = new Scanner(command);

         if(reader.next().equals("noop")) {
            cycle++;
            for(int i = 20; i < 1000; i+= 40) {
               if(cycle == i) {
                  sumStrength += i*register;
               }
            }
         }
         else {
            cycle++;
            for(int i = 20; i < 1000; i+= 40) {
               if(cycle == i) {
                  sumStrength += i*register;
               }
            }
            cycle++;
            for(int i = 20; i < 1000; i+= 40) {
               if(cycle == i) {
                  sumStrength += i*register;
               }
            }
            register += reader.nextInt();
         }
         reader.close();
      }

      System.out.println(sumStrength);
      */

      //Part 2
      for(String command : commands) {
         Scanner reader = new Scanner(command);

         if(reader.next().equals("noop")) {
            tick();
         }
         else {
            tick();
            tick();
            register += reader.nextInt();
         }
         reader.close();
      }

   }

}