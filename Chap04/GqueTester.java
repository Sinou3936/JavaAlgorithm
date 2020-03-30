package Chap04;

import java.util.Scanner;

public class GqueTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Gqueue gs = new Gqueue(64);

        while (true){
            System.out.println("현재 데이터 수: "+gs.size()+"/"+gs.capacity());
            System.out.print("(1)인큐 (2)디큐   (3)피크   (4)덤프   (0)종료: ");
            int menu = scan.nextInt();

            if(menu == 0) break;
            Object x ;
            switch (menu){
                case 1:
                    System.out.print("데이터: ");
                    x = scan.nextInt();
                    try{
                        gs.enque(x);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("큐가 가득 차 있습니다.");
                    }
                    break;
                case 2:
                    try{
                        x=gs.deque();
                        System.out.println("디큐 한 데이터는 :"+ x + " 입니다.");
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3:
                    try{
                        x= gs.peek();
                        System.out.println("피크한 데이터는 : "+x+" 입니다.");
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 4:
                    gs.dump();
                    break;
            }
        }
    }
}
