package Chap04;

import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntQueue s = new IntQueue(64);

        while (true){
            System.out.println("현재 데이터 수: "+s.size() +"/"+s.capacity());
            System.out.print("(1)EnQueue    (2)DeQueue  (3)PEEK "+
                             "  (4)DUMP  (0)EXIT: ");
            int menu = scan.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu){
                case 1:
                    System.out.print("데이터: ");
                    x = scan.nextInt();
                    try {
                        s.enque(x);
                    }catch (IntQueue.OverflowIntQueueException e){
                        System.out.println("큐가 가득 차 있습니다.");
                    }
                break;
                case 2:
                    try {
                        x = s.deque();
                        System.out.println("디큐 한 데이터는 : "+x +" 입니다.");
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비었습니다.");
                    }
                break;
                case 3:
                    try{
                        x = s.peek();
                        System.out.println("피크 한 데이터는 : "+x +" 입니다.");
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비었습니다.");
                    }
                break;
                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
