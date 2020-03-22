package Chap02;

public class Q3 {
    static void sumOf(int[] a){
        int sum =0;
        int temp = 0;
        for (int i=0; i<a.length; i++){
            temp = a[i];
            sum += temp;
        }
        System.out.println("배열 요소의 합: "+sum);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        sumOf(a);
    }
}
