package datastructures.stack;

/**
 * Created by paulberesuita on 9/7/15.
 */
public class StackLinkedList {


    Node top;

    public Object pop() {

        if(top != null) {
            Object item = top.getData();
            top = top.next;
            return item;
        }
        return null;

    }

    public void push(Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    public Object peek() {
        return top.getData();
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
