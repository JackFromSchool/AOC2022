import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class dayEleven {

   public static void main(String[] args) {
      
      ArrayList<Monkey> monkeyList = new ArrayList<>();

      try {
         File data = new File("input-day11.txt");
         Scanner reader = new Scanner(data);

         String temp;
         ArrayList<BigInteger> items = new ArrayList<>();
         char opperation;
         String opperationTo;
         BigInteger test;
         int throwTrue;
         int throwFalse;


         while(reader.hasNext()) {
            while(true) {
               temp = reader.next();
               if(temp.equals("+") || temp.equals("-") || temp.equals("*")) {
                  break;
               } else {
                  items.add(new BigInteger(temp));
               }
            }
            opperation = temp.charAt(0);
            opperationTo = reader.next();
            test = new BigInteger(reader.next());
            throwTrue = reader.nextInt();
            throwFalse = reader.nextInt();

            monkeyList.add(new Monkey(new ArrayList<>(items), opperation, opperationTo, test, throwTrue, throwFalse));

            items.clear();
         }

         reader.close();


      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      int productOfDivisors = 1;
      for(Monkey monkey : monkeyList) {
         productOfDivisors *= monkey.test.intValue();
      }

      for(int i = 0; i < 10000; i++) {
         System.out.println("Cycle number:"+i);
         for(Monkey monkey : monkeyList) {
            monkey.doMonkeyBuisness(monkeyList, productOfDivisors);
         }
      }

      ArrayList<Long> inspectionsList = new ArrayList<>();
      for(Monkey monkey : monkeyList) {
         System.out.println(monkey.inspections);
         inspectionsList.add(monkey.inspections);
      }

      Collections.sort(inspectionsList);

      System.out.println(inspectionsList.get(inspectionsList.size()-1)*inspectionsList.get(inspectionsList.size()-2));

      /* for(Monkey monkey : monkeyList) {
         monkey.printMonkeyInfo();
      } */
   }

}