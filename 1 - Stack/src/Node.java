public class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}

class Stack {
    private Node top;

    public void push(int data) {
        Node n1 = new Node(data);
        n1.next = top;
        top = n1;
    }

    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }

    public void printStack() {
        System.out.print("[");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
            if (temp == null){
                System.out.print("\b\b");
            }
        }
        System.out.println("]");
    }
}
