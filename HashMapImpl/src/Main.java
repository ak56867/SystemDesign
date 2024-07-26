public class Main {
    public static void main(String[] args) {

        MyHashMap map = new MyHashMap<Integer,Integer>(20);

        map.put(5,24);
        map.put(2,12);
        map.put(1,6);
        map.put(2,14);

        System.out.println("Result: " + map.get(2));
    }
}