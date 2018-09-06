# Implementation-of-Doubly-Linked-List
Implementation of doubly linked list in java with extending singly linked list with generics.

/*
* created on Sep 1 2018
*
* Project started working on Aug 27 2018
* team Members :
* Vikram Gopali (netId : vxg180002)
* Nirbhay Sibal (netId : nxs180002)
*/

Compiling the code in IntelliJ Idea:
* create a empty project.
* Navigate to 'projectName'->src folder.
* paste the unzipped folder inside the src folder.
* In the above menu select Run->Run...
* select the 'className'

Running the code:
* Initially the doubly linked list gets initialized with elements from 0 to 9.
* Option 1 : would print the next element in the list and since the dummy header is 
  present, it will print the first element pointed by the dummy header.
* Option 2 : would remove the current that is pointed by the cursor node.
* Option 3 : would traverse the list backwards and print the previous element.
* Option 4 : prompts for the element value to be inserted and inserts the same between the 
  cursor and next element.
* Option 5 : inserts node at the tail.

Sample Input : 
0,1,2,3,4,5,6,7,8,9

Sample Output:('->' indicated console input)
-> 1
0
->1
1
->1
2
->2
9: 0 1 3 4 5 6 7 8 9
->3
1
->3
0
->4
Please enter the value you want to enter
->456
10: 0 456 1 3 4 5 6 7 8 9
->1
456
->1
1
->1
3
->5
Please enter the value you want to enter
->5677
11: 0 456 1 3 4 5 6 7 8 9 5677
