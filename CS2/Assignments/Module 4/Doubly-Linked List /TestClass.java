public class TestClass
{
  public static void main(String[] args)
  { 
    ListNode node1 = new ListNode(new String("String 1"));
    ListNode node2 = new ListNode(new String("String 2"));
    ListNode node3 = new ListNode(new String("String 3"));
    ListNode node5 = new ListNode(new String("String 5"));
    ListNode node4 = new ListNode(new String("String 4"), node3, node5);

    ListNode listHead = node3;

    // add nodes to list
    listHead = listHead.addNodeToBeginning(node1);      // add node1 to the beginning
    listHead.addNodeToEnd(node5);                       // add node5 to the end
    listHead.addNodeAfterNode(node2, listHead);         // add node2 after node1
    node3.addNodeAfterNode(node4, node3);               // add node4 after node3

    // each string should now be printed in order
    System.out.println("\033[92m \nOriginal list below:\033[37m");
    listHead.printListFromHere();
    ListNode.printNumNodes();

    // test concatenate() function
    System.out.println("\033[92m \nConcatenated strings: \n \033[37m" + node3.concatenate());

    // test reverse() function
    System.out.println("\033[92m \nReversed list below:\033[37m");
    listHead = node5.reverse();
    listHead.printListFromHere();

    // test remove nodes
    System.out.println("\033[92m \nRemove all nodes:\n \033[37m");
    testRemoveNodes(listHead);
  }
    
  public static void testRemoveNodes(ListNode listHead) {
    listHead = listHead.removeFirstNode();            // remove node5 (since list has been reversed)
    listHead.printListFromHere();

    listHead = listHead.removeLastNode();             // remove node1
    listHead.printListFromHere();

    listHead = listHead.removeNode(listHead.next);    // remove node3
    listHead.printListFromHere();

    listHead = listHead.removeNode(listHead);         // remove node4
    listHead.printListFromHere();
    
    listHead = listHead.removeNode(listHead);       // remove node2
    System.out.println("listHead is now: " + listHead); // <- should be null!
  }
}