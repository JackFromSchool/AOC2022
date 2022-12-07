import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
   
   String name;
   String directoryIn;
   int fileSum = 0;
   HashMap<String, Directory> directories = new HashMap<>();
   ArrayList<String> keys = new ArrayList<>();
   ArrayList<Integer> files = new ArrayList<>();

   public Directory(String name, String directoryIn) {
      this.name = name;
      this.directoryIn = directoryIn;
   }

   public Directory appendDirectory(String nameOfNew, ArrayList<Directory> listOfDirectories) {
      directories.put(nameOfNew, new Directory(nameOfNew, this.name));
      keys.add(nameOfNew);
      listOfDirectories.add(directories.get(nameOfNew));
      return directories.get(nameOfNew);
   }

   public void appendFile(int fileSize) {
      files.add(fileSize);
      fileSum += fileSize;
   }

   public int getSumOfFiles() {
      int sum = fileSum;
      if(directories.isEmpty()){
         return sum;
      }
      for(String key : keys){
         sum += directories.get(key).getSumOfFiles();
      }
      return sum;
   }

   public Directory getInnerDirectory(String key) {
      return directories.get(key);
   }
   
}
