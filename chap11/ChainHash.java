package chap11;

public class ChainHash<K,V> {
    // 해시 구성하는 노드
    class Node<K,V>{
        private K key;          // 키 값
        private V data;         // 데이터
        private Node<K,V> next; //다음 노드 참조

        // 생성자
        Node(K key, V val ,Node<K,V> next){
            this.key = key;
            this.data = val;
            this.next = next;
        }
        // 키 값 반환
        K getKey(){
            return  key;
        }
        // 데이터 반환
        V getVal(){
            return  data;
        }
        //키 의 해시 값 반환
        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;               //해시 테이블 크기
    private Node<K,V>[] table;      //해시 테이블

    // 체인 해시 생성자
    public ChainHash(int capacity){
        try {
            table = new Node[capacity];
            this.size = capacity;
        }catch (OutOfMemoryError e){    //테이블 생성 할 수 없을 때
            this.size = 0;
        }
    }

    // 해시 값 구함
    public int hashValue(Object key){
        return key.hashCode() % size;
    }

    // 키 값 요소의 검색 (데이터 반환용)
    public V search(K key){
        int hash = hashValue(key);      // 검색할 데이터 해시 값
        Node<K,V> p = table[hash];      // 선택 노드

        while (p != null){
            if(p.getKey().equals(key))
                return p.getVal();  // 검색 성공
            p = p.next;             // 다음 노드 주목
        }
        return null;
    }

    // 키 값, 데이터 갖는 요소 추가
    public int add(K key, V data){
        int hash = hashValue(key);
        Node<K,V> p = table[hash];

        while (p != null){
            if(p.getKey().equals(key))      //이미 등록 시
                return 1;
            p = p.next;                     // 다음 노드 주목
        }
        Node<K,V> temp = new Node<K, V>(key,data,table[hash]);
        table[hash] = temp;                 // 노드 삽입
        return 0;
    }

    public int remove(K key){
        int hash = hashValue(key);
        Node<K,V> p = table[hash];
        Node<K,V> pr = null;

        while (p != null){
            if(p.getKey().equals(key)){
                if( pr == null)
                    table[hash] = p .next;
                else
                    pr.next = p.next;
            }
            pr = p;
            p = p.next;
        }
        return 1;
    }

    public void dump(){
        for(int i=0; i<size; i++){
            Node<K,V> p = table[i];
            System.out.printf("%02d ",i);
            while ( p != null){
                System.out.printf("-> %s (%s) ",p.getKey(), p.getVal());
                p = p.next;
            }
            System.out.println();
        }
    }
}
