package Chap3;

public class Q3 {
    static int searchIdx(int[]a, int n ,int key, int[] idx){
       int seq= 0;
       for(int i=0; i<n; i++){
           if(key == a[i])
               idx[seq++] = i++;
       }
       return  seq;
    }

    public static void main(String[] args) {
        int a[] = {1,9,2,9,4,6,7,9};
        int key = 9;
        int num = 8;
        int []idx  = new int[num];
        int result = searchIdx(a,num,key,idx);
        StringBuffer sb = new StringBuffer("key와 일치하는 요소{");

        for(int i=0; i<result; i++){
            sb.append(idx[i]);
            if(i == result -1){
                sb.append("}\n");
            }else{
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
