import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private static final int DEFAULT_SIZE = 8;
    private Entry<K, V>[] entries = new Entry[DEFAULT_SIZE];
    private int size;

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> entry = new Entry<>(key, value);
        if (entries[index] == null) {
            entries[index] = entry;
        } else {
            Entry<K, V> current = entries[index];
            while (current.next != null) {
                if (Objects.equals(current.key, key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (Objects.equals(current.key, key)) {
                current.value = value;
            } else {
                current.next = entry;
            }
        }
        size++;
    }

    private int getBucketIndex(K key) {
        return Math.abs(Objects.hashCode(key) % entries.length);
    }

    public V remove(Object key) {
        if (key == null)
            return null;

        int index = getBucketIndex((K) key);
        Entry<K, V> current = entries[index];
        Entry<K, V> prev = null;
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (prev == null) {
                    entries[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public void clear() {
        Arrays.fill(entries, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(Object key) {
        if (key == null)
            return null;

        int index = getBucketIndex((K) key);
        Entry<K, V> current = entries[index];
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
}
