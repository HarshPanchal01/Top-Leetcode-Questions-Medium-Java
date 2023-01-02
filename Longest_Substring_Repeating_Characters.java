import java.util.HashSet;

public class Longest_Substring_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0, temp = 0; // counters
        HashSet<Character> ch = new HashSet<>(); // create hashset

        for (int i = 0; i < s.length(); i++) { // go through string
            if (!ch.contains(s.charAt(i))) { // if set does not already contain that char then add it
                ch.add(s.charAt(i));
            }
            temp = ch.size(); // temporary size storage
            if (i != s.length() - 1) { // if its not the last character in the string
                for (int j = i + 1; j < s.length(); j++) { // run another loop
                    if (!ch.contains(s.charAt(j))) { // if set does not contain then add it
                        ch.add(s.charAt(j));
                    }
                    else { // otherwise that substring is done grab the size of it then clear the set and break this inside loop
                        temp = ch.size();
                        ch.clear();
                        break;
                    }
                }
            }
            if (count < temp) { // if count is less than temporary value that becomes new count
                count = temp;
            } 
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
