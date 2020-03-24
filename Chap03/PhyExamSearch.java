package Chap3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyExamSearch {

    static class PhyscData {
        private String name;
        private int height;
        private double vision;


        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name + " " + height +" "+vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();


        private static class HeightOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.height > d2.height) ? 1:
                        (d1.height < d2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PhyscData[] x ={
                new PhyscData("이나령",162,0.3),
                new PhyscData("유지훈",168,0.4),
                new PhyscData("김한결",169,0.8),
                new PhyscData("홍준기",171,1.5),
                new PhyscData("전서현",173,0.7),
                new PhyscData("이호연",174,1.2),
                new PhyscData("이수민",175,2.0)
        };
        System.out.print("몇 cm 인 사람을 찾고 있나요?? ");
        int height = scan.nextInt();
        int idex = Arrays.binarySearch(x,
                new PhyscData("", height,0.0),PhyscData.HEIGHT_ORDER);

        if(idex <=0){
            System.out.println("요소가 없습니다.");
        }else{
            System.out.println("x["+idex+"}에 있습니다.");
            System.out.println("찾는 데이터: "+x[idex]);
        }
    }
}