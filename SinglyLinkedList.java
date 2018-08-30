

/** @author rbk
 *  Singly linked list: for instructional purposes only
 *  Ver 1.0: 2018/08/21
 *  Entry class has generic type associated with it, to allow inheritance.
 *  We can now have a doubly linked list class DLL that has

public class DoublyLinkedList<T> extends SinglyLinkedList<T> {
static class Entry<E> extends SinglyLinkedList.Entry<E> {
Entry<E> prev;
Entry(E x, Entry<E> next, Entry<E> prev) {
super(x, nxt);
this.prev = prev;
}
}

 */
package vxg180002;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {

    /** Class Entry holds a single node of the list */
    static class Entry<E> {
        E element;
        Entry<E> next;

        Entry(E x, Entry<E> nxt) {
            element = x;
            if(x != null)
            next = nxt;
        }
    }

    // Dummy header is used.  tail stores reference of tail element of list
    Entry<T> head, tail;
    int size;

    public SinglyLinkedList() {
        head = new Entry<>(null, null);
        tail = head;
        size = 0;
    }

    /*
        * Here is the description of the usage of iterator and iterable in this file.
        * We have imported the iterator class and used it to iterate over the elements
          in the SLLIterator class.
        * And the Iterable interface which has a iterator method is defined in this file to
          return the SLLIterator object.
        * In the main we use the iterator class defined here.
        * Refer this : https://gist.github.com/jnwhiteh/68d095c630dfcaddffd1
     */

    public Iterator<T> iterator() { return new SLLIterator(); }

    protected class SLLIterator implements Iterator<T> {
        Entry<T> cursor, prev;
        boolean ready;  // is item ready to be removed?

        SLLIterator() {
            cursor = head;
            prev = null;
            ready = false;
        }

        public boolean hasNext() {
            return cursor.next != null;
        }

        public T next() {
            prev = cursor;
            cursor = cursor.next;
            ready = true;
            return cursor.element;
        }

        // Removes the current element (retrieved by the most recent next())
        // Remove can be called only if next has been called and the element has not been removed
        public void remove() {
            if(!ready) {
                throw new NoSuchElementException();
            }
            prev.next = cursor.next;
            // Handle case when tail of a list is deleted
            if(cursor == tail) {
                tail = prev;
            }

            //following statement cursor and previous will be the same because the next() always
            // moves ahead and then prints the value and not vice versa
            cursor = prev;
            ready = false;  // Calling remove again without calling next will result in exception thrown
            size--;
        }
    }  // end of class SLLIterator

    // Add new elements to the end of the list
    public void add(T x) {
        tail.next = new Entry<>(x, null);
        tail = tail.next;
        size++;
    }

    public void printList() {
        System.out.print(this.size + ": ");
        for(T item: this) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    // Rearrange the elements of the list by linking the elements at even index
    // followed by the elements at odd index. Implemented by rearranging pointers
    // of existing elements without allocating any new elements.
    public void unzip() {
        if(size < 3) {  // Too few elements.  No change.
            return;
        }

        Entry<T> tail0 = head.next;
        Entry<T> head1 = tail0.next;
        Entry<T> tail1 = head1;
        Entry<T> c = tail1.next;
        int state = 0;

        // Invariant: tail0 is the tail of the chain of elements with even index.
        // tail1 is the tail of odd index chain.
        // c is current element to be processed.
        // state indicates the state of the finite state machine
        // state = i indicates that the current element is added after taili (i=0,1).
        while(c != null) {
            if(state == 0) {
                tail0.next = c;
                tail0 = c;
                c = c.next;
            } else {
                tail1.next = c;
                tail1 = c;
                c = c.next;
            }
            state = 1 - state;
        }
        tail0.next = head1;
        tail1.next = null;
        // Update the tail of the list
        tail = tail1;
    }
}