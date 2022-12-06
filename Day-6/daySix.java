import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class daySix {

   public static void main(String[] args) {
      
      int count = 0;
      String allChars = "";
      ArrayList<Character> listOfNew = new ArrayList<Character>();

      try {
         
         File data = new File("input-day4.txt");
         Scanner reader = new Scanner(data);
         allChars = reader.next();
         reader.close();

      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }
      
      boolean failed = false;

      while(count < allChars.length()){
         for(int i = count; i < count+14; i++){
            for(int j = 0; j < listOfNew.size(); j++){
               if(allChars.charAt(i) == listOfNew.get(j)){
                  failed = true;
                  listOfNew.clear();
                  break;
               }
            }
            if(failed){
               failed = false;
               break;
            }else{
               listOfNew.add(allChars.charAt(i));
            }
         }
         //Swap to = 4 for part 1
         if(listOfNew.size() == 14){
            break;
         }
         count++;
      }
      
      //Swap to +4 for part 1
      System.out.println(count+14);

   }

}