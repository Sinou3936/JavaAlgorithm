import java.util.Scanner;

public class SumWhile {

    public static void main(String[] args) {
        System.out.println("1부터 n 까지 합을 구하시오");
        Scanner scan = new Scanner(System.in);
        System.out.print("n의 값: ");
        int n = scan.nextInt();

        int sum =0;
        int i=0;

        while (i<n){
            sum += i;
            i++;
        }

        System.out.println("1부터 "+ n + "의 값: "+ sum);
    }
}
