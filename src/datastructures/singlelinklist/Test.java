package datastructures.singlelinklist;

/**
 * Created by paulberesuita on 8/21/15.
 */
public class Test {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.add("7");
        ll.add("8");

        ll.add("6", 5);

//        ll.remove(1);

        System.out.println(ll.toStrig());

    }

}
