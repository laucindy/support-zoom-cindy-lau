public class TestClass
{
  public static void main(String[] args)
  {
    String s1 = new String("String 1");
    String s2 = new String("String 2");
    String s3 = new String("String 3");
    String s4 = new String("String 4");
    String s5 = new String("String 5");
    
    ListNode node1 = new ListNode(s1);
    ListNode node2 = new ListNode(s2);
    ListNode node3 = new ListNode(s3);
    ListNode node5 = new ListNode(s5);
    ListNode node4 = new ListNode(s4, node3, node5);

    ListNode listHead = node3;

    listHead = listHead.addNodeToBeginning(node1);      // add node1 to the beginning
    listHead.addNodeToEnd(node5);                       // add node5 to the end
    listHead.addNodeAfterNode(node2, listHead);         // add node2 after node1
    node3.addNodeAfterNode(node4, node3);               // add node4 after node3

    // each string should now be printed in order
  //  listHead.printListFromHere();
  //  ListNode.printNumNodes();

  //  testRemoveNodes(listHead);

    System.out.println("Concatenated strings: " + node3.concatenate());

    node2.reverse();

    listHead.printListFromHere();
  }
    
  public static void testRemoveNodes(ListNode listHead) {
    listHead = listHead.removeFirstNode();            // remove node1
    listHead = listHead.removeLastNode();             // remove node5      
    listHead = listHead.removeNode(listHead.next);    // remove node3
    listHead = listHead.removeNode(listHead);         // remove node2

    // one node remaining (node4)
    listHead.printListFromHere();
    
    listHead = listHead.removeNode(listHead);       // remove node4
    System.out.println("listHead is now: " + listHead); // <- should be null!
  }
}