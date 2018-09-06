# Implementation-of-Doubly-Linked-List
Implementation of doubly linked list in java with extending singly linked list with generics.


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

Sample Input : <br/>
0,1,2,3,4,5,6,7,8,9<br/>

Sample Output:('->' indicated console input)<br/>
-> 1<br/>
0<br/>
->1<br/>
1<br/>
->1<br/>
2<br/>
->2<br/>
9: 0 1 3 4 5 6 7 8 9<br/>
->3<br/>
1<br/>
->3<br/>
0<br/>
->4<br/>
Please enter the value you want to enter<br/>
->456<br/>
10: 0 456 1 3 4 5 6 7 8 9<br/>
->1<br/>
456<br/>
->1<br/>
1<br/>
->1<br/>
3<br/>
->5<br/>
Please enter the value you want to enter<br/>
->5677<br/>
11: 0 456 1 3 4 5 6 7 8 9 5677<br/>
