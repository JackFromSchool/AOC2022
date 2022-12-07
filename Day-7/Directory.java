import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
   
   String name;
   String directoryIn;
   int sumOfItems;
   int sumOfInternalDirectories;
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
      this.sumOfItems += fileSize;
   }

   public void putDirectory(String directoryKey) {
      this.internalDirectoryKeys.add(directoryKey);
   }

   public void updateSum(ArrayList<Directory> directoryList, HashMap<String, Integer> directoryKeys) {
      int sum = 0;
      try {
         this.internalDirectoryKeys.size();
      } catch (NullPointerException e) {
         this.sumOfInternalDirectories = sum;
         return;
      }
      
      for(int i = 0; i < this.internalDirectoryKeys.size(); i++) {
         sum += directoryList.get(directoryKeys.get(this.internalDirectoryKeys.get(i))).sumOfInternalDirectories+directoryList.get(directoryKeys.get(this.internalDirectoryKeys.get(i))).sumOfItems;
      }

      this.sumOfInternalDirectories = sum;
   }

   public int getSumOfFiles(ArrayList<Directory> directoryList, HashMap<String, Integer> directoryKeys) {
      return this.sumOfInternalDirectories+this.sumOfItems;
   }
   
}
