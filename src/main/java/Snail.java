public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null) {
            return new int[0];
        }

        if (!isPerfectSquare(array2d)) {
            return new int[0];
        }
        int n = array2d.length;
        int[] finalArray = new int[n * n];
        int in = 0;
        int x = 0;
        int y = n - 1;
        int z = 0;
        int a = n - 1;

        while (x <= y && z <= a) {
            if (x < y) {
                for (int i = z; i <= a; i++) {
                    finalArray[in++] = array2d[x][i];
                }
                x++;
            }

            for (int i = x; i <= y; i++) {
                finalArray[in++] = array2d[i][a];
            }
            a--;

            if (x <= y) {
                for (int i = a; i >= z; i--) {
                    finalArray[in++] = array2d[y][i];
                }
                y--;
            }

            if (z <= a) {
                for (int i = y; i >= x; i--) {
                    finalArray[in++] = array2d[i][z];
                }
                z++;
            }
        }

        return finalArray;
    }


    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null) {
            return new int[0][0];
        }
        if (!isPerfectSquare(array1d)) {
            return new int[0][0];
        }

        int n = (int) Math.sqrt(array1d.length);
        int[][] finalArray = new int[n][n];

        int x = 0;
        int y = n - 1;
        int z = 0;
        int a = n - 1;
        int in = 0;

        while (x <= y && z <= a) {

            if (x <= y) {
                for (int i = z; i <= a; i++) {
                    finalArray[x][i] = array1d[in++];
                }
                x++;
            }

            for (int i = x; i <= y; i++) {
                finalArray[i][a] = array1d[in++];
            }
            a--;

            if (y >= x) {
                for (int i = a; i >= z; i--) {
                    finalArray[y][i] = array1d[in++];
                }
                y--;
            }

            for (int i = y; i >= x; i--) {
                finalArray[i][z] = array1d[in++];
            }
            z++;
        }

        return finalArray;

    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int num : array1d)
        {
            System.out.println(num);
        }

    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] numbers : array2d)
        {
            for (int num : numbers)
            {
                System.out.println(num);
            }
        }

    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        return Math.sqrt(length) == Math.floor(Math.sqrt(length));
    }



    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        return (array2d.length == array2d[0].length);
    }
}
