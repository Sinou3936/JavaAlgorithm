package Chap3;

class Id{
    private static int cnt = 0;
    private int id;

    public Id(){id = ++cnt;}

    public int getId() {
        return id;
    }
    public static int getCnt() {return cnt;}
}

public class IdTester {
    public static void main(String[] args) {
        Id a = new Id();
        Id b = new Id();

        System.out.println("a의 아이디: "+a.getId());
        System.out.println("b의 아이디: "+b.getId());

        System.out.println("부여한 아이디 개수: "+Id.getCnt());
    }
}
