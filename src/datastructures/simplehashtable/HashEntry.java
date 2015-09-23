package datastructures.simplehashtable;

/**
 * Created by paulberesuita on 8/21/15.
 * test comment
 */
public class HashEntry {

    private int key;
    private int value;

    HashEntry(int _key, int _value) {
        key = _key;
        value = _value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

}
