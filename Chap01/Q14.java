import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        System.out.println("사각형을 출력하시오");
        String str = "x";
        Scanner scan = new Scanner(System.in);
        System.out.print("단 수: ");
        int n = scan.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++ )
                System.out.print(str);

            System.out.println();
        }
    }
}
