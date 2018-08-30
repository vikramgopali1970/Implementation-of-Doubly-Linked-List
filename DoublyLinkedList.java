package vxg180002;

import java.util.Iterator;

public class DoublyLinkedList<T> extends SinglyLinkedList<T> implements Iterable<T>{

    static class Entry<E> extends SinglyLinkedList.Entry<E>{
        Entry<E> prev;

        Entry(E x, SinglyLinkedList.Entry<E> nxt, DoublyLinkedList.Entry<E> prev) {
            super(x, nxt);
            this.prev = prev;
        }
    }

    protected DoublyLinkedList.Entry<T> head, tail;


    public DoublyLinkedList() {
        head = new Entry<T>(null, null,null);
        tail = head;
        size = 0;
    }

    public Iterator<T> iterator () {
        return new DLLIterator();
    }

    protected class DLLIterator extends SLLIterator implements Iterator<T>{

        public DLLIterator(){
            super();
            cursor = head;
        }

        public boolean hasPrev(){
            return ((DoublyLinkedList.Entry) cursor).prev != null;
        }

        public T prev(){
            if(hasPrev()){
                cursor = prev;
                prev = ((Entry<T>) cursor).prev;
            }
            return cursor.element;
        }

        public void add(T addElem){
            if (cursor instanceof DoublyLinkedList.Entry){
                cursor.next = new Entry<T>(addElem,cursor.next,((DoublyLinkedList.Entry)cursor));
            }else{
                throw new ClassCastException();
            }
        }
    }

    public void add(T x){
        Entry<T> temp = new Entry<T>(x,null,tail);
        tail.next = temp;
        tail = temp;
    }


}
