import java.util.Scanner;

public class Q15N2 {
    static void triangleLB(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    static void triangleLU(int n){
        for(int i=n; i>0; i--){
            for(int j=0; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    static void triangleRU(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++)
                System.out.print(" ");
            for(int j=0; j<n-i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    static void triangelRB(int n){
        for(int i=0; i<n; i++){
            for(int j=n; i<j; j--)
                System.out.print(" ");
            for(int j=0; j<i; j++)
                System.out.print("*");
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

        triangleLB(n);
        triangleLU(n);
        triangleRU(n);
        triangelRB(n);
    }
}
