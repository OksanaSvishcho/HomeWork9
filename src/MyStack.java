public class MyStack<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(E value) {
        ensureCapacity(size + 1);
        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null; // Remove reference to the last element
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
        E element = (E) array[size - 1];
        return element;
    }

    public E pop() {
        E obj = peek();
        array[--size] = null; // Remove reference to the last element
        return obj;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}