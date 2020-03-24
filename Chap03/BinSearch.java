package Chap3;

import java.util.Scanner;

public class BinSearch {
    static int binSearch(int[] a, int n ,int key){
        int pl = 0; //인덱스 첫번째
        int pr = n-1; //인덱스 마지막 번째

        do{
            int pc = (pl+pr) /2; //인덱스 중앙
            if(a[pc] == key){
                return pc;  //검색 성공
            }
            else if(a[pc]< key)
                pl = pc+1;  //검색 범위 뒤쪽 절반 좁힘
            else if(a[pc]>key)
                pc = pl -1; //검색 범위 앞쪽 절반 좁힘
        }while (pl <= pr);
        return -1;  //검색 실패
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[] x = new int[num];

        System.out.println("오름 차순으로 입력하시오.");
        System.out.print("x[0]: ");
        x[0] = scan.nextInt();

        for(int i=1; i<num; i++){
            do{
                System.out.print("x["+i+"]: ");
                x[i] = scan.nextInt();
            }while (x[i]< x[i-1]);     //바로 앞 요소 수가 작으면 다시 입력
        }

        System.out.print("검색할 값: ");
        int key = scan.nextInt();

        int idx = binSearch(x,num,key);

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(key+"은 x["+idx+"]에 있습니다.");
    }
}
