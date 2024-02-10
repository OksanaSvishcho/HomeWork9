public class Demo {
    private static int size;

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(4);
        linkedList.add(24);
        linkedList.add(6);
        linkedList.add(14);
        linkedList.add(10);
        System.out.println("MyLinkedList elements:");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        MyArrayList myList = new MyArrayList();

        myList.add(2);
        myList.add(6);
        myList.add(4);

        System.out.println("MyArrayList elements:");

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.peek();
        System.out.println("Stack content (top to bottom):");
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }

        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("hello", "World");
        myHashMap.put("hi", "everyone");

        System.out.println(myHashMap.get("hello"));
        System.out.println(myHashMap.get("hi"));
    }
}
