package vxg180002;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends SinglyLinkedList<T> implements Iterable<T>{

    static class Entry<E> extends SinglyLinkedList.Entry<E>{
        Entry<E> prev;

        Entry(E x, SinglyLinkedList.Entry<E> nxt, DoublyLinkedList.Entry<E> prev) {
            super(x, nxt);
            this.prev = prev;
        }
    }

    public DoublyLinkedList() {
        super();
        head = new Entry<T>(null, null,null);
        tail = head;
    }

    public Iterator<T> iterator () {
        return new DLLIterator();
    }

    protected class DLLIterator extends SLLIterator implements Iterator<T>{

        public DLLIterator(){
            super();
        }

        public void remove(){
            super.remove();
            ((DoublyLinkedList.Entry) cursor.next).prev = (DoublyLinkedList.Entry)prev;
        }

        public boolean hasPrev(){
            return ((DoublyLinkedList.Entry) cursor).prev != null;
        }

        public T prev(){
            if(hasPrev()){
                cursor = prev;
                prev = ((Entry<T>) cursor).prev;
                ready = true;
            }
            if(null == cursor.element){
                throw new NoSuchElementException();
            }
            return cursor.element;
        }

        public void add(T addElem){
            cursor.next = new Entry<T>(addElem,cursor.next,((DoublyLinkedList.Entry<T>)cursor));
            prev = cursor;
            if(tail == cursor){
                tail = cursor.next;
            }
            cursor = cursor.next;
            size++;
            ready = false;
        }
    }

    public void add(T x){
        super.add(new Entry<T>(x,null,((DoublyLinkedList.Entry<T>)tail)));
    }
}
