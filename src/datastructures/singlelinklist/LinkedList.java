package datastructures.singlelinklist;

/**
 * Created by paulberesuita on 8/21/15.
 */
public class LinkedList {


    private Node head;
    private int listCount;

    public LinkedList() {

        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data) {

        Node temp = new Node(data);
        Node current = head; //KEY: here we are making current to be head (share same memory address)

        while(current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(temp);
        listCount++;

    }

    public void add(Object data, int index) {

        Node temp = new Node(data);
        Node current = head;

        for(int i=1; i < index && current.getNext()!=null; i++) {
            current = current.getNext();
        }

        temp.setNext(current.getNext());
        current.setNext(temp);

        listCount++;
    }

    public Object get(int index) {

        if(index <= 0) {
            return null;
        }

        Node current = head.getNext();

        for(int i=1; i < index; i++) {

            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }

        return current.getData();
    }

    public boolean remove(int index) {

        if(index < 1 || index > size()) {
            return false;
        }

        Node current = head;

        for(int i=1; i < index; i++) {

            if(current.getNext() == null) {
                return false;
            }

            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        listCount--;

        return true;
    }

    public int size() {
        return listCount;
    }

    public String toStrig() {

        Node current = head.getNext();
        String output = "";
        while (current != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }

        return output;
    }

    private class Node {

        Node next;
        Object data;

        //Creating new node and pointing nowhere
        public Node(Object _data) {
            next = null;
            data = _data;
        }

        //Creating new node and point to another node
        public Node(Object _data, Node _next) {
            next = _next;
            data = _data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object _data) {
             data = _data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node _next) {
            next = _next;
        }
    }

}
