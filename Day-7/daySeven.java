import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

class daySeven { 

   private static boolean directoryExists( ArrayList<Directory> directoryList, String name) {
      for(int i = 0; i < directoryList.size(); i++) {
         if(directoryList.get(i).name.equals(name)){
            return true;
         }
      }
      return false;
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

      ArrayList<Directory> directoriesList = new ArrayList<Directory>();
      HashMap<String, Integer> directoriesIndexes = new HashMap<>();
      directoriesList.add(new Directory("/"));
      directoriesIndexes.put("/", 0);

      String currentDirectory = "/";
      String lastDirectory;

      for(int currentCommand = 0; currentCommand < commands.size(); currentCommand++){
         Scanner reader = new Scanner(commands.get(currentCommand));
         String temp = reader.next();
         System.out.println(temp);

         if(temp.equals("$")){
            if(reader.next().equals("cd")){
               temp = reader.next();
               if(temp.equals("..")){
                  currentDirectory = directoriesList.get(directoriesIndexes.get(currentDirectory)).directoryIn;
               }
               else{
               lastDirectory = currentDirectory;
               currentDirectory = temp;
               if(!directoryExists(directoriesList, currentDirectory)){
                  directoriesIndexes.put(currentDirectory, directoriesIndexes.size());
                  directoriesList.add(new Directory(currentDirectory, lastDirectory));
               }
               }
            }
            else{
               
            }
         }
         else{
         if(temp.equals("dir")){
            reader.next();
         }
         else{
            directoriesList.get(directoriesIndexes.get(currentDirectory)).putFile(Integer.parseInt(temp));
            reader.next();
         }
         }

      }

      System.out.println(directoriesList.get(directoriesIndexes.get("a")).files);

      int sum = 0;
      for(int i = 0; i < directoriesList.size(); i ++){
         if(directoriesList.get(i).getSumOfFiles() <= 100000){
            sum += directoriesList.get(i).getSumOfFiles();
         }
      }
      
      System.out.println(sum);

   }

}