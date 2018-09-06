package vxg180002;

/**
* created on Aug 27 2018
*
* edited on Aug 30 2018
*
* Assignment by:
* Vikram Gopali (netId : vxg180002)
*
*/

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

        Iterator<Integer> it = lst.iterator();
        Scanner in = new Scanner(System.in);
        whileloop:
        while(in.hasNext()) {
            int com = in.nextInt();
            int ind;
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
                case 3:  // adds element in the beginning
                    System.out.println("enter the value of the node");
                    lst.addFirst(in.nextInt());
                    lst.printList();
                    break;
                case 4:  // Remove first element
                    lst.removeFirst();
                    lst.printList();
                    break;
                case 5:  // Remove a element at a particular index
                    System.out.println("enter the index of the node to be deleted");
                    lst.remove(in.nextInt());
                    lst.printList();
                    break;
                case 6:  // get element at index
                    System.out.println("enter the index to be retrieved");
                    System.out.println("element is "+lst.get(in.nextInt()));
                    break;
                case 7:  // set element at index
                    System.out.println("enter the index to be set");
                    ind = in.nextInt();
                    System.out.println("enter the value to be set");
                    lst.set(ind,in.nextInt());
                    lst.printList();
                    break;
                case 8:  // add an element at particular index
                    System.out.println("enter the index to be add new node");
                    ind = in.nextInt();
                    System.out.println("enter the value to be added");
                    lst.add(ind,in.nextInt());
                    lst.printList();
                    break;
                case 9:  // remove node at a particular index
                    System.out.println("enter the index to delete");
                    lst.remove(in.nextInt());
                    lst.printList();
                    break;
                default:  // Exit loop
                    break whileloop;
            }
        }
        lst.printList();
        lst.unzip();
        lst.printList();
    }
}



/*

Sample Input :
1,2,3,4,5,6,7,8,9,10

Sample Output :
10: 1 2 3 4 5 6 7 8 9 10
1
1
1
2
1
3
1
4
2
9: 1 2 3 5 6 7 8 9 10
1
5
1
6
3
enter the value of the node
4445
10: 4445 1 2 3 5 6 7 8 9 10
3
enter the value of the node
333
11: 333 4445 1 2 3 5 6 7 8 9 10
4
10: 4445 1 2 3 5 6 7 8 9 10
5
enter the node to be deleted
9
9: 4445 1 2 3 5 6 7 8 9
6
enter the index to be retrieved
4
element is 5
7
enter the index to be set
4
enter the value to be set
666
9: 4445 1 2 3 666 6 7 8 9
8
enter the index to be add new node
2
enter the value to be added
444
10: 4445 1 444 2 3 666 6 7 8 9
9
enter the index to delete
7
8: 4445 1 444 2 3 666 6 8 9

 */