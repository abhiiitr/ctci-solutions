package ctci.chaptertwo;

public class SumLists {

    //  2.5  Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
    //
    //EXAMPLE Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .
    // Thatis,617 + 295.
    //
    //Output: 2 -) 1 -) 9. That is, 912.
    //
    //FOLLOW UP
    // Suppose the digits are stored in forward order. Repeat the above problem.
    // EXAMPLE Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).
    // Thatis,617 + 295. Output: 9 -) 1 -) 2. That is, 912.

    public static void main(String[] args) {
        // 321 + 987 =  1308
        MyLinkedList list1 = new MyLinkedList();
//        list1.add(1);
        list1.add(2);
        list1.add(3);
        MyLinkedList list2 = new MyLinkedList();
        list2.add(7);
        list2.add(8);
        list2.add(9);
        SumLists obj = new SumLists();
        final LinkedListNode n1 = list1.getHead();
        obj.printList(n1);
        final LinkedListNode n2 = list2.getHead();
        obj.printList(n2);

        obj.findSumListsReverse(n1, n2);
    }

    public LinkedListNode findSumListsReverse(LinkedListNode n1, LinkedListNode n2) {


        LinkedListNode result = findSumListsReverseUtil(n1, n2, 0);
        printList(result);

        return result;
    }

    private LinkedListNode findSumListsReverseUtil(LinkedListNode n1, LinkedListNode n2, int carry) {

        if (n1 == null && n2 == null && carry == 0)
            return null;

        LinkedListNode result = new LinkedListNode();
        int val = carry;

        if (n1 != null)
            val += n1.data;
        if (n2 != null)
            val += n2.data;

        result.data = val % 10;
        if (n1 != null || n2 != null)
            result.next = findSumListsReverseUtil(n1 != null ? n1.next: null, n2 != null ? n2.next: null, val / 10);

        return result;
    }


    private void printList(LinkedListNode result) {

        LinkedListNode temp = result;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();

    }
}
