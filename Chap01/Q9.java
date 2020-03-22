import java.util.Scanner;

public class Q9 {
    static int sumof(int a, int b){
        int sum=0;
        if(a<b) {
            for (; a <= b; a++) {
                sum += a;
            }
        }
        else if(a>b){
            for(; b<=a; b++){
                sum +=b;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("a부터 b 까지의 합을 구하시오");
        System.out.print("a의 값: ");
        int a = scan.nextInt();
        System.out.print("b의 값: ");
        int b = scan.nextInt();
        System.out.println("a 부터 b까지의 합: "+ sumof(a,b));
    }
}
