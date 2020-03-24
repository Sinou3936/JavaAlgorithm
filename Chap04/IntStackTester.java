package Chap04;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true){
            System.out.println("현재 데이터의 수: "+ s.size() +"/"+s.capacity());
            System.out.print("(1)푸시 (2)팝   (3)피크 " +
                             "(4)덤프 (5)검색 (6)비움 "+
                             "(7)용량 (8)크기 (0)종료 : ");

            int menu = scan.nextInt();
            if(menu == 0) break;

            int x;
            switch (menu){
                case 1:
                    System.out.print("데이터: ");
                    x = scan.nextInt();
                    try {
                        s.push(x);
                    }catch (IntStack.OverflowIntStackException e){
                        s.isFull();
                        System.out.println("오버 플러우 남");
                    }
                break;
                case 2:
                    try{
                        x = s.pop();
                        System.out.println("팝 한 데이터는 "+ x +" 입니다.");
                    }catch (IntStack.EmptyStackException e){
                        s.isEmpty();
                        System.out.println("스택이 비었습니다.");
                    }
                break;
                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크 한 데이터는 "+x+" 입니다.");
                    }catch (IntStack.EmptyStackException e){
                        s.isEmpty();
                        System.out.println("스택이 비었습니다.");
                    }
                break;
                case 4:
                    s.dump();
                break;
                case 5:
                    System.out.print("검색할 데이터: ");
                    int sr = scan.nextInt();
                    try{
                        x = s.indexOf(sr);
                        if(x>0)
                            System.out.printf("검색한 데이터 %d가 있습니다 x[%2d].\n",sr, x);
                    }catch (IntStack.EmptyStackException e){
                        s.isEmpty();
                        System.out.println("스택이 비었습니다.");
                    }
                    break;
                case 6:
                    s.clear();
                    System.out.println("비웠습니다.");
                    break;
                case 7:
                    System.out.println( s.capacity()+" 입니다.");
                    break;
                case 8:
                    System.out.println(s.size()+ "입니다.");
                    break;

            }
        }
    }
}
