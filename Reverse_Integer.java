public class Reverse_Integer {
    public static int reverse(int x) {
        int reverse = 0; // create an int to store reverse and one to store last digit
        int pop = 0;

        while (x != 0) { // while loop to keep dividing x by 10 until it is 0
            pop = x % 10; // mod 10 of any number will give its last digit
            x /= 10; // divide x by 10

            if (reverse > Integer.MAX_VALUE/10 || reverse == Integer.MAX_VALUE/10 && pop > 7) { // accounting for number thats greater than Max value for java
                return 0;
            }
            if (reverse < Integer.MIN_VALUE/10 || reverse == Integer.MIN_VALUE/10 && pop < -8) { // accounting for number thats smaller than Min value for java
                return 0;
            }
            reverse = (reverse * 10) + pop; // add digit to reverse
        }

        return reverse;
    }
    public static void main(String[] args) {
        int x = 120;
        System.out.println(reverse(x));
    }
}