public class Test {
    public static void main(String[] args) {
        // In Java, collection of similar type of data is called an Array.

        // int[] arr = new int[10];
        // double[] arr2 = new double[10];
        // arr[2] = 49;
        // arr[8] = 60;

        // for(int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
        
        // System.out.println(arr);
        // System.out.println(arr2);

        // Find max element
        int[] arr = {-1, 2999, 399, 90, 28};
        int res = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > res) {
                res = i;
            }
        }
        System.out.println(res);


        // Two Dimensional array
        // int[][] arr = new int[3][3];
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}