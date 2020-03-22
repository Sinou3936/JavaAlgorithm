import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,b;

        do{
            System.out.print("a의 값: ");
            a = scan.nextInt();
            System.out.print("b의 값: ");
            b = scan.nextInt();
        }while (a<b);

        if(a>=b){
            System.out.println("a 값 보다 큰 값을 입력하세여.");
            System.out.print("b의 값: ");
            b = scan.nextInt();
        }

        int sub = 0;
        sub = b-a;
        System.out.println("b-a의 값은: "+sub);
    }
}
