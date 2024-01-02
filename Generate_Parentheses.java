import java.util.*;

public class Generate_Parentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>(); // create the list
        // call the recursive function and pass the list, string, int for open and closing parenthesis and the number n
        backtrack(parenthesis, "", 0, 0, n);
        // return the list
        return parenthesis;
    }
    public static void backtrack(List<String> parenthesis, String str, int open, int close, int n) { // backtrack method
        if (str.length() == n * 2) { // the length of each string will always be n times 2 because parenthesis are in pairs
            parenthesis.add(str); // if the string becomes of that length it means theres no other way to make it and to add to the list
            return;
        }
        // if the open value is less than value n, because you have n open parenthesis to use and n close parenthesis to use
        if (open < n) {
            backtrack(parenthesis, str + "(", open + 1, close, n); // recursive call back as you return with the string being added the open parenthesis and increment its count
        }
        // if close is less than open, because you cannot start with an close parenthesis so the close can only be added if it is less than open parenthesis
        if (close < open) {
            backtrack(parenthesis, str + ")", open, close + 1, n); // recursive call back as you return with the string being added the close parenthesis and increment its count
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int n2 = 1;

        System.out.println(generateParenthesis(n));
        System.out.println(generateParenthesis(n2));
    }
}
