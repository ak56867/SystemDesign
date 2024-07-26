import javax.crypto.KEM;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.Map;
import java.util.Vector;

public class MyHashMap<K,V> {

    private  static final int INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_CAPACITY];
    }

    public MyHashMap(int size) {
        int tableSize = getSize(size);
        hashTable = new Entry[tableSize];
    }

    private int getSize(int size) {
        int n = (int) Math.ceil(Math.log(size)/Math.log(2));
        n = (int) Math.pow(2,n);
        System.out.println("Value of next greater capacity: " + n);
        return n;
    }

    class Entry<K,V> {

        public K key;
        public V value;
        public  Entry next;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null) {
            Entry newNode = new Entry(key,value);
            hashTable[hashCode] = newNode;
        } else {
            Entry previousNode = node;
            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key,value);
            previousNode.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while (node != null) {
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node = node.next;
        }

        return null;
    }
}
