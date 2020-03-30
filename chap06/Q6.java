package chap06;

public class Q6 {
    static void swap(int[]a, int n1, int n2){
        int t = a[n1];
        a[n1] = a[n2];
        a[n2] = t;
    }
    static void selectionSort(int[]a, int n){
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=i+1; j<n; j++)
                if(a[j] < a[min])
                    min = j;
            for(int k = 0; k<n; k++)
                System.out.printf((k==i)?"  * ": (k==min)?" + ":"   ");
            System.out.println();

            for(int k=0; k<n; k++)
                System.out.printf("%3d",a[k]);
            System.out.println("\n");
            swap(a,i,min);
        }
    }

    public static void main(String[] args) {
        int x[] = {6,4,8,3,1,9,7};
        selectionSort(x, x.length);


    }
}
