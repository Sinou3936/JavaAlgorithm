package chap06;

public class Q3 {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;

    }
    static void bubbleSort(int[] array, int n){
        int size = array.length;
        int excha = 0;
        for(int i=0; i<n-1; i++){
            System.out.printf("패스 %d: \n ", i+1);
            for(int j=n-1; j>i; j--){
                for(int k=0; k<n-1; k++)
                    System.out.printf("%3d " +
                            "%c",array[k],(k!=j-1)? ' ': (array[j-1]>array[j])? '+': '-');
                System.out.printf("%3d\n",array[n-1]);

                if(array[j-1] > array[j]) {
                    swap(array, j-1, j );
                    excha++;
                }
                for(int k=0; k<size; k++)
                    System.out.printf("%4d", array[k]);
                System.out.println();
                if(excha == 0) break;
            }
        }
        System.out.println();
        System.out.println("교환 횟수: "+ excha);
    }
    public static void main(String[] args) {
        int[] size = {6,4,3,7,1,9,8};
        int cnt = 7;

        bubbleSort(size,cnt);

    }
}
