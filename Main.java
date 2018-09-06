package vxg180002;

/*
* created on Aug 27 2018
*
* team Members :
* Vikram Gopali (netId : vxg180002)
* Nirbhay Sibal (netId : nxs180002)
*/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchElementException {
        DoublyLinkedList<Integer> dlst = new DoublyLinkedList<>();
        for (int i=0;i<10;i++){
            dlst.add(i);
        }

        Iterator<Integer> it = dlst.iterator();
        while(it.hasNext()){
            Scanner in = new Scanner(System.in);
            whileloop:
            while(in.hasNext()) {
                int com = in.nextInt();
                switch(com) {
                    case 1:  // Move to next element and print it
                        if (it.hasNext()) {
                            System.out.println(it.next());
                        } else {
                            break whileloop;
                        }
                        break;
                    case 2:  // Remove element
                        it.remove();
                        dlst.printList();
                        break;
                    case 3:  // Move to previous element and print it
                        System.out.println(((DoublyLinkedList<Integer>.DLLIterator)it).prev());
                        break;
                    case 4:  // add element before returning the element in next() and print the list
                        System.out.println("Please enter the value you want to enter");
                        ((DoublyLinkedList<Integer>.DLLIterator)it).add(in.nextInt());
                        dlst.printList();
                        break;
                    case 5:  // add element at the tail
                        System.out.println("Please enter the value you want to enter");
                        dlst.add(in.nextInt());
                        dlst.printList();
                        break;
                    default:  // Exit loop
                        break whileloop;
                }
            }
        }
    }
}



/*
* Doubly Linked List
* Sample Input:
* 0,1,2,3,4,5,6,7,8,9
*
* Sample Output:
* 1
* 0
* 1
* 1
* 1
* 2
* 2
* 9: 0 1 3 4 5 6 7 8 9
* 3
* 1
* 3
* 0
* 4
* Please enter the value you want to enter
* 456
* 10: 0 456 1 3 4 5 6 7 8 9
* 1
* 456
* 1
* 1
* 1
* 3
* */