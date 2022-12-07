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
      directoriesList.add(new Directory("/", "/"));
      directoriesIndexes.put("/", 0);

      String currentDirectory = "/";
      String lastDirectory;

      for(int currentCommand = 0; currentCommand < commands.size(); currentCommand++){
         Scanner reader = new Scanner(commands.get(currentCommand));
         String temp = reader.next();

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
            temp = reader.next();
            if(!directoryExists(directoriesList, temp)){
               lastDirectory = currentDirectory;
               currentDirectory = temp;
               directoriesIndexes.put(currentDirectory, directoriesIndexes.size());
               directoriesList.add(new Directory(currentDirectory, lastDirectory));
               currentDirectory = lastDirectory;
            }
            directoriesList.get(directoriesIndexes.get(currentDirectory)).putDirectory(temp);
         }
         else{
            directoriesList.get(directoriesIndexes.get(currentDirectory)).putFile(Integer.parseInt(temp));
            reader.next();
         }
         }

      }

      for(int x = 0; x < 1; x++){
         for(int y = 0; y < directoriesList.size(); y++){
            directoriesList.get(y).updateSum(directoriesList, directoriesIndexes);
         }
      }
      for(int x = 0; x < 1; x++){
         for(int y = directoriesList.size()-1; y >= 0; y--){
            directoriesList.get(y).updateSum(directoriesList, directoriesIndexes);
         }
      }
      
      int sum = 0;
      
      for(int i = 0; i < directoriesList.size(); i ++){
         if(directoriesList.get(i).getSumOfFiles(directoriesList, directoriesIndexes) <= 100000){
            sum += directoriesList.get(i).getSumOfFiles(directoriesList, directoriesIndexes);
         }
      }
      
      
      System.out.println(sum);

   }

}