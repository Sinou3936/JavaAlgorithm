import java.util.Scanner;

public class Max3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("세 정수의 최댓값 구하기");
        System.out.println("a의 값: ");
        int a = scan.nextInt();
        System.out.println("b의 값: ");
        int b = scan.nextInt();
        System.out.println("c의 값: ");
        int c = scan.nextInt();

        int max = a;
        if(b>max) max = b;
        if(c>max) max = c;

        System.out.println("최대값: "+ max);

    }
}
