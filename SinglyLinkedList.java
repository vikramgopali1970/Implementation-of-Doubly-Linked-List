
/**
 * created on Aug 27 2018
 *
 * edited on Aug 30 2018
 *
 * Assignment by:
 * Vikram Gopali (netId : vxg180002)
 *
 */


package vxg180002;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {

    /**
     * Class Entry holds a single node of the list
     */
    static class Entry<E> {
        E element;
        Entry<E> next;

        Entry(E x, Entry<E> nxt) {
            element = x;
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

    public Iterator<T> iterator() {
        return new SLLIterator();
    }

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
            if (hasNext()) {
                prev = cursor;
                cursor = cursor.next;
                ready = true;
                return cursor.element;
            } else {
                return null;
            }
        }

        // Removes the current element (retrieved by the most recent next())
        // Remove can be called only if next has been called and the element has not been removed
        public void remove() {
            if (!ready) {
                throw new NoSuchElementException();
            }
            prev.next = cursor.next;
            // Handle case when tail of a list is deleted
            if (cursor == tail) {
                tail = prev;
            }
            cursor = prev;
            ready = false;  // Calling remove again without calling next will result in exception thrown
            size--;
        }


    }  // end of class SLLIterator

    // Add new elements to the end of the list
    public void add(T x) {
        add(new Entry<>(x, null));
    }

    public void add(Entry<T> ent) {
        tail.next = ent;
        tail = tail.next;
        size++;
    }

    public void addFirst(T x) {
        head.next = new Entry<>(x, head.next);
        size++;
    }

    public T removeFirst() {
        T removedElem;
        if (null != head.next) {
            removedElem = head.next.element;
            head.next = head.next.next;
            size--;
            return removedElem;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove(T x) {
        SLLIterator it = new SLLIterator();
        while (it.hasNext() && x != it.next()) {
            it.next();
        }
        if (null != it.next()) {
            it.remove();
        } else {
            throw new NoSuchElementException();
        }
        it.ready = false;
    }

    public void printList() {
        System.out.print(this.size + ": ");
        for (T item : this) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    public boolean IndexOutOfRange(int index) {
        return index >= size;
    }

    public T get(int index) {
        SLLIterator it = new SLLIterator();
        if (this.IndexOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        while (index > 0) {
            it.next();
            index--;
        }
        return it.next();
    }

    public void set(int index, T x) {
        Entry<T> cur = head;
        if (this.IndexOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        while (index >= 0) {
            cur = cur.next;
            index--;
        }
        cur.element = x;
    }

    public void add(int index, T x) {
        Entry<T> cur = head;
        if (this.IndexOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        cur.next = new Entry<>(x, cur.next);
        size++;
    }

    public T remove(int index) {
        SLLIterator it = new SLLIterator();
        T elemRemoved;
        if (this.IndexOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        while (index >= 0) {
            it.next();
            index--;
        }
        if (it.ready) {
            if (it.cursor == tail) {
                it.prev.next = null;
                elemRemoved = it.cursor.element;
                it.cursor = it.prev;
            } else {
                elemRemoved = it.cursor.next.element;
                it.remove();
            }
            size--;
            return elemRemoved;
        } else {
            throw new NoSuchElementException();
        }
    }

    // Rearrange the elements of the list by linking the elements at even index
    // followed by the elements at odd index. Implemented by rearranging pointers
    // of existing elements without allocating any new elements.
    public void unzip() {
        if (size < 3) {  // Too few elements.  No change.
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
        while (c != null) {
            if (state == 0) {
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