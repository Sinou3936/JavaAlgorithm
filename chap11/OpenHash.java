package chap11;

public class OpenHash<K,V> {
    // 버킷의 상태
    enum Status {OCCUPIED, EMPTY, DELETED};
    // 버킷
    static class Bucket<K,V>{
        private K key;          //키 값
        private V data;         //데이터 값
        private Status stat;    //상태

        //Bucket 생성자
        Bucket(){
            stat = Status.EMPTY;    //버켓이 비어있는 상태
        }
        //필드 값 설정
        public void set(K key, V data, Status stat){
            this.key = key;         //키 값
            this.data = data;       //데이터 값
            this.stat = stat;       //상태
        }

        // 상태 설정
        public void setStat(Status stat){
            this.stat = stat;
        }
        // 키 값 반환
        public K getKey(){
            return key;
        }
        // 데이터 반환
        public V getData(){
            return data;
        }
        // 키를 해시 값 반환
        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;               //해시테이블 크기
    private Bucket<K,V>[] table;    //해시테이블

    //OpenHash 생성자
    public OpenHash(int size){
        try{
            table = new Bucket[size];   //테이블은 사이즈 크기에 따라 설정
            for(int i=0; i<size; i++)
                table[i] = new Bucket<K, V>();  //테이블 i번째에 버킷의 키,데이터 값 생성
            this.size = size;           // 사이즈 값
        }catch (OutOfMemoryError e){    //메모리가 없으면 사이즈는 0 으로 설정
            this.size = 0;
        }
    }

    // 해시 값을 구함
    public  int hashValue(Object key){
        return  key.hashCode()% size;   //키 값의 해시코드를 찾아서 사이즈 만큼 나눈 나머지 값 해시 함.
    }

    // 재 해시 값 구함
    public int rehashValue(int hash){
        return (hash+1) % size;     //해시 값에서 사이즈 만큼 나눈 나머지 값을 재 해시 함.
    }

    // 키 값을 갖는 버킷 찾기
    private Bucket<K,V> searchNode(K key){
        int hash = hashValue(key);          // 검색할 데이터의 해시 값
        Bucket<K,V> p = table[hash];        // 선택 버킷

        for(int i=0; p.stat != Status.EMPTY && i<size; i++){            //선택버킷의 상태가 비어있지 않고, 변수 i 값이 전역변수 size 보다 작으면 실행
            if(p.stat ==Status.OCCUPIED && p.getKey().equals(key))     // 선택버킷의 상태가 저장하지 않고, 선택버킷의 키 값 메소드가 지역변수 key 값 하고 일치시
                return  p;                                              // 선택 버킷에 저장
            hash = rehashValue(hash);                                   //해시값 재 해시 함
            p = table[hash];                                           //선택 버킷은 전역변수 테이블에 저장
        }
        return  null;                                               // 그렇지 않으면 null 로 표시
    }

    //키 값을 갖는 요소 검색(데이터 반환)
    public V search(K key){
        Bucket<K,V> p = searchNode(key);                            // 선택 버킷을 버킷 찾기
        if(p != null)
            return  p.getData();                         // 선택 버킷이 null 이 아니면 선택 버킷의 데이터 값 메소드로 출력
        else
            return null;                                          // 그렇지 않으면 null 로 표시
    }

    //키 값, 데이터 값 갖는 요소 추가
    public int add(K key, V data){
        if(search(key) != null)                                     //요소 검색한 키 값이 null 이 아니면  -1로 반환
            return  -1;
        int hash = hashValue(key);                                  // 해시 값은 해시값 함수의 키 값으로 나타냄
        Bucket<K,V> p = table[hash];                                //선택 버킷은 전역변수 해시값을 가짐.
        for(int i=0; i<size; i++){                                  //전역 변수 size 만큼 반복 함
            if(p.stat == Status.EMPTY || p.stat == Status.DELETED){         // 선택 버킷의 상태가 비어 있고 또는 지워 졌다면
                p.set(key,data,Status.OCCUPIED);                               // 필드 값으로 키, 데이터, 저장 시키고 난 뒤 0으로 반환
                return 0;
            }
            hash = rehashValue(hash);                               // 해시 값은 재 해시함.
            p = table[hash];                                       // 선택 버킷은 전역변수 해시 값을 가짐
        }
        return 2;                                                   // 테이블이 가득 차면 2로 반환
    }
    // 키 값을 갖는 요소 삭제
    public int delete(K key){
        Bucket<K,V> p = searchNode(key);                //선택 버킷 설정
        if(p == null)                                  //선택 버킷이 null 이면 등록 되어 있지 않다고 1로 반환
            return  1;
        p.setStat(Status.DELETED);                     //선택 버킷의 상태를 지우고 0 으로 반환
        return  0;
    }
    // 해시 테이블 출력
    public void dump(){
        for(int i=0; i<size; i++){                      //전역변수 size  만큼 반복
            System.out.printf("%02d ", i);               // 출력
            switch (table[i].stat){                    //전역변수 table 의 i 번째의 상태를 찾아 낼때
                case OCCUPIED:
                    System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getData());
                    break;                              // 상태가 저장 일 때, 키와 데이터 값 출력
                case EMPTY:
                    System.out.println("-- 미 등록 --");
                    break;                              // 상태가 비어 있을 때, 미등록으로 출력
                case DELETED:
                    System.out.println("-- 삭제 완료--");
                    break;                              // 상태가 삭제 일 때, 삭제 완료 출력
            }
        }
    }
}
