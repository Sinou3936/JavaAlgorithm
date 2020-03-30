package chap06;

public class Q2 {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;

    }
    static void bubbleSort(int[] array, int n){
        int size = array.length;
        int exchg = 0;
        int compare = 0;
        for(int i=0; i<n-1; i++){
            System.out.print("패스: "+(i+1)+"\n");
            for(int j=n-1; j>i; j--){
                for(int k=0; k<size; k++)
                   System.out.printf("%3d " +
                           "%c",array[k],(k!=j-1)? ' ': (array[j-1]>array[j])? '+': '-');
                System.out.println();
                compare++;
                System.out.println();
                if(array[j-1] > array[j]) {
                    swap(array, j-1, j );
                    exchg++;
                }
                if(exchg == 0) break;
            }
        }
        System.out.println("비교 횟수: "+compare +" 회");
        System.out.println("교환 횟수: "+exchg +" 회");
    }
    public static void main(String[] args) {
        int[] size = {6,4,3,7,1,9,8};
        int cnt = 7;

        bubbleSort(size,cnt);

    }
}
