import javax.crypto.KEM;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.Map;
import java.util.Vector;

public class MyHashMap<K,V> {

    //This is to have a node of type Key, value and next ptr
    class Entry<K,V> {

        public K key;
        public V value;
        public  Entry next;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private  static final int INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    //an array of type nodes
    public Entry[] hashTable;

    //if no argument is passed then initialize array with initial_capacity
    public MyHashMap() {
        hashTable = new Entry[INITIAL_CAPACITY];
    }

    //if argument is passed then first convert size to next greater 2^n
    public MyHashMap(int size) {
        int tableSize = getSize(size);
        hashTable = new Entry[tableSize];
    }

    //to convert size to 2^n
    private int getSize(int size) {
        int n = (int) Math.ceil(Math.log(size)/Math.log(2));
        n = (int) Math.pow(2,n);
        return n;
    }

    //put function to store key,value pair in map
    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length; //generate hashcode
        Entry node = hashTable[hashCode];   //get node at that hashcode

        //if node is null that means no object is there hence insert current key,value pair object
        //otherwise traverse through the list of nodes and see if any key matches
            //if matches then override the value
        //else insert the node at the end of list
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

    //get function to return value for a key
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
