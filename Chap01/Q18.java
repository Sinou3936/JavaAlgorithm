import java.util.Scanner;

public class Q18 {
    static void nspira(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i+1; j++)
              System.out.print(" ");
            for(int j=0; j<(i-1)*2+1; j++)
                System.out.print(i%10);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;

        do{
            System.out.print("몇단 피라미드?? ");
            n = scan.nextInt();
        }while (n<=0);
        nspira(n);
    }
}
