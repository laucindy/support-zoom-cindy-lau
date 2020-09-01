public class LinkedList {
    private ListNode listHead;

    public LinkedList() {
        this.listHead = null;
    }

    public LinkedList(ReadThis data1) {
        this.listHead = new ListNode(data1);
    }

    public LinkedList(ReadThis data1, ReadThis data2) {
        ListNode node2 = new ListNode(data2);
        ListNode node1 = new ListNode(data1, node2);

        this.listHead = node1;
    }

    // print list starting from a specified node
    public void printList(ListNode currNode) {
        System.out.println("----------\nStart List\n----------");
        if (currNode == null) {
            System.out.println("\tEmpty list");
        }

        while (currNode != null) {
            System.out.println("\t" + currNode.getData());
        //    System.out.println("\t" + currNode.getNext() + "\n");     // debugging next attribute
            currNode = currNode.getNext();
        }
        System.out.println("----------\nEnd List\n----------");
    }

    // prints the list starting from the beginning
    public void printList() {
        printList(listHead);
    }

    // prints the list starting from the ListNode that matches the passed in data (assumes no duplicates)
    public void printListFromHere(ReadThis data) {
        // find node matching data
        ListNode currNode = findNode(data);

        // reached the end of the list, and node wasn't found
        if (currNode == null) {
            System.out.println("Item matching " + data.url + " not found");
            return;
        }

        // if node was found, print list
        printList(currNode);
    }

    // add item to the beginning of the list
    public void addToBeginning(ReadThis data) {
        ListNode newNode = new ListNode(data, this.listHead);
        this.listHead = newNode;
    }

    // add item to the end of the list
    public void addToEnd(ReadThis data) {
        ListNode newNode = new ListNode(data);
        ListNode currNode = listHead;

        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
        }

        currNode.setNext(newNode);
    }

    // add item after a specific ReadThis object (assumes no duplicates in the list)
    public void addAfter(ReadThis addAfterData, ReadThis newData) {
        ListNode newNode = new ListNode(newData);

        // find node with data
        ListNode currNode = findNode(addAfterData);

        // could not find node
        if (currNode == null) {
            System.out.println("Could not find " + newData);
            return;
        }

        // add new node after current node
        newNode.setNext(currNode.getNext());
        currNode.setNext(newNode);

    }

    // remove first item from the list (this can be null)
    public void removeFirstItem() {
        this.listHead = this.listHead.getNext();
    }

    // remove last item from the list
    public void removeLastItem() {
        // if there is only one item in the list, return an empty list
        if (this.listHead.getNext() == null) {
            this.listHead = null;
            return;
        }

        // otherwise, find the last node to remove
        ListNode currNode = this.listHead;
        ListNode prevNode = null;

        while (currNode.getNext() != null) {
            prevNode = currNode;
            currNode = currNode.getNext();
        }

        prevNode.setNext(null);
    }

    // remove item with data that matches the passed in data parameter
    public void removeItem(ReadThis data) {
        ListNode currNode = this.listHead;

        // check if the item to remove is the first one
        if (currNode.getData().equals(data)) {
            removeFirstItem();
            return;
        }

        // otherwise, search the list to find the node that matches the passed in data
        while ((currNode.getNext() != null) && !currNode.getNext().getData().equals(data)) {
            currNode = currNode.getNext();
        }

        if (currNode.getNext() == null) {
            System.out.println("Could not find node : " + data + " to remove");
            return;
        }

        currNode.setNext(currNode.getNext().getNext());
    }

    // get the length of the list, starting from the beginning
    public int getLength() {
        int length = 0;

        ListNode currNode = listHead;
        while (currNode != null) {
            length++;
            currNode = currNode.getNext();
        }

        return length;
    }

    // find the node that matches the passed in data
    private ListNode findNode(ReadThis data) {
        ListNode currNode = listHead;
        ReadThis currNodeData = currNode.getData();

        while ((currNode != null) && !currNodeData.equals(data)) {
            currNode = currNode.getNext();
            if (currNode != null) {
                currNodeData = currNode.getData();
            }
        }

        return currNode;
    }
}