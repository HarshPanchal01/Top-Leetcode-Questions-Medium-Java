import java.util.*;

public class Letter_Combinations_Phone_Number {
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>(); // creating the hashmap
        // puting the digits with the letters they map to
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        // if string is empty
        if (digits.length() == 0) {
            List<String> empty = new ArrayList<>();

            return empty;
        }
        // if only one digit is given and its a digit that maps to 3 letters
        if (digits.length() == 1 && map.get(digits.charAt(0)).length() < 4) {
            List<String> letter = new ArrayList<>();
            letter.add(Character.toString(map.get(digits.charAt(0)).charAt(0)));
            letter.add(Character.toString(map.get(digits.charAt(0)).charAt(1)));
            letter.add(Character.toString(map.get(digits.charAt(0)).charAt(2)));
            
            return letter;
        }
        // if only one digit is given and its a digit that maps to 4 letters
        if (digits.length() == 1 && map.get(digits.charAt(0)).length() == 4) {
            List<String> letter = new ArrayList<>();
            letter.add(Character.toString(map.get(digits.charAt(0)).charAt(0)));
            letter.add(Character.toString(map.get(digits.charAt(0)).charAt(1)));
            letter.add(Character.toString(map.get(digits.charAt(0)).charAt(2)));
            letter.add(Character.toString(map.get(digits.charAt(0)).charAt(3)));

            return letter;
        }

        List<String> letters = new ArrayList<>(); // creating the list
        // if two digits are given
        if (digits.length() == 2) {
            for (int i = 0; i < digits.length(); i++) { // loop through the digits string
                if (i == digits.length() - 1) {
                    break;
                }
                for (int j = i + 1; j < digits.length(); j++) { // loop for the digit ahead of i
                    for (int k = 0; k < map.get(digits.charAt(i)).length(); k++) { // loop through the letters mapped to digit i
                        for (int n = 0; n < map.get(digits.charAt(j)).length(); n++) { // loop through the letters mapped to digit j
                            // create the string by adding the char at k of i and n of j
                            String combo = Character.toString(map.get(digits.charAt(i)).charAt(k)) + map.get(digits.charAt(j)).charAt(n);
                            letters.add(combo); // add to the list 
                        }
                    }
                }
            }
            // return the list
            return letters;
        }
        // if three digits are given
        if (digits.length() == 3) {
            for (int i = 0; i < digits.length(); i++) { // loop through the digits string
                if (i == digits.length() - 1) {
                    break;
                }
                for (int j = i + 1; j < digits.length(); j++) { // loop for the digit ahead of i
                    if (j == digits.length() - 1) {
                        break;
                    }
                    for (int h = j + 1; h < digits.length(); h++) { // loop for the digit ahead of j
                        for (int k = 0; k < map.get(digits.charAt(i)).length(); k++) { // loop through the letters mapped to digit i
                            for (int n = 0; n < map.get(digits.charAt(j)).length(); n++) { // loop through the letters mapped to digit j
                                for (int m = 0; m < map.get(digits.charAt(h)).length(); m++) { // loop through the letters mapped to digit h
                                    // create the string by adding the char at k of i and n of j and m of h
                                    String combo = Character.toString(map.get(digits.charAt(i)).charAt(k)) + map.get(digits.charAt(j)).charAt(n) + map.get(digits.charAt(h)).charAt(m);
                                    letters.add(combo); // add to list  
                                }
                            }
                        }
                    }
                }
            }
            // return the list
            return letters;
        }
        // if four digits are given
        if (digits.length() == 4) {
            for (int i = 0; i < digits.length(); i++) { // loop through digits string
                if (i == digits.length() - 1) {
                    break;
                }
                for (int j = i + 1; j < digits.length(); j++) { // loop for the digit ahead of i
                    if (j == digits.length() - 1) {
                        break;
                    }
                    for (int h = j + 1; h < digits.length(); h++) { // loop for the digit ahead of j
                        if (h == digits.length() - 1) {
                            break;
                        }
                        for (int g = h + 1; g < digits.length(); g++) { // loop for the digit ahead of h
                            for (int k = 0; k < map.get(digits.charAt(i)).length(); k++) { // loop through the letters mapped to digit i
                                for (int n = 0; n < map.get(digits.charAt(j)).length(); n++) { // loop through the letters mapped to digit j
                                    for (int m = 0; m < map.get(digits.charAt(h)).length(); m++) { // loop through the letters mapped to digit h
                                        for (int b = 0; b < map.get(digits.charAt(g)).length(); b++) { // loop through the letters mapped to digit g
                                            // create the string by adding the char at k of i and n of j and m of h and b of g
                                            String combo = Character.toString(map.get(digits.charAt(i)).charAt(k)) + map.get(digits.charAt(j)).charAt(n) + map.get(digits.charAt(h)).charAt(m) + map.get(digits.charAt(g)).charAt(b);
                                            letters.add(combo); // add to list
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // return the list
            return letters;
        }
        // return the list
        return letters;
    }
    public static void main(String[] args) {
        String digits = "23";
        String digits2 = "";
        String digits3 = "2";
        String digits4 = "7";
        String digits5 = "234";

        System.out.println(letterCombinations(digits));
        System.out.println(letterCombinations(digits2));
        System.out.println(letterCombinations(digits3));
        System.out.println(letterCombinations(digits4));
        System.out.println(letterCombinations(digits5));
    }
}
