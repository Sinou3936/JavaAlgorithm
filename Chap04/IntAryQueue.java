package Chap04;

//Q4 IntAryQueue 형으로 실습
public class IntAryQueue {
   private int max;
   private int num;
   private Object[] que;

   public IntAryQueue(int max){
       this.num = 0;
       this.max = max;
       this.que = new Object[this.max];
   }
   public boolean isEmpty(){
       if(num <= 0) return true;
       else return false;
   }
   public boolean isFull(){
       if(num > max) return true;
       else return false;
   }
   public void enque(Object item){
       if(isFull()) throw new ArrayIndexOutOfBoundsException();
       this.num++;
       que[num] = item;
   }
   public Object peek(){
       return que[num];
   }

   public Object deque(){
       if(isEmpty()) throw new ArrayIndexOutOfBoundsException();

       Object back_X  = peek();
       --this.num;
       return back_X;
   }

    public static void main(String[] args) {
        IntAryQueue iaq = new IntAryQueue(4);
        iaq.enque(1);
        iaq.enque(2);
        iaq.enque(3);

        while (!iaq.isEmpty())
            System.out.println(iaq.deque());
    }
}
