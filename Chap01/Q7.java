import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1부터 n 까지 합을 구하시오");
        System.out.print("n의 값: ");
        int n = scan.nextInt();

        int sum = 0;
        for(int i=1; i<=n; i++){
            sum +=i;
            if(i<n){
                System.out.print(i+"+");
            }else if(i==n){
                System.out.print(i+"=");
            }
        }
        System.out.print(sum);
    }
}
