package crackingthecodinginterview.chapter1;

/**
 * Created by paulberesuita on 8/21/15.
 * Question: Given two strings, write a method to decide if one is a permutation of the other
 */
public class question3 {

    public static void main(String[] args) {

        String testString1 = "hello";
        String testString2 = "l2ohe";

        boolean isSame = permutation(testString1, testString2);
        System.out.println(isSame);

    }

    public static String sort(String s) {

        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    //Solution: sort the two strings first and then compare....we are assuming case sensitivity and the blanks are important
    public static boolean permutation(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

    //My proposed solution; works fine...possible complexity of O(n2)
    public static boolean isPermutation(String inputOne, String inputTwo) {

        boolean isPermutation = true;

        boolean[] char_set1 = new boolean[256];

        if(inputOne.length() != inputTwo.length()) {

            isPermutation = false;

        } else {

            for(int i=0; i < inputOne.length(); i++) {

                int val = inputOne.charAt(i);
                char_set1[val] = true;
            }

            for(int i=0; i < inputTwo.length(); i++) {

                int val = inputTwo.charAt(i);

                if(!char_set1[val]) {
                    isPermutation = false;
                }
            }
        }

        return isPermutation;
    }

}
