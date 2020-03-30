package Chap05;

public class Q8 {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int[] pos = new int[8];

    static void print(){
        StringBuilder sb0 = new StringBuilder("□□□□□□□□");
        StringBuilder sb1 = new StringBuilder("□□□□□□□□");
        StringBuilder sb2 = new StringBuilder("□□□□□□□□");
        StringBuilder sb3 = new StringBuilder("□□□□□□□□");
        StringBuilder sb4 = new StringBuilder("□□□□□□□□");
        StringBuilder sb5 = new StringBuilder("□□□□□□□□");
        StringBuilder sb6 = new StringBuilder("□□□□□□□□");
        StringBuilder sb7 = new StringBuilder("□□□□□□□□");

        for(int i=0; i<8; i++){

            System.out.printf("%2d",pos[i]);
            int value = pos[i];
            if(value == 0){
                sb0.setCharAt(i,'■');
            }else if(value == 1){
                sb1.setCharAt(i,'■');
            }else if(value == 2){
                sb2.setCharAt(i,'■');
            }else if(value == 3){
                sb3.setCharAt(i,'■');
            }else if(value == 4){
                sb4.setCharAt(i,'■');
            }else if(value == 5){
                sb5.setCharAt(i,'■');
            }else if(value == 6){
                sb6.setCharAt(i,'■');
            }else if(value == 7){
                sb7.setCharAt(i,'■');
            }
        }
        System.out.println();
        String whole = sb0+"\n"+sb1+"\n"+sb2+"\n"+sb3+"\n"+sb4+"\n"+sb5+"\n"+sb6+"\n"+sb7+"\n";
        System.out.println(whole);
        System.out.println();

    }
    static void set(int i){
        for(int j=0; j<flag_a.length; j++){
            if(flag_a[i] == false && flag_b[i+j] == false && flag_c[i-j+7] == false){
                pos[i] = j;
                if(i==7) print();
                else{
                    flag_a[i] = flag_b[i+j] = flag_c[i-j+7] = true;
                    set(i+1);
                    flag_a[i] = flag_b[i+j] = flag_c[i-j+7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
