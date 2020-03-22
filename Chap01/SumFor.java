import java.util.Scanner;

public class SumFor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1부터 n 까지 합을 구하시오");
        System.out.print("n의 값: ");
        int n = scan.nextInt();

        int sum = 0;
        for(int i=1; i<=n; i++){
            sum +=i;
        }

        System.out.println("\n 1부터 "+n+" 까지 합: "+sum);
    }
}
