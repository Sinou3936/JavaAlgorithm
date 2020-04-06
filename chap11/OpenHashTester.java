package chap11;

import java.util.Scanner;

public class OpenHashTester {
    static Scanner scan = new Scanner(System.in);

    //데이터 (회원 번호 + 이름)
    static class Data{
        static final int NO = 1;            // final 을 이용하여 NO 변수 고정
        static final int NAME = 2;         // final 을 이용하여 NAME 변수 고정

        private Integer no;                 // 회원 번호
        private String name;                // 이름

        // 키 값
        public Integer keyCode(){
            return  no;
        }

        // 문자열 반환
        @Override
        public String toString() {
            return  name;
        }

        // 데이터 입력
        public void scanData(String guide, int sw){
            System.out.println(guide+" 할 데이터 입력하세요");

            if((sw & NO) == NO){                        //지역 변수 sw 와 전역변수 NO 가 같으면 실행
                System.out.print("번호: ");
                no = scan.nextInt();
            }
            if((sw & NAME) == NAME){                    //지역 변수 sw 와 전역 변수 NAME 이 같으면 실행
                System.out.print("이름: ");
                name = scan.next();
            }
        }
    }
    //메뉴 열거형
    enum Menu{
        ADD(       "추가"),
        REMOVE(   "삭제"),
        SEARCH(   "검색"),
        DUMP(     "출력"),
        TERMINATE("종료");

        //출력할 문자열
        private final String message;

        public static Menu MenuAt(int idx){     //서수가 idx 인 열거 반환
            for(Menu m : Menu.values())          // Menu 의 values 만큼 m를 반복
                if(m.ordinal() == idx)           // m의 enum 요소가 서수 idx와 일치하면
                    return  m;                  //m 으로 출력
            return null;                       //아닐 때는 null로 표기
        }
        // 메뉴에대한 생성자
        Menu(String str){
            message = str;
        }
        // 출력할 문자열 반환 시킴
        public String getMessage() {
            return message;
        }
    }
    // 메뉴 선택
    public static Menu SelectMenu(){
        int key;
        do{
            for(Menu m : Menu.values())             //Menu 의 values 만큼 m을 반복
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());        // 출력 할 enum 요소와 문자열 출력
            System.out.print(" : ");
            key = scan.nextInt();                   // key 로 선택함
        }while (key < Menu.ADD.ordinal() || key> Menu.TERMINATE.ordinal()); // 추가에서 종료 까지 반복 시킨다.

        return Menu.MenuAt(key);        // MenuAt에 대한 키값으로 반환
    }

    public static void main(String[] args) {
        Menu menu;                  // 메뉴
        Data data;                  // 추가 데이터 참조
        Data temp = new Data();     // 입력 데이터

        OpenHash<Integer,Data> hash = new OpenHash<Integer, Data>(13);  // 오픈 해시를 인스턴트 시킴(사이즈 13으로 고정)

        do{
            switch (menu = SelectMenu()){           // 메인의 메뉴가 SelectMenu()의 메뉴랑 일치시
                case ADD:                           // 추가
                    data = new Data();              // data 를 인스턴트 함
                    data.scanData("추가", Data.NO | Data.NAME);   // scanData 메소드를 이용하여 NO와 NAME 입력
                    int k = hash.add(data.keyCode(), data);                   // 해시 요소에 삽입
                    switch (k){
                        case 1:
                            System.out.println("키 값은 이미 등록 되어 있습니다."); break;
                            // 키가 1일 때 출력
                        case 2:
                            System.out.println("해시 테이블이 가득 차 있습니다."); break;
                            // 키가 2일 때 출력
                    }
                    break;

                case REMOVE:                                // 삭제
                    temp.scanData("삭제", Data.NO);  // scanData 메소드를 이용하여 NO를 입력
                    hash.delete(temp.keyCode());            // 인스턴트 시킨 hash를 이용하여 delete() 메소드 사용
                    break;

                case SEARCH:                                    //검색
                    temp.scanData("검색", Data.NO);      // scanData 메소드를 이용하여 NO를 입력
                    Data t = hash.search(temp.keyCode());       // 인스턴트 한 .Data 변수 t 를 hash 로 검색 메소드 이용
                    if(t != null)
                        System.out.println(" 키를 갖는 데이터: "+ t +" 입니다.");   // t 가 null 이 아니면 출력
                    else
                        System.out.println("데이터가 없습니다.");                             // t 가 null 이면 다른 값 출력
                    break;

                case DUMP:                                  // 출력
                    hash.dump();                            // 모든 값 출력함.
                    break;
            }
        }while (menu != Menu.TERMINATE);                   // 메뉴가 종료가 아닐 때 까지 반복
    }
}
