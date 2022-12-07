import java.util.ArrayList;

public class Directory {
   
   String name;
   String directoryIn;
   ArrayList<Integer> files = new ArrayList<>();

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

   public int getSumOfFiles() {
      try {
         this.files.size();
      } catch (NullPointerException e) {
         return 0;
      }
      int sum = 0;
      System.out.println(this.files);
      for(int i = 0; i < this.files.size(); i++) {
         System.out.print(i+ " | ");
         sum+= this.files.get(i);
      }
      System.out.println();
      return sum;
      
   }
}
