import java.util.*;

public class Container_With_Most_Water {
    public static int maxArea(int[] height) {
        int length = 0, width = 0, max = 0; // variables for length, width, and max area
        // if array has only one element or none return 0
        if (height.length == 1 || height.length == 0) { 
            return 0;
        } 
        // create variables for the left most and right most element and get their values as left and right
        int leftendpoint = 0, rightendpoint = height.length - 1, left = height[leftendpoint], right = height[rightendpoint];
        // loop to calculate until both the endpoints meet, which would be in the middle
        while (leftendpoint != rightendpoint) {
            length = Math.min(left, right); // length would be min of the left and right values since the water would overflow regardless of the greater height
            width = rightendpoint - leftendpoint; // width would be the rightendpoint - leftendpoint to get the indexes between them
            // if statement to update max area variable
            if (length * width > max) {
                max = length * width;
            }
            // to move on we need to go to the right or left, if the right length value was smaller than go one left, and if left value was smaller go one right
            if (Math.min(left, right) == right) {
                rightendpoint--;
            }
            else {
                leftendpoint++;
            }
            // set the left and right values again
            left = height[leftendpoint];
            right = height[rightendpoint];
        }
        // return the max area
        return max;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};

        System.out.println(maxArea(height));
        System.out.println(maxArea(height2));
    }
}
