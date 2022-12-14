public class Node {
   public int x;
   public int y;
   public int gVal;
   public char height;

   public Node(int x, int y, int gVal, char height) {
      this.x = x;
      this.y = y;
      this.gVal = gVal;
      this.height = height;
   }

   public Node(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public int fVal(final int EXPOS, final int EYPOS) {
      int hVal = Math.abs(EXPOS-this.x)+Math.abs(EYPOS-this.y);
      return hVal+gVal;
   }

   public int hVal(final int EXPOS, final int EYPOS) {
      return Math.abs(EXPOS-this.x)+Math.abs(EYPOS-this.y);
   }
}
