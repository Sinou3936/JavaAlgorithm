package chap06;

public class Q1 {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;

    }
    static void bubbleSort(int[] array, int n){
        int size = array.length;
        for(int i=0; i<n-1; i++){
            System.out.printf("\n 패스 %d: ", i+1);
            for(int j=n-1; j>i; j--){
                if(array[j-1] > array[j]) {
                    swap(array, j-1, j );

                }
                System.out.printf("\n");
                for(int k=0; k<size; k++){
                    System.out.printf("%4d", array[k]);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] size = {6,4,3,7,1,9,8};
        int cnt = 7;

        for(int i=0; i<cnt; i++){
            System.out.print(size[i]+ " ");
        }
        bubbleSort(size,cnt);

    }
}
