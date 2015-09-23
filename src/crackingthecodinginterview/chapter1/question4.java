package crackingthecodinginterview.chapter1;

/**
 * Created by paulberesuita on 8/30/15.
 */
public class question4 {

    public static void main(String[] args) {

        String testString = "M r as";
        String output = uniqueString(testString, 6);
        String sadf = "asdf";

    }

    //My proposed solution - USE THIS
    public static String uniqueString(String input, int length) {

        char[] content = input.toCharArray();

        int spaceCount = 0;

        for(int i = 0; i < length; i++) {

            if(content[i] == ' ') {
                spaceCount++;
            }
        }

        char[] answer = new char[length + spaceCount *2];

        int tempAnswerCounter = 0;

        for(int i=0; i < content.length; i++) {

            if(content[i] == ' ') {
                answer[tempAnswerCounter] = '%';
                answer[tempAnswerCounter + 1] = '2';
                answer[tempAnswerCounter + 2] = '0';
                tempAnswerCounter = tempAnswerCounter + 3;
            } else {
                answer[tempAnswerCounter] = content[i];
                tempAnswerCounter++;
            }
        }

        return new String(answer);
    }

    //Book Solution - line 70 does not make sense
    public static String replaceSpaces(String input, int length) {

        char[] str = input.toCharArray();

        int spaceCount = 0;
        int newLength;
        int i;

        for(i = 0; i < length; i++) {

            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + spaceCount * 2;

//        str[newLength] = '\0';

        for(i = length - 1; i >= 0; i--) {

            if(str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength -3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }

        }

        return new String(str);

    }
}
