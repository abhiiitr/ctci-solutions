package ctci.chaptertwo;

public class MyLinkedList<T> {

    LinkedListNode head;

    void add(LinkedListNode node) {

        // Add to the last
        if (head == null)
            head = node;
        else {
            LinkedListNode temp = head;
            if (temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    void add(int val) {

        // Add to the last
        if (head == null)
            head = new LinkedListNode(val, null);
        else {
            LinkedListNode temp = head;
            if (temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = new LinkedListNode(val, null);
        }
    }

    LinkedListNode getHead(){
        return  head;
    }
}
