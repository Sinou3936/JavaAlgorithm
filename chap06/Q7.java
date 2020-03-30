package chap06;

public class Q7 {
    static void insertionSort(int[]a, int n){
        for(int i=2; i<n; i++){
            int temp = a[0] = a[i];
            int j = i;
            for(; a[j-1]>temp; j--)
                a[j] = a[j-1];
            if(j>0)
                a[j] = temp;
        }
    }


    public static void main(String[] args) {
        int x[] = {6,4,8,3,1,5,7};

        insertionSort(x,x.length);

        for(int i=0; i<x.length; i++){
            System.out.println("x["+i+"]: "+x[i]);
        }
    }
}
