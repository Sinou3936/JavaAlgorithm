package chap10;

import java.util.Comparator;

public class Q2<K,V> {
    static class Node<K,V>{
        private K key;      // 키 값
        private V data;     // 데이터
        private Node<K,V> left;     //왼쪽 자식 노드
        private Node<K,V> right;    //오른쪽 자식 노드

        //생성자
        Node(K key, V value, Node<K,V> left,Node<K,V> right){
            this.key = key;
            this.data = value;
            this.left = left;
            this.right = right;
        }
        //키 값 반환
        public K getKey(){
            return  key;
        }
        //데이터 반환
        public V getValue(){
            return data;
        }
        //출력
        public void print(){
            System.out.println(data);
        }
    }
    private Node<K,V> root;     //루트
    private Comparator<? super K> comparator = null;    //비교자

    // 생성자 -> 자연 순서에 따라 키 값 비교
    public Q2(){
        root = null;
    }
    //생성자 -> 비교자로 키 값을 비교
    public Q2(Comparator<? super  K> c){
        this();
        comparator = c;
    }

    // 두 키 값을 비교 함.
    private int comp(K key1,K key2){
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1,key2);
    }

    // 키에 의한 검색
    public V search(K key){
        Node<K,V> p = root;         //루트
        while (true){
            if(p == null) return  null;         // 더이상 진행 하지 않으면 실패
            int cond = comp(key,p.getKey());     // key 와 노드 p의 키 비교
            if(cond == 0)  return p.getValue(); // 같으면 데이터 반환
            else if(cond < 0) p = p.left;       // 작으면 p는 왼쪽에서 검색
            else p = p.right;                  // 크면  p는 오른쪽에서 검색
        }
    }

    //node를 루트로 하는 서브 트리에 노드<K,V> 삽입
    private void addNode(Node<K,V> node, K key, V value){
        int cond = comp(key,node.getKey());
        if(cond == 0) return;   // key가 이진트리에 이미 있음.
        else if( cond < 0) {
            if (node.left == null) node.left = new Node<K, V>(key, value, null, null);
            else addNode(node.left,key,value);      // 왼쪽 서브 트리에
        }else{
            if(node.right == null) node.right = new Node<K,V>(key,value,null,null);
            else addNode(node.right, key, value);   //오른쪽 서브 트리에
        }
    }

    // 노드 삽입
    public void add(K key, V data){
        if(root == null) root = new Node<K,V>(key,data,null,null);
        else addNode(root,key,data);
    }

    //키 값 key인 노드 삭제
    public boolean remove(K key){
        Node<K,V> p = root;             //스캔 중인 노드
        Node<K,V> parent = null;        //스캔 중인 노드의 부모 노드
        boolean isLeftChild = true;    //p는 부모의 왼쪽 자식??

        while (true){
            if(p == null) return false;     //더 이상 진행 하지 않으면 값읍 없음.
            int cond = comp(key,p.getKey()); //key 와 노드 p의 값 비교
            if(cond == 0) break;            // 같으면 성공
            else{
                parent = p;                 //가지로 내려 가기 전 부모를 설정
                if(cond < 0){               // key 보다 작으면
                    isLeftChild = true;     // 왼쪽으로  내려감
                    p = p.left;             // 왼쪽에서 검색
                }else {
                    isLeftChild = false;   // key 보다 크면 오른쪽으로 내려감
                    p = p.right;           // 오른쪽에서 검색
                }
            }
        }

        if(p.left == null){                                 //p에 왼쪽 자식 없을 때
            if(p == root) root = p.right;
            else if( isLeftChild) parent.left = p.right;   // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            else parent.right = p.right;                   // 부모의 오른쪽 포인터가 오른쪽 자식 가리킴
        }else if(p.right == null){                         //p에 오른쪽 자식 없을 때
            if(p == root) root = p.left;
            else if(isLeftChild) parent.left = p.left;     //부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
            else parent.right = p.left;                    //부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
        }else{
            parent = p;
            Node<K,V> left = p.left;                        // 서브 트리 가운데 가장 큰 노드
            isLeftChild = true;
            while (left.right != null){                    // 가장 큰 노드 left를 검색
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;                                // left 의 키 값을 p로 옮김
            p.data = left.data;                             // left 의 데이터를 p로 옮김
            if(isLeftChild) parent.left = left.left;        // left 를 삭제
            else parent.right = left.left;                  // left 를 삭제
        }
        return true;
    }

    // node를 루트로 하는 서브 트리의 노드를 키 값의 오름 차순을 출력
    private void printSubTree(Node node){
        if(node != null){
            printSubTree(node.left);                        // 왼쪽 서브 트리 키 값의 오름차순으로 출력
            System.out.println(node.key+ " "+ node.data);  // node 출력
            printSubTree(node.right);                       // 오른쪽 서브 트리 키 값의 오름차순으로 출력
        }
    }
    // node 를 루트로 하는 서브 트리의 노드를 키 값의 내림차순 출력
    private void printReverse(Node node){
        if(node != null){
            printReverse(node.right);                   //오른쪽 서브 트리 키 값의 오름차순으로 출력
            System.out.println(node.key.toString()+" "+node.data.toString()); // node 출력
            printReverse(node.left);                    // 왼쪽 서브 트리 키 값의 오름차순으로 출력
        }
    }

    // 모든 노드를 키 값의 오름차순으로 출력
    public void print(){
        printSubTree(root);
    }
    // 모든 노드를 키 값의 내림차순으로 출력
    public void printR(){
        printReverse(root);
    }

    private Node<K,V> getMinNode(){
        if(root == null){
            return  null;
        }else{
            Node<K,V> p = root;

            while (p.left  != null)
                p = p.left;
            return p;
        }
    }
    private Node<K,V> getMaxNode(){
        if(root == null){
            return  null;
        }else{
            Node<K,V> p = root;

            while (p.right  != null)
                p = p.right;
            return p;
        }
    }

    public K getMinKey(){
        Node<K,V> minVal = getMinNode();
        return (minVal  == null ? null : minVal.getKey());
    }
    public V getDataWithMinKey(){
        Node<K,V> minVal = getMinNode();
        return (minVal == null ? null : minVal.getValue());
    }
    public K getMaxKey(){
        Node<K,V> maxKey = getMaxNode();
        return (maxKey == null ? null : maxKey.getKey());
    }
    public V getDataWithMaxKey(){
        Node<K,V> maxVal = getMaxNode();
        return (maxVal == null ? null : maxVal.getValue());
    }
}
