package crackingthecodinginterview.chapter2;

import java.util.HashSet;

/**
 * Created by paulberesuita on 9/6/15.
 */
public class question1 {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.add("F");
        ll.add("O");
        ll.add("L");
        ll.add("L");
        ll.add("O");
        ll.add("W");
        ll.add(" ");
        ll.add("U");
        ll.add("P");

//        ll.deleteDups(ll.getHead());
        System.out.println(ll.toStrig());
        System.out.println(ll.nthToLast(ll.getHead(), 2));

    }


    public static class LinkedList {


        public static Node head;
        public static int listCount;

        public LinkedList() {

            head = new Node(null);
            listCount = 0;
        }

        public static void deleteDups(Node n) {

            HashSet<String> set = new HashSet<String>();
            Node previous = null;
            while (n != null) {

                if(set.contains(n.getData())){
                    previous.next = n.next;
                } else {
                    set.add((String)n.getData());
                    previous = n;
                }

                n = n.next;
            }
        }

        //Takes O(1) space and O(n^2) time
        public static void deleteDupsNoBuffer(Node head) {

            if(head == null) {
                return;
            }

            Node current = head;

            while (current != null) {

                Node runner = current;

                while (runner.next != null) {

                    if(runner.next.getData() == current.getData()) {
                        runner.next = runner.next.next;
                    } else {
                        runner = runner.next;
                    }


                }

                current = current.next;
            }
        }

        public static int nthToLast(Node head, int k) {

            if(head == null) {
                return 0;
            }

            int i = nthToLast(head.next, k) + 1 ;

            if(i == k) {
                System.out.println(head.getData());
            }

            return i;
        }

        public static Node nthToLastBetter(Node head, int k) {

            if(k <= 0) {
                return null;
            }

            Node p1 = head;
            Node p2 = head;

            for (int i = 0; i < k-1; i++) {
                if (p2 == null) {
                    return null;
                }
                p2 = p2.next;
            }

            if (p2 == null) {
                return null;
            }

            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;
        }

        public static void add(Object data) {

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

        public Node getHead() {
            return head;
        }

        public static class Node {

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

}
