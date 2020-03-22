import java.util.Scanner;

public class Median {
    static int median(int a, int b, int c){
/*        if(a>=b)
            if(b>=c)
                return b;
            else if(a<=c)
                return a;
            else
                return c;
        else if(a > c)
            return a;
        else if(b > c)
            return c;
        else
            return b;*/

        if((b>=a && c<=a) || (b<=a && c>=a))
            return a;
        else if((a>b && b<c) || (a<b && c>b))
            return b;
        else return c;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("세 정수의 중앙값 구하기");
        System.out.print("a의 값 "); int a = scan.nextInt();
        System.out.print("b의 값 "); int b = scan.nextInt();
        System.out.print("c의 값 "); int c = scan.nextInt();

        System.out.println("중앙값: "+ median(a,b,c));

    }
}
