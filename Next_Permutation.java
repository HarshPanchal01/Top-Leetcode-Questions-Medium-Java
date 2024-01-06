import java.util.Arrays;

public class Next_Permutation {
    public static void nextPermutation(int[] arr) {
        int breakpoint = -1; // set initial breakpoint to -1
        // for loop to find the breakpoint so the first occurence of a number that is less than the next one
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i+1]) {
                breakpoint = i;
                break;
            }
        }
        // if no breakpoints were found that means array is given as decreasing order
        if (breakpoint == -1) {
            reverseArray(arr); // so just reverse the array
            return;
        }
        // find the smallest element to the right of the breakpoint that is greater than the element at the breakpoint and then swap them
        for (int i = arr.length - 1; i > breakpoint; i--) {
            if (arr[i] > arr[breakpoint]) {
                int temp = arr[i];
                arr[i] = arr[breakpoint];
                arr[breakpoint] = temp;
                break;
            }
        }
        // then sort the elements after the breakpoint in increasing order
        reverseRange(arr, breakpoint + 1, arr.length - 1);
    }
    public static void reverseRange(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move indices towards each other
            start++;
            end--;
        }
    }
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
    
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
    
            // Move indices towards the center
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arr2 = {3,2,1};
        int[] arr3 = {1,1,5};

        System.out.println("Original array: " + Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println("Modified array: " + Arrays.toString(arr));

        System.out.println("Original array: " + Arrays.toString(arr2));
        nextPermutation(arr2);
        System.out.println("Modified array: " + Arrays.toString(arr2));

        System.out.println("Original array: " + Arrays.toString(arr3));
        nextPermutation(arr3);
        System.out.println("Modified array: " + Arrays.toString(arr3));
    }
}
