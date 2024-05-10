package info2;
//Peter Brederlow, Ulrike Hunfeld

public class Arrays {

    // ----------------------------------------------------------------
    // Exercise 2 (a)
    // ----------------------------------------------------------------
    public static int[] intRange(final int start, final int end) {
        int count = 0;
        if (end > start) {
            int[] array = new int[end - start + 1];
            for (int i = start; i <= end; i++) {
                array[count] = i;
                count++;
            }
            return array;
        } else {
            int[] array = new int[start - end + 1];
            for (int i = start; i >= end; i--) {
                array[count] = i;
                count++;
            }
            return array;

        }
    }

    // ----------------------------------------------------------------
    // Exercise 2 (b)
    // ----------------------------------------------------------------
    public static int search(final int[] array, final int value) {
        if (array == null || array.length == 0) {
            System.out.println("Array is null or empty! ");
        }
        int i = 0;
        while (i < array.length) {
            if (value == array[i]) {
                return i;
            }
            i++;
        }
        final int NOT_FOUND = -1;
        return NOT_FOUND;
    }

    // ----------------------------------------------------------------
    // Exercise 2 (c)
    // ----------------------------------------------------------------
    public static void mirror(final int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is null or empty! ");
        } else {
            int tmp;
            for (int i = 0; i <= array.length / 2; i++) {
                tmp = array[array.length - 1 - i];
                array[array.length - 1 - i] = array[i];
                array[i] = tmp;
            }
        }
    }


    // ----------------------------------------------------------------
    // Exercise 2 (d)
    // ----------------------------------------------------------------
    public static void rotateLeft(final String[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is null or empty! ");
        } else {
            String tmp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = tmp;
        }
    }

    // ----------------------------------------------------------------
    // Exercise 2 (e)
    // ----------------------------------------------------------------
    public static void rotateRight(final String[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is null or empty! ");
        } else {
            String tmp = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = tmp;
        }
    }

    // ----------------------------------------------------------------
    // Exercise 2 (f)
    // ----------------------------------------------------------------
    public static double euclideanDistance(final double[] vec1, final double[] vec2) {

        if ((vec1 == null) || (vec2 == null)) {
            return Double.NaN;
        }
        double sum = 0.0;
        for (int i = 0; i < vec1.length; i++) {
            sum += Math.pow((vec1[i] - vec2[i]), 2);
        }
        return Math.sqrt(sum);
    }

    // ----------------------------------------------------------------
    // Exercise 2 (g)
    // ----------------------------------------------------------------
    public static double mean(final double[] array) {

        if (array == null || array.length == 0) {
            System.out.println("Array is null or empty! ");
            return -1;
        }
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    // ----------------------------------------------------------------
    // Exercise 2 (h)
    // ----------------------------------------------------------------
    public static double stdDev(final double[] array) {

        if (array == null || array.length == 0) {
            System.out.println("Array is null or empty! ");
            return -1;
        }
        if (array.length == 1) {
            System.out.println("Array has only one entry; no standard deviation! ");
            return 0;
        }
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.pow((array[i] - mean(array)), 2);
        }
        return Math.sqrt(sum / (array.length - 1));
    }

    // ----------------------------------------------------------------
    // Exercise 2 (i)
    // ----------------------------------------------------------------
    public static int[] append(final int[] array, int value) {

        if (array == null) {
            System.out.println("Array is null");
            return new int[]{};
        }
        int[] array2;
        if (array.length == 0) {
            array2 = new int[1];
        } else {
            array2 = new int[array.length + 1];
        }
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        array2[array2.length - 1] = value;
        return array2;
    }

    // ----------------------------------------------------------------
    // Exercise 2 (j)
    // ----------------------------------------------------------------
    public static int[] merge(final int[] array1, int[] array2) {

        if (array1 == null || array2 == null) {
            System.out.println("Array is null!");
            return new int[]{};
        }

        int[] merged = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            merged[i] = array1[i];
        }
        int count = 0;
        for (int i = array1.length; i < merged.length; i++) {
            merged[i] = array2[count];
            count++;
        }

        return merged;
    }

    // ----------------------------------------------------------------
    // Exercise 2 (k)
    // ----------------------------------------------------------------
    public static int[] mergeInterleaved(final int[] array1, int[] array2) {
        int i = 0; // to count up to the length of array1
        int j = 0; // to count up to the length of array2
        int count = 0; // to count up the indices of the merged array
        final int[] merged = new int[array1.length + array2.length];
        while (count < merged.length) {
            if (count % 2 == 0) {
                if (i < array1.length) {
                    merged[count] = array1[i];
                    i++;
                } else {
                    merged[count] = array2[j];
                    j++;
                }
            }
            if (count % 2 != 0) {
                if (j < array2.length) {
                    merged[count] = array2[j];
                    j++;
                } else {
                    merged[count] = array1[i];
                    i++;
                }
            }
            count++;
        }
        return merged;
    }

    // ----------------------------------------------------------------

    public static String DELIMITER = ", ";

    //
    // Helper function for converting int-arrays into strings.
    //
    public static String asString(final int[] array) {
        if (array == null) {
            return "null";
        }

        final StringBuilder out = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                out.append(DELIMITER);
            }
            out.append(String.valueOf(array[i]));
        }
        return out.toString();
    }

    //
    // Helper method for converting double-arrays into strings.
    //
    public static String asString(final double[] array) {
        if (array == null) {
            return "null";
        }

        final StringBuilder out = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                out.append(DELIMITER);
            }
            out.append(String.valueOf(array[i]));
        }
        return out.toString();
    }

    //
    // Helper method for converting double-arrays into strings.
    //
    public static String asString(final String[] array) {
        if (array == null) {
            return "null";
        }

        final StringBuilder out = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                out.append(DELIMITER);
            }
            out.append(String.valueOf(array[i]));
        }
        return out.toString();
    }

    public static void main(String[] args) {

        // ----------------------------------------------------------------
        // Exercise 2 (a)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (a) --------");
            System.out.println();
            System.out.println("int range from 0 to 10");
            System.out.println(asString(intRange(0, 10)));
            System.out.println();
            System.out.println("int range from 12 to 3");
            System.out.println(asString(intRange(12, 3)));
            System.out.println();
            System.out.println("int range from -5 to 5");
            System.out.println(asString(intRange(-5, 5)));
            System.out.println();
            System.out.println("int range from 5 to -5");
            System.out.println(asString(intRange(5, -5)));
            System.out.println();
            //System.out.println(asString(data, ", "));
            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (b)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (b) --------");
            System.out.println();

            final int[] array = {6, 3, 9, 2, 4, 7, 1, -4, 8};
            System.out.println(asString(array));

            final int[] tests = {7, -4, -2, 6, 8, 12};
            for (int i = 0; i < tests.length; i++) {

                final int value = tests[i];
                final int index = search(array, value);

                if (index >= 0) {
                    System.out.println("found " + value + " at " + index);
                } else {
                    System.out.println("value " + value + " not found");
                }
            }
            System.out.println();
        }


        // ----------------------------------------------------------------
        // Exercise 2 (c)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (c) --------");
            System.out.println();
            final int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            System.out.println(asString(array1));
            mirror(array1);
            System.out.println(asString(array1));
            mirror(array1);
            System.out.println(asString(array1));
            System.out.println();
            final int[] array2 = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            System.out.println(asString(array2));
            mirror(array2);
            System.out.println(asString(array2));
            mirror(array2);
            System.out.println(asString(array2));
            System.out.println();

            final int[] array3 = {8};
            System.out.println(asString(array3));
            mirror(array3);
            System.out.println(asString(array3));
            mirror(array3);
            System.out.println(asString(array3));
            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (d)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (d) --------");
            System.out.println();

            final String[] array = {"bar", "idx", "xyz", "uvw", "abc", "dfg", "mau", "foo"};

            System.out.println(asString(array));
            rotateLeft(array);
            System.out.println(asString(array));
            rotateLeft(array);
            System.out.println(asString(array));
            rotateLeft(array);
            System.out.println(asString(array));

            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (e)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (e) --------");
            System.out.println();

            final String[] array = {"bar", "idx", "xyz", "uvw", "abc", "dfg", "mau", "foo"};

            System.out.println(asString(array));
            rotateRight(array);
            System.out.println(asString(array));
            rotateRight(array);
            System.out.println(asString(array));
            rotateRight(array);
            System.out.println(asString(array));

            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (f)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (f) --------");
            System.out.println();

            final double[] vec1 = {0, 0, 0};
            final double[] vec2 = {
                    Math.sqrt(1.0 / 3.0), Math.sqrt(1.0 / 3.0), Math.sqrt(1.0 / 3.0)
            };

            System.out.println(asString(vec1));
            System.out.println(asString(vec2));
            System.out.println("distance " + euclideanDistance(vec1, vec2));
            System.out.println();

            final double[] vec3 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
            final double[] vec4 = {0.1, -2.0, -1.0, -0.6, 1.0, 3.0};

            System.out.println(asString(vec3));
            System.out.println(asString(vec4));
            System.out.println("distance : " + euclideanDistance(vec3, vec4));
            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (g + h)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (g + h) --------");
            System.out.println();

            final double[] array1 = {1.0, 0.9, 0.8, 0.85, 1.1, 1.2, 1.15};

            System.out.println(asString(array1));
            System.out.println("mean   : " + mean(array1));
            System.out.println("stddev : " + stdDev(array1));
            System.out.println();

            final double[] array2 = {5.0};

            System.out.println(asString(array2));
            System.out.println("mean   : " + mean(array2));
            System.out.println("stddev : " + stdDev(array2));
            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (i)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (i) --------");
            System.out.println();

            int[] array = null;

            array = append(array, 10);
            array = append(array, 20);
            array = append(array, 30);
            array = append(array, 40);
            array = append(array, 50);
            array = append(array, 60);
            array = append(array, 70);

            System.out.println(asString(array));

            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (j)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (j) --------");
            System.out.println();

            int[] array1 = null;
            int[] array2 = {1, 2, 3, 4};
            int[] array3 = {10, 20, 30, 40, 50};

            System.out.println(asString(array1));
            System.out.println(asString(array2));
            System.out.println(asString(array3));

            array1 = merge(array1, array2);
            array1 = merge(array2, array3);

            System.out.println(asString(array1));

            array1 = merge(array1, array1);

            System.out.println(asString(array1));

            System.out.println();
        }

        // ----------------------------------------------------------------
        // Exercise 2 (k)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 2 (k) --------");
            System.out.println();

            final int[] array1 = {2, 4, 6, 8, 10, 12};
            final int[] array2 = {100, 200, 300, 400, 500, 600};

            final int[] array3 = mergeInterleaved(array1, array2);

            System.out.println(asString(array1));
            System.out.println(asString(array2));
            System.out.println(asString(array3));

            System.out.println();

            final int[] array4 = {1, 2, 3, 4};
            final int[] array5 = {10, 20, 30, 40, 50, 60};

            final int[] array6 = mergeInterleaved(array4, array5);

            System.out.println(asString(array4));
            System.out.println(asString(array5));
            System.out.println(asString(array6));

            System.out.println();

        }

    }

}
