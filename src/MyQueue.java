import org.w3c.dom.Node;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    public int size;

    private static class Node<T> {
        T value;
        Node<T> next;
        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return head.value;
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T value = head.value;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }
        return value;
    }
}
