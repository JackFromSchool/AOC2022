import java.util.ArrayList;
import java.math.BigInteger;

public class Monkey {

   public ArrayList<BigInteger> items;
   public char opperation;
   public BigInteger opperationTo;
   public boolean oppperationToSelf = false;
   public BigInteger test;
   public int throwTrue;
   public int throwFalse;
   public long inspections = 0;

   public Monkey(ArrayList<BigInteger> startingItems, char opperation, String opperationTo, BigInteger test, int throwTrue, int throwFalse) {
      this.items = startingItems;
      this.opperation = opperation;
      if(opperationTo.equals("old")) {
         this.oppperationToSelf = true;
      } else {
         this.opperationTo = new BigInteger(opperationTo);
      }
      this.test = test;
      this.throwTrue = throwTrue;
      this.throwFalse = throwFalse;
   }

   public void doMonkeyBuisness(ArrayList<Monkey> monkeyList, int productOfDivisors) {
      for(int i = this.items.size()-1; i > -1; i--) {
         switch(opperation) {
            case '+':
            if(this.oppperationToSelf) {
               this.items.set(i, this.items.get(i).add(this.items.get(i)));
            } else {
               this.items.set(i, this.items.get(i).add(this.opperationTo));
            }
            break;
            
            case '-':
            if(this.oppperationToSelf) {
               this.items.set(i, this.items.get(i).subtract(this.items.get(i)));
            } else {
               this.items.set(i, this.items.get(i).subtract(this.opperationTo));
            }
            break;
            
            case '*':
            if(this.oppperationToSelf) {
               this.items.set(i, this.items.get(i).multiply(this.items.get(i)));
            } else {
               this.items.set(i, this.items.get(i).multiply(this.opperationTo));
            }
            break;
         }

         this.inspections++;

         //For part 1
         //this.items.set(i, ((Long)Math.round(Math.floor(this.items.get(i)/3))));

         //I kind of know how this works but it fixes everything
         this.items.set(i, this.items.get(i).mod(new BigInteger(Integer.toString(productOfDivisors))));

         if(this.items.get(i).mod(this.test).equals(BigInteger.ZERO)) {
            monkeyList.get(this.throwTrue).items.add(this.items.get(i));
            this.items.remove(i);
         } else {
            monkeyList.get(this.throwFalse).items.add(this.items.get(i));
            this.items.remove(i);
         }
      }
   }

   public void printMonkeyInfo() {
      System.out.println(items);
      System.out.println("opperation: "+this.opperation);
      System.out.println("test: "+this.test);
      System.out.println("throwTrue: "+this.throwTrue);
      System.out.println("throwFalse: "+this.throwFalse);
   }
}
