package sandbox;

/**
 * Created by paulberesuita on 8/31/15.
 */
public class LinkedList {

    Node head;
    int listCount;

    public LinkedList() {

        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data) {

        Node newNode = new Node(data);

        Node current = head;

        while(current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(current);
        listCount++;
    }

    public void add(Object data, int index) {

        Node newNode = new Node(data);
        Node current = head;

        int temp = 0;

        while(temp < index && current.getNext()!= null) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);

        listCount++;
    }

    public void remove() {

        Node current = head;

        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }

        current.setNext(null);
    }

    private class Node {

        Node next;
        Object data;

        public Node(Object _data){
            data = _data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node _next) {
            next = _next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object _data) {
            data = _data;
        }

    }
}
