package vxg180002;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchElementException {
        int n = 10;
        if(args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        SinglyLinkedList<Integer> lst = new SinglyLinkedList<>();
        for(int i=1; i<=n; i++) {
            lst.add(Integer.valueOf(i));
        }
        lst.printList();

        // the .iterator class here in the next line is pointing to the iterator class in SinglyLinkedList.

        Iterator<Integer> it = lst.iterator();
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
                    lst.printList();
                    break;
                default:  // Exit loop
                    break whileloop;
            }
        }
        lst.printList();
        lst.unzip();
        lst.printList();

//        DoublyLinkedList<Integer> dlst = new DoublyLinkedList<>();
//        for (int i=0;i<10;i++){
//            dlst.add(i);
//        }
//
//        Iterator<Integer> it = dlst.iterator();
//        while(it.hasNext()){
//            Scanner in = new Scanner(System.in);
//            whileloop:
//            while(in.hasNext()) {
//                int com = in.nextInt();
//                switch(com) {
//                    case 1:  // Move to next element and print it
//                        if (it.hasNext()) {
//                            System.out.println(it.next());
//                        } else {
//                            break whileloop;
//                        }
//                        break;
//                    case 2:  // Remove element
//                        it.remove();
//                        dlst.printList();
//                        break;
//                    case 3:  // Move to previous element and print it
//                        System.out.println(((DoublyLinkedList.DLLIterator)it).prev());
//                        break;
//                    case 4:  // add element before returning the element in next()
//                        System.out.println("Please enter the value you want to enter");
//                        ((DoublyLinkedList.DLLIterator)it).add(in.nextInt());
//                        break;
//                    default:  // Exit loop
//                        break whileloop;
//                }
//            }
//        }
    }
}
