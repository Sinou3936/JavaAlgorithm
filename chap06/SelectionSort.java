package chap06;

public class SelectionSort {
    static void swap(int[]a, int x, int y){
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
    static void selectionSort(int[] a, int n){
        int size = a.length;
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++)
                if(a[j] < a[min])
                    min = j;
                swap(a,i,min);
            for(int k=0; k<size; k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] size = {6,4,8,3,1,9,7};

        for(int i=0; i< size.length; i++)
            System.out.print(size[i]+" ");
        System.out.println();

        selectionSort(size, size.length);

        for(int i=0; i<size.length; i++)
            System.out.print(size[i]+" ");
        System.out.println();
    }
}
