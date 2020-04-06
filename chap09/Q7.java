package chap09;

import java.util.Comparator;

public class Q7<E> {
    class Node<E>{
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
        Node(E data){
            this.data =data;
            this.next = this;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private Node<E> crnt;

    public Q7(){
        head = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c){
        if (head != null) {
            Node<E> ptr = head;

            while (ptr != head) {
                if (c.compare(obj, ptr.data) == 0) {
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next;
            }
        }
        return null;
    }

    public void addFirst(E obj){
        if(head == null) {
            head = crnt = tail= new Node<E>(obj);
        }else {
            Node<E> ptr = head;
            head = crnt = new Node<E>(obj);
            tail.next = head;
        }
    }

    public void addLast(E obj){
        if(head == null)
            addFirst(obj);
        else {
            Node<E> ptr = head;
            ptr.next = crnt = tail = new Node<E>(obj,null);
        }
    }

    public void removeFirst(){
        if(head != null)
            if(head == tail)
                head = crnt = head.next;
            else{
                Node<E> ptr = head.next;
                head = crnt = ptr;
                tail.next = head;
            }
    }

    public void removeLast(){
        if(head != null){
            if(head == tail)
                removeFirst();
            else {
                Node<E> ptr = head;
                Node<E> pre = head;

                while (ptr.next != null){
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = head;
                tail = crnt = pre;
            }
        }
    }

    public void remove(Node p){
        if(head != null){
            if(p == head) removeFirst();
            else if(p == tail) removeLast();
            else{
                Node<E> ptr = head;

                while (ptr.next != p){
                    ptr = ptr.next;
                    if(ptr == null) return;
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode(){
        remove(crnt);
    }

    public void clear(){
        while (head != null)
            removeFirst();
        crnt = null;
    }

    public boolean next(){
        if(crnt == null || crnt.next == null) return false;
        crnt = crnt.next;
        return  true;
    }

    public void printCurrentNode(){
        if(crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    public void dump(){
        Node<E> ptr = head;

        while (ptr != null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

}
