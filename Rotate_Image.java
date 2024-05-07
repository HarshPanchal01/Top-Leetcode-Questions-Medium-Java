public class Rotate_Image {
    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) { // loop over each element of the matrix and rotate by 90 degrees
            for (int j = 0; j < size; j++) {
                result[j][size-1-i] = matrix[i][j];
            }
        }

        for (int i = 0; i < size; i++) { // loop over each element to copy it back to the original matrix
            for (int j = 0; j < size; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};

        rotate(matrix);
        rotate(matrix2);
    }
}
