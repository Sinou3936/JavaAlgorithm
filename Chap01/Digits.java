import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int no;

        System.out.println("2자리의 정수 입력");
        do{
            System.out.print("입력: ");
            no = scan.nextInt();
        }while (no <10 || no > 90);

        System.out.println("변수 no의 값은 "+ no + " 가 되었습니다.");
    }

}
