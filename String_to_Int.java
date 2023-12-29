import java.util.ArrayList;

public class String_to_Int {
    public static int myAtoi(String s) {
        int i = 0, sign = 1, total = 0; // variables for index, sign of number, and total number
        // if string is empty
        if (s.length() == 0) {
            return 0;
        }
        // while condition to get rid of leading spaces
        while (s.charAt(i) == ' ' && i < s.length()) {
            i++;
        }
        // if the index is already the last element and only a ' '
        if (i == s.length()) {
            return 0;
        }
        // if condition to make sign positive or negative based on the sign given
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            }
            else {
                sign = -1;
                i++;
            }
        }
        // loop to iterate through rest of string
        while (i < s.length()) {
            int digit = s.charAt(i) - '0'; // this converts the current character into int by subtracting the unicode value of '0'
            // if statement to see if the extracted digit is in range from 0-9
            if (digit < 0 || digit > 9) {
                break;
            }
            // this checks for potential overflow that would occur by adding the current digit to the total if so returns the max value if sign is positive or min value if sign is negative
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE % 10 < digit) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            // if no overflow add to total and go to next index
            total = 10 * total + digit;
            i++;
        }
        // returns the total with the current sign
        return total * sign;
    }
    public static void main(String[] args) {
        String s = "42";
        String s2 = "      -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";

        System.out.println(myAtoi(s));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
    }
}
