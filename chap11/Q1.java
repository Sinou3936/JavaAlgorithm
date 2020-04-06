package chap11;

import java.util.Scanner;

public class Q1 {
    static Scanner scan = new Scanner(System.in);

    //데이터 생성
    static class Data{
        public static final int NO = 1;     //번호 입력?
        public static final int NAME= 2;    //이름 입력?

        private Integer no;                 //회원 번호(키, 값)
        private String name;                // 이름

        // 키 값
        public String KeyCode(){
            return name;
        }
        // 문자열 반환
        @Override
        public String toString() {
            return Integer.toString(no);
        }
        //데이터 입력
        public void scanData(String guide, int sw){
            System.out.println(guide+ " 할 데이터를 입력하세요.");

            if((sw & NO) == NO){
                System.out.print("번호: ");
                no = scan.nextInt();
            }

            if((sw & NAME) == NAME){
                System.out.print("이름: ");
                name = scan.next();
            }
        }
    }
    //메뉴 열거
    public enum Menu{
        ADD(     "삽입"),
        REMOVE(  "삭제"),
        SEARCH(  "검색"),
        DUMP(   "표시"),
        TERMINATE("종료");

        private final String message;

        public static Menu MenuAt(int idx){
            for(Menu m : Menu.values()){
                if(m.ordinal() == idx)
                    return  m;
            }
            return null;
        }
        //메뉴 생성자
        Menu(String str){
            message = str;
        }
        //메뉴 출력 문자열 반환
        public String getMessage(){
            return  message;
        }
    }
    // 메뉴 선택
    public static Menu selectMenu(){
        int key;
        do {
            for(Menu m : Menu.values())
                System.out.printf("(%d) %s ", m.ordinal(),m.getMessage());
            System.out.print(" : ");
            key = scan.nextInt();
        }while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;              // 메뉴
        Data data;              //추가용 데이터 참조
        Data temp = new Data(); // 입력용 데이터

        ChainHash<String, Data> Hash = new ChainHash<String, Data>(13);

        do {
            switch (menu = selectMenu()){
                case ADD:
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    Hash.add(data.KeyCode(),data);
                    break;
                case REMOVE:
                    temp.scanData("삭제", Data.NAME);
                    Hash.remove(temp.KeyCode());
                    break;
                case SEARCH:
                    temp.scanData("검색",Data.NAME);
                    Data t = Hash.search(temp.KeyCode());
                    if(t != null) System.out.println("번호의 이름은: "+ t +" 입니다.");
                    else
                        System.out.println("데이터가 없습니다.");
                    break;
                case DUMP:
                    Hash.dump();
                    break;

            }
        }while (menu != Menu.TERMINATE);
    }
}
