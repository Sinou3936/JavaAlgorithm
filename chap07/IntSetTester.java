package chap07;

import com.sun.jmx.snmp.agent.SnmpUserDataFactory;

public class IntSetTester {
    public static void main(String[] args) {
        IntSet s1 = new IntSet(20);
        IntSet s2 = new IntSet(5);
        IntSet s3 = new IntSet(5);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.ToCopy(s2);
        s2.add(12);
        s2.remove(15);

        s3.copyFrom(s2);

        System.out.println("s1= "+s1);
        System.out.println("s2= "+s2);
        System.out.println("s3= "+s3);

        System.out.println("집합 s1에 15는"+ (s1.contains(15)? "포함": "미포함"));
        System.out.println("집합 s2에 25는"+ (s2.contains(25)? "포함": "미포함"));
        System.out.println("집합 s1과 s2는"+ (s1.equalTo(s2)? "같다": "다르다"));
        System.out.println("집합 s2과 s3는"+ (s2.equalTo(s3)? "같다": "다르다"));

        s3.unionOF(s1,s2);
        System.out.println("잡합 s1과 s2의 합집합은 "+ s3+" 입니다.");

       /* s1.clear();
        System.out.println("집합 s1는 "+ (s1.isEmpty()? "비어있다.": "가득 차 있다"));
        System.out.println("집합 s2는 "+ (s2.isFull()? "비어있다.": "가득 차 있다"));
        System.out.println("집합 s3는 "+ (s3.isFull()? "비어있다.": "가득 차 있다"));*/


        System.out.println("집합 s1과 s2는 "+ (s1.add(s2)? "합집합": "교집합"));
        System.out.println("집합 s1과 s2는 "+ (s1.retain(s2)? "교집합": "합집합"));
        System.out.println("집합 s1과 s2는 "+ (s1.remove(s2)? "차집합.": "비교 대상 없음"));
    }
}
