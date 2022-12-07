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
      if(this.name.equals(directoryKey)){
         return;
      }
      this.internalDirectoryKeys.add(directoryKey);
   }

   public int getSumOfFiles(ArrayList<Directory> directoryList, HashMap<String, Integer> directoryKeys) {
      int sum = this.sumOfItems;
      if(this.internalDirectoryKeys.isEmpty()){
         return sum; 
      }
      System.out.println(this.internalDirectoryKeys);
      for(String i : this.internalDirectoryKeys){
         sum += directoryList.get(directoryKeys.get(i)).getSumOfFiles(directoryList, directoryKeys);
      }
      System.out.println("yay2");
      return sum;
   }
   
}
