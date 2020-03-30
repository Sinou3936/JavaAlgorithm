package chap06;

import java.util.Scanner;

public class Q17 {
    static void swap(int[]a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static int pow2(int n){
        int k = 1;
        while (n-- > 0) k *=2;
        return (k);
    }

    static void print(int n){
        for(int i=0; i<n; i++)
            System.out.print(" ");
    }
    static void HeapPrint(int[]a, int n){
        int i= n;
        int height = 1;
        while ((i>>=1) > 0) height++;
        i=0;
        int w = 1;
        Loop:{
            for(int level = 0; level<height; level++){
                print(pow2(height-level)-3);
                for(int k =0; k<w; k++){
                    System.out.printf("%2d",a[i++]);
                    if(i>=n)
                        break Loop;
                    if(k < w-1)
                        print(pow2(height-level+1)-2);
                }
                System.out.println();

                print(pow2(height-level)-4);
                for(int k=0; k<w; k++){
                    if(2*k+i<n)
                        System.out.print("/");
                    if(2*k+i+1 < n)
                        System.out.print("＼");
                    if(k<w-1)
                        print(pow2(height-level+1)-4);
                }
                System.out.println();
                w *= 2;
            }
        }
        System.out.println();
        System.out.println();
    }
    static void downHeap(int[]a, int left, int right){
        int temp = a[left];
        int child;
        int parent;

        for(parent = left; parent<(right+1)/2; parent = child){
            int cl = parent*2+1;
            int cr = cl+1;
            child =  cr <=right && a[cr]>a[cl]? cr: cl;
            if(temp >= a[child])break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }
    static void heapSort(int[]a, int n){
        for(int i=(n-1)/2; i>=0; i--){
            HeapPrint(a,n);
            downHeap(a,i,n-1);
        }

        for(int i=n-1; i>0; i--){
            swap(a,0,i);
            HeapPrint(a,n);
            downHeap(a,0,i-1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("힙정렬");
        System.out.print("요소수: ");
        int num = scan.nextInt();
        int[]x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = scan.nextInt();
        }

        heapSort(x,num);

        System.out.println("오름 차순으로 정렬");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"]: "+x[i]);
        }

    }
}
