package Chap3;

public class Q5 {
    static int binSearchX(int[]a, int n, int key){
        int pl = 0;
        int pr = n-1;
        do{
            int pc = (pl+pr)/2;
            if(a[pc] == key){
                for(int i=pc; i>pl; i--){
                    if(a[i] == key)
                        pc = i;
                }
                return pc;
            }else{
                pr = pc-1;
            }

        }while (pl <= pr);
        return  -1;
    }

    public static void main(String[] args) {
        int a[] = {1,3,5,7,7,7,7,8,8,9,9};
        int key = 7;
        int num = 11;
        int result = binSearchX(a,num,key);
        if(result ==0)
            System.out.println("그 값의 요소가 없습니다.");
        else{
            System.out.printf("%d의 x[%d]에 있습니다.",key,result);
        }
    }
}
