package crackingthecodinginterview.chapter1;

/**
 * Created by paulberesuita on 9/1/15.
 */
public class question5 {

    public static void main(String[] args) {

        String testString = "aabcccccaaaaaaa";

        String answer1 = compression(testString);
        String answer2 = compressBad(testString);
        String answer3 = compressBetter(testString);

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

    }

    //My propose solution
    public static String compression(String input) {

        String compressed = "";

        char currentChar = ' ';
        int count = 1;

        for(int i=0; i < input.length(); i++) {

            if(i > 0) {

                if(currentChar == input.charAt(i)) {
                    count++;
                } else {
                    compressed += Character.toString(input.charAt(i-1)) + count;
                    count = 1;
                }
            }

            if(i+1 >= input.length()) {
                compressed += Character.toString(input.charAt(i-1)) + count;
            }

            currentChar = input.charAt(i);

        }

        return compressed;

    }

    //Book Solution 1
    public static String compressBad(String str) {

        String mystr = "";
        char last = str.charAt(0);
        int count = 1;

        for(int i=1; i < str.length(); i++) {

            if(str.charAt(i) == last) {
                count++;
            } else {
                mystr += last + "" + count;
                last = str.charAt(i);
                count = 1;
            }
        }

        return mystr + last + count;
    }

    //Book Solution 2 - Runs in O(n) time and O(n) space
    public static String compressBetter(String str) {

        int size = countCompression(str);

        if(size >= str.length()) {
            return str;
        }

        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;

        for(int i=0; i < str.length(); i++) {

            if(str.charAt(i) == last) {
                count++;
            } else {
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        mystr.append(last);
        mystr.append(count);

        return mystr.toString();
    }

    public static int countCompression(String str) {

        if(str == null || str.isEmpty()) {
            return 0;
        }

        char last = str.charAt(0);
        int size = 0;
        int count = 1;

        for(int i=0; i < str.length(); i++) {

            if(str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }

        return 0;
    }
}
