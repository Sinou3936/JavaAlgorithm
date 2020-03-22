import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1부터 n 까지 합을 구하시오");
        System.out.print("n의 값: ");
        int n = scan.nextInt();

        int sum = 0;
        int i=1;
        for(; i<=n; i++){
            sum +=i;
        }
        System.out.print("(1+"+n+") *5 ="+ sum);
    }
}
