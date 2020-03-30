package chap06;

public class Q5 {
    static void swap(int[]a, int n1, int n2){
        int t = a[n1];
        a[n1] = a[n2];
        a[n2] = t;
    }
    static void cocktailSort(int[]a, int n){
        int left = 0;
        int right = n-1;
        int last = right;

        while (left<right){
            for(int i = right; i>left; i--){
                if(a[i-1] > a[i]) {
                    swap(a, i - 1, i);
                    last = i;
                }
            }
            left = last;

            for (int i=left; i<right; i++){
                if(a[i-1] < a[i]) {
                    swap(a, i, i+1);
                    last = i;
                }
            }
            right = last;
        }
    }

    public static void main(String[] args) {
        int x[] = {9,1,3,4,6,7,8};
        int cnt = 7;

        System.out.println("정렬 전 배열 상태");
        for(int i=0; i<cnt; i++){
            System.out.println("x["+i+"]: "+ x[i]);
        }

        cocktailSort(x,cnt);

        System.out.println("정렬 후 배열 상태");
        for(int i=0; i<cnt; i++){
            System.out.println("x["+i+"]: "+ x[i]);
        }
    }
}
