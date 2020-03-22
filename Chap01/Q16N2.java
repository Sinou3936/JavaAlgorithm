import java.util.Scanner;

public class Q16N2 {
    static void spria(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i+1; j++)
                System.out.print(" ");
            for(int j=0; j<(i-1)*2+1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    static void nspria(int n){
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
            System.out.print("몇 단: ");
            n = scan.nextInt();
        }while (n<=0);

        spria(n);
        nspria(n);
    }
}
