package Chap3;

public class Q4 {
    static int binSearchPoint(int[]a,int n ,int key){
        int pl = 0;
        int pr = n-1;
        System.out.print("|");
        for(int i=0; i<n; i++){
            System.out.printf("%2d",i);
        }
        System.out.println("\n---------------\n");
        do{
            int pc = (pl+pr)/2;
            System.out.print("  |<-");
            for(int i=0; i<pc-1; i++){
                System.out.print(" ");
            }
            System.out.print("+");
            for(int i=0; i<pc-1;i++){
                System.out.print(" ");
            }
            System.out.print("->\n");
            System.out.printf("%2d", pc);

            for(int i=0; i<n; i++){
                System.out.printf("%2d", a[i]);
            }
            System.out.println();

            if(a[pc] == key){
                return pc;
            }else {
                pr = pr -1;
            }
        }while (pl<=pr);

        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,5,6,8,9};
        int key = 2;
        int num = 7;
        int result = binSearchPoint(a,num,key);

        if(result == 0){
            System.out.println("그 값의 요소가 없습니다.");
        }else{
            System.out.printf("%d는 x[%d]에 있습니다.",key,result);
        }
    }
}
