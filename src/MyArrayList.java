import java.util.Arrays;

public class MyArrayList {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Object value) {
        ensureCapacity();
        array[size++] = value;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        return array[index];
    }
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}

