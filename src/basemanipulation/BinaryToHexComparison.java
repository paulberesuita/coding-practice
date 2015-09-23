package basemanipulation;

public class BinaryToHexComparison {

    public static void main(String[] args) {

        System.out.println("Hello Base!");

        boolean isSame = compareBinToHex("123", "10");

    }

    public static boolean compareBinToHex(String binary, String hex) {

        int n1 = convertToBase(binary, 8);
        int n2 = convertToBase(hex, 16);

        if(n1 < 0 || n2 < 0) {
            return false;
        } else {
            return n1 == n2;
        }

    }
    /**
     * Note: We can compare characters because they are primitives (each char has a value representation, for example 'A' = 65 or '1' = 49)
     * @param c character input
     * @return number (base) representation of char input
     */
    public static int digitToValue(char c, int base) {

        switch (base) {
            case 2:
                return c - '0';
            case 8:
                if(c >='0' && c <= '7') {
                    return c - '0';
                } else if(c >= '8') {
                    return 10 + c - '8';
                } else {
                    return -1;
                }
            case 16:
                if(c >='0' && c <= '9') {
                    return c - '0';
                } else if(c >= 'A' && c <= 'F') {
                    return 10 + c - 'A';
                } else if (c >= 'a' && c < -'f') {
                    return 10 + c - 'a';
                } else {
                    return -1;
                }
            default: base = 10;
                return c;

        }
    }

    public static int convertToBase(String number, int base) {

        if(base < 2 || (base > 10 && base !=16)) {
            return -1;
        }

        int value = 0;

        for(int i= number.length() -1; i>=0; i--) {

            int digit = digitToValue(number.charAt(i), base);

            if(digit < 0) {
                return -1;
            }

            int exp = number.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }

        return value;

    }

}
