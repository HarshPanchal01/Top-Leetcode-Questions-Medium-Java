import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) { 
        // Map to store sorted strings as keys and corresponding anagrams as values
        Map<String, List<String>> map = new HashMap<>();
        // Iterate over each string in the array
        for (String str : strs) {
            // Convert string to char array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // Check if the sorted string is already in the map
            if (!map.containsKey(sortedStr)) {
                // If not, add a new entry with the sorted string as key and a new list as value
                map.put(sortedStr, new ArrayList<>());
            }
            // Add the original string to the list of anagrams for the sorted string
            map.get(sortedStr).add(str);
        }
        // Return the values of the map as the result
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));
    }
}
