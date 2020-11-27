class SinglyLinkedList {

    Node head;
    int size;

    public void add(int data) {
        size++;
        if (head == null) {
            head = new Node(data, null);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data, null);
    }

    public void printList() {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println("\b\b]");
    }

    public void remove(int index) {
        if (index == 0){
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (i == (index - 1)){
                temp.next = temp.next.next;
                size--;
                break;
            }
            temp = temp.next;
            i++;
        }
    }

    int size(){
        return size;
    }

    void clear(){
        size = 0;
        head = null;
    }

}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Demo {

    public static void main(String[] args) {

        SinglyLinkedList ls = new SinglyLinkedList();
        ls.add(100);
        ls.add(200);
        ls.add(300);
        ls.add(400);
        ls.printList();     // [100,200,300,400]

        ls.remove(3);
        ls.printList();     // [100,200,400]

        System.out.println("Size : " + ls.size()); // Size : 3

        ls.clear();
        ls.printList();     // []

    }

}
