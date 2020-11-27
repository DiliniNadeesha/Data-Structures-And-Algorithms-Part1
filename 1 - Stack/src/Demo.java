public class Demo {

    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.printStack();

        s1.push(100);
        s1.push(200);
        s1.push(300);
        s1.push(400);
        s1.printStack(); // [400,300,200,100]

        s1.pop();
        s1.pop();
        s1.printStack(); // [200,100]
    }

}
