import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
   
   String name;
   String directoryIn;
   ArrayList<Integer> files = new ArrayList<>();
   ArrayList<String> internalDirectoryKeys = new ArrayList<>();

   public Directory(String name, String directoryIn) {
      this.name = name;
      this.directoryIn = directoryIn;
   }

   public Directory(String name) {
      this.name = name;
   }

   public void putFile(int fileSize) {
      this.files.add(fileSize);
   }

   public void putDirectory(String directoryKey) {
      this.internalDirectoryKeys.add(directoryKey);
   }

   public int getSumOfFiles(ArrayList<Directory> directoryList, HashMap<String, Integer> directoryKeys) {
      try {
         this.files.size();
      } catch (NullPointerException e) {
         return 0;
      }

      int sum = 0;
      for(int i = 0; i < this.files.size(); i++) {
         sum+= this.files.get(i);
      }

      try {
         this.internalDirectoryKeys.size();
      } catch (NullPointerException e) {
         return sum;
      }
      
      for(int i = 0; i < this.internalDirectoryKeys.size(); i++) {
         sum += directoryList.get(directoryKeys.get(internalDirectoryKeys.get(i))).getSumOfFiles(directoryList, directoryKeys);
      }
      return sum;
   }
}
