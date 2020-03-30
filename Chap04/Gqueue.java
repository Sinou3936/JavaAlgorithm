package Chap04;

public class Gqueue<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    public Gqueue(int capacity ){
        num = front = rear = 0;
        max = capacity;
        try{
            que = (E[]) new Object[max];
        }catch (OutOfMemoryError e){
            max = 0;
        }
    }
    public E enque(E x) throws Exception {
        if(num >= max) throw new Exception();
        que[rear++] = x;
        if(rear == max)
            rear = 0;
        return x;
    }
    public E deque() throws Exception{
        if(num <=0) throw new Exception();
        E x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    public E peek() throws Exception{
        if(num <=0) throw new Exception();
        return que[front];
    }
    public int indexOf(E x){
        for(int i=0; i<num; i++){
            int idx = (i+front) % max;
            if(que[idx] == x) return idx;
        }
        return -1;
    }

    public void clear(){
        num = front = rear = 0;
    }
    public int capacity(){
        return  max;
    }
    public int size(){
        return num;
    }
    public boolean isEmpty(){
        return num<=0;
    }
    public boolean isFull(){
        return  num >= max;
    }
    public void dump(){
        if(num<=0)
            System.out.println("큐가 비어있습니다.");
        else{
            for(int i=0; i<num; i++)
                System.out.print(que[(i+front)%max]+" ");
            System.out.println();
        }
    }
}
