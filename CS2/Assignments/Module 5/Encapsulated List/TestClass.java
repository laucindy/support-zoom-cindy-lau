public class TestClass {
    public static void main(String[] args) {
        // Here are some objects we can store in our lists...

        ReadThis r1 = new ReadThis("http://www.bustle.com/articles/" + "63466-im-brianna-wu-and-im-risking-" + "my-life-standing-up-to-gamergate");
        ReadThis r2 = new ReadThis("http://i.imgur.com/4NjBQzn.jpg");
        ReadThis r3 = new ReadThis("http://imgur.com/zhppgSx");
        ReadThis r4 = new ReadThis("http://gnuu.org/2009/09/18/writing-" + "your-own-toy-compiler/all/1/");
        ReadThis r5 = new ReadThis("https://gigaom.com/2015/02/10/samsung-" + "tvs-start-inserting-ads-into-your-movies/");

        // create a linked list, with two items (r2, followed by r3)
        LinkedList list = new LinkedList(r2, r3);

        // add more items to the list
        list.addToBeginning(r1);
        list.addToEnd(r5);
        list.addAfter(r3, r4);

        System.out.println("\033[92m \nAdded items to list:\n \033[37m");
        list.printList();

        System.out.println("Current list length is: " + list.getLength());
        ListNode.printNumNodes();

        System.out.println("\033[92m \n\nPrint list starting from the 3rd item:\n \033[37m");
        list.printListFromHere(r3);

        // remove items from the list
        list.removeFirstItem();
        list.removeLastItem();
        list.removeItem(r3);
        list.removeItem(r4);
        list.removeItem(r2);
    
        System.out.println("\033[92m \n\nRemoved all items from list:\n \033[37m");
        list.printList();
        System.out.println("Current list length is: " + list.getLength());
    }

}