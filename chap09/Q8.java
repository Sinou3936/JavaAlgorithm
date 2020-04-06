package chap09;

import java.util.Comparator;

public class Q8<E> {
    class Node<E> {
        private E data;
        private int next;
        private int dnext;

        public void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E>[] n;
    private int size;
    private int max;
    private int head;
    private int tail;
    private int crnt;
    private int deleted;
    private static final int NULL = -1;

    public Q8(int capacity){
        head = crnt = max = deleted = tail = NULL;
        try{
            n = new Node[capacity];
            for(int i=0; i<capacity; i++)
                n[i] = new Node<E>();
            size = capacity;
        }
        catch (OutOfMemoryError e){
            size = 0;
        }
    }

    private int getInsertIndex(){
        if(deleted == NULL){
            if(max < size) return ++max;
            else return  NULL;
        }else{
            int rec = deleted;
            deleted = n[rec].dnext;
            return rec;
        }
    }

    private void deleteIndex(int idx){
        if(deleted == NULL){
            deleted = idx;
            n[idx].dnext = NULL;
        }else{
            int rec = deleted;
            deleted = idx;
            n[idx].dnext = rec;
        }
    }

    public E search(E obj, Comparator<? super  E> c){
        if(head  != NULL ) {
            int ptr = head;

            while (ptr != head) {
                if (c.compare(obj, n[ptr].data) == 0) {
                    crnt = ptr;
                    return n[ptr].data;
                }
                ptr = n[ptr].next;
            }
        }
        return null;
    }

    public void addFirst(E obj){
        if(head == NULL) {
            int ptr = head;
            int rec = getInsertIndex();
            if (rec != NULL) {
                head = crnt= tail = rec;
                n[head].set(obj, ptr);
            }
        }else {
            int ptr = head;
            int rec = getInsertIndex();
            if(rec != NULL){
                head = crnt = rec;
                n[head].set(obj, ptr);
                n[tail].next = head;
            }
        }
    }

    public void addLast(E obj){
        if(head == NULL)
            addFirst(obj);
        else{
            int rec = getInsertIndex();
            if(rec != NULL){
                n[tail].next = crnt = rec;
                n[rec].set(obj,NULL);
                tail = rec;
            }
        }
    }
    public void removeFirst(){
        if(head != NULL){
            if(head == tail) {
                deleteIndex(head);
                head = crnt = tail = NULL;
            }else {
                int ptr = n[head].next;
                deleteIndex(head);
                head = crnt = ptr;
                n[tail].next = head;
            }
        }
    }

    public void removeLast(){
        if(head != NULL){
            if(head == tail) removeFirst();
            else {
                int ptr = head;
                int pre = head;

                while (n[ptr].next != NULL){
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = head;
                deleteIndex(ptr);
                tail = crnt = pre;
            }
        }
    }

    public void  remove(int p){
        if(head != NULL){
            if(p == head) removeFirst();
            else if(p == tail) removeLast();
            else {
                int ptr = head;

                while (n[ptr].next != p){
                    ptr = n[ptr].next;
                    if(ptr == NULL) return;
                }
                n[ptr].next =NULL;
                deleteIndex(p);
                n[ptr].next = n[p].next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode(){
        remove(crnt);
    }

    public void clear(){
        while (head != NULL) removeFirst();
        crnt = NULL;
    }

    public boolean next(){
        if(crnt == NULL || n[crnt].next == NULL)
            return false;
        crnt = n[crnt].next;
        return true;
    }

    public void printCurrentNode(){
        if(crnt == NULL)
            System.out.println("선택 된 노드가 없습니다,");
        else
            System.out.println(n[crnt].data);
    }

    public void dump(){
        int ptr = head;

        while (ptr != NULL){
            System.out.println(n[ptr].data);
            ptr = n[ptr].next;
        }
        System.out.println();
    }
}
