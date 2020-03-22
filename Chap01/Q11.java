import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("양의 정수를 입력하고 자릿수 출력하시오.");
        int n;

        do{
            System.out.print("n의 정수 값: ");
            n = scan.nextInt();
        }while (n <=0 );

        if(n>=0 && n<10){
            System.out.println("그 수는 1자리");
        }else if(n>=10 && n<100){
            System.out.println("그 수는 2자리");
        }else if(n>=100 && n<1000){
            System.out.println("그 수는 3자리");
        }else if(n>=1000 && n<10000)
            System.out.println("그 수는 4자리");
        else
            System.out.println("다시 입력하세요");
    }
}
