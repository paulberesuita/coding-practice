package crackingthecodinginterview.chapter1;

import java.util.Hashtable;

/**
 * Created by paulberesuita on 8/21/15.
 *
 * Question: Implement an Algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures
 */
public class question1 {

    public static void main(String[] args) {

        String testString = "hello";

        System.out.println(isUniqueChars2(testString));

    }

    //My proposed solution; needs work
    public static boolean uniqueString(String input) {

        boolean stringUnique = true;

        Hashtable hashTable = new Hashtable();

        for(int i=0; i < input.length(); i ++) {

            if(hashTable.get(input.charAt(i)).equals(input.charAt(i))) {
                stringUnique = false;
                break;
            }
            hashTable.put(input.charAt(i), i);
        }

        return  stringUnique;
    }

    public static boolean isUniqueChars2(String str) {

        //Assuming we are using ASCII (128 unique characters) then going above in the string assures that the string is not unique
        if(str.length() > 128 ) {
            return false;
        }

        boolean[] char_set = new boolean[256];

        for (int i=0; i < str.length(); i++) {

            int val = str.charAt(i);

            if(char_set[val]) {
                return false;
            }

            char_set[val] = true;
        }

        return true;
    }

}
