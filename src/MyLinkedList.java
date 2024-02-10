import java.util.Objects;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;
        public Node(T value) {
            this.value = value;
        }
    }
    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        } if (currentNode.previous != null) {
            currentNode.previous.next = currentNode.next;
        } else {
            head = currentNode.next;
        } if (currentNode.next != null) {
            currentNode.next.previous = currentNode.previous;
        } else {
            tail = currentNode.previous;
        }
        size--;
    }
    public void clear() {
        head = tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public int getSize() {
        return size;
    }
    public T get(int index) {
        Objects.checkIndex(index, size);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }
}
