import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class daySeven { 

   private static ArrayList<String> pathToCurrent = new ArrayList<>();
   private static Directory baseDirectory = new Directory("/", "/");

   private static Directory goToDirectory(){

      Directory found = baseDirectory;

      for(String path : pathToCurrent) {
         found = found.getInnerDirectory(path);
      }

      return found;

   }

   public static void main(String[] args) {
      
      ArrayList<String> commands = new ArrayList<String>();

      try {
         
         File data = new File("input-day7.txt");
         Scanner reader = new Scanner(data);

         while(reader.hasNextLine()){
            commands.add(reader.nextLine());
         }

         reader.close();

      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      ArrayList<Directory> directoriesList = new ArrayList<>();

      for(int currentCommand = 1; currentCommand < commands.size(); currentCommand++){
         Scanner reader = new Scanner(commands.get(currentCommand));
         String temp = reader.next();

         if(temp.equals("$")){

            if(reader.next().equals("cd")){
               temp = reader.next();
               
               if(temp.equals("..")){
                  pathToCurrent.remove(pathToCurrent.size()-1);
               }
               else{
                  pathToCurrent.add(temp);
               }

            }

         }
         else{

            if(temp.equals("dir")){
               goToDirectory().appendDirectory(reader.next(), directoriesList);
            }
            else {
               goToDirectory().appendFile(Integer.parseInt(temp));
               reader.next();
            }

         }

      }

      int sum = 0;
      
      for(Directory directory : directoriesList) {
         if(directory.getSumOfFiles() <= 100000){
            sum += directory.getSumOfFiles();
         }
      }
      
      System.out.println(sum);
      

   }

}