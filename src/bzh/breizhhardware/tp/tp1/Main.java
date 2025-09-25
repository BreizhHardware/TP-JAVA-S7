package bzh.breizhhardware.tp.tp1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Check if the -v option is present and get its index
        int vIndex = getOptionIndex(args, "-v");
        if (vIndex == -1 || vIndex == args.length - 1) {
            // If not present or no value after it, print an error message and exit
            System.err.println("Error: Missing -v option or value");
            System.exit(1);
        }

        // Check if the -s option is present and get its index
        int sIndex = getOptionIndex(args, "-s");
        // Get the symbol to use for the histogram (default is "*")
        String symbol = "*";
        // If the -s option is present and has a value after it, get the symbol
        if (sIndex != -1 && sIndex < args.length - 1) {
            symbol = args[sIndex + 1];
        }

        int oIndex = getOptionIndex(args, "-o");
        String orientation = "h";
        if (oIndex != -1 && oIndex < args.length - 1) {
            orientation = args[oIndex + 1];
        }

        // Check if the -sort option is present and get its index
        int sortIndex = getOptionIndex(args, "-sort");
        // Get the sort order (default is "null" for no sorting)
        String sortOrder = "null";
        // If the -sort option is present and has a value after it, get the sort order
        if (sortIndex != -1 && sortIndex < args.length - 1) {
            sortOrder = args[sortIndex + 1];
        }

        // Get the values after the -v option
        String[] valueArgs = new String[0];
        // If there are values after the -v option, get them, stopping at the next option if present
        if (vIndex < args.length - 1) {
            // By default the cut index is the end of the array
            int cutIndex = args.length;
            // If the -s option is present and after the -v option, cut the values at the -s option
            if (sIndex > vIndex) cutIndex = Math.min(cutIndex, sIndex);
            // If the -o option is present and after the -v option, cut the values at the -o option
            if (oIndex > vIndex) cutIndex = Math.min(cutIndex, oIndex);
            // If the -sort option is present and after the -v option, cut the values at the -sort option
            if (sortIndex > vIndex) cutIndex = Math.min(cutIndex, sortIndex);
            // Copy the values from the args array to the valueArgs array, from vIndex + 1 to cutIndex (to exclude the -v option itself and the next option if present)
            valueArgs = Arrays.copyOfRange(args, vIndex + 1, cutIndex);
        }

        // Transform the argument into an array of strings and display it
        System.out.println(Arrays.toString(args));
        // Transform the array of strings into an array of integers
        int[] values = getIntegerValues(valueArgs);
        System.out.println(Arrays.toString(values));
        // Get the occurrences of each integer in the array (values are between 0 and 9)
        int[][] occurences = getOccurrences(values, sortOrder);
        System.out.println(Arrays.deepToString(occurences));
        // Print the occurrences histogram
        if (orientation.equals("v")) {
            printVerticalHistogram(values, symbol, sortOrder);
        } else {
            printHorizontalHistogram(values, symbol, sortOrder);
        }
    }

    /**
     * Transform an array of strings into an array of integers
     *
     * @param args the array of strings
     * @return the array of integers
     */
    public static int[] getIntegerValues(String[] args) {
        int[] intValues = new int[args.length];
        // Transform each string into an integer
        for (int i = 0; i < args.length; i++) {
            intValues[i] = Integer.parseInt(args[i]);
        }
        return intValues;
    }

    /**
     * Get the occurrences of each integer in the array
     *
     * @param values    the array of integers
     * @param sortOrder the sort order ("asc" for ascending, "desc" for descending, "null" for no sorting)
     * @return a 2D array containing the integer values and their occurrences
     */
    public static int[][] getOccurrences(int[] values, String sortOrder) {
        // Get the min and max values in the array
        int min = getMinValue(values);
        int max = getMaxValue(values);
        // Create an array to store the occurrences of each integer
        int[] counts = new int[max - min + 1];
        // Create an array to store the integer values
        int[] vals = new int[max - min + 1];

        // Initialize the counts and vals arrays
        for (int i = 0; i < vals.length; i++) vals[i] = i + min;
        for (int v : values) counts[v - min]++;

        // Sort the counts and vals arrays based on the counts array and the sort order
        for (int i = 0; i < counts.length - 1; i++) {
            // Compare the current count with the next counts
            for (int j = i + 1; j < counts.length; j++) {
                // If the current count is greater than the next count (for ascending order) or less than (for descending order), swap them
                boolean swap = sortOrder.equals("asc") ? counts[i] > counts[j] : counts[i] < counts[j];
                if (swap) {
                    int tmpC = counts[i];
                    counts[i] = counts[j];
                    counts[j] = tmpC;
                    int tmpV = vals[i];
                    vals[i] = vals[j];
                    vals[j] = tmpV;
                }
            }
        }
        return new int[][]{vals, counts};
    }

    /**
     * Get the minimum value in the array
     *
     * @param values the array of integers
     * @return the minimum value in the array
     */
    public static int getMinValue(int[] values) {
        // Initialize min to the maximum integer value
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            // Update min if the current value is less than min
            min = Math.min(min, value);
        }
        return min;
    }

    /**
     * Get the maximum value in the array
     *
     * @param values the array of integers
     * @return the maximum value in the array
     */
    public static int getMaxValue(int[] values) {
        // Initialize max to the minimum integer value
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            // Update max if the current value is greater than max
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * Print a horizontal histogram of the occurrences of each integer in the array
     *
     * @param values    the array of integers
     * @param symbol    the symbol to use for the histogram
     * @param sortOrder the sort order ("asc" for ascending, "desc" for descending, "null" for no sorting)
     */
    public static void printHorizontalHistogram(int[] values, String symbol, String sortOrder) {
        // Get the occurrences of each integer in the array
        int[][] occurrences = getOccurrences(values, sortOrder);
        // Separate the occurrences into two arrays: one for the integer values and one for their counts
        int[] vals = occurrences[0];
        int[] counts = occurrences[1];
        // Print the histogram
        for (int i = 0; i < vals.length; i++) {
            // Print the integer value followed by its occurrences represented by the symbol
            System.out.print(vals[i] + " ");
            for (int j = 0; j < counts[i]; j++) {
                System.out.print(symbol + " ");
            }
            // Calculate the percentage of occurrences
            int percent = (int) ((counts[i] / (double) values.length) * 100);
            // Print the percentage at the end of the line
            System.out.print("(" + percent + " %)");
            // Move to the next line after printing each value and its occurrences
            System.out.println();
        }
    }

    /**
     * Get the index of an option in the array of arguments
     *
     * @param args   the array of arguments
     * @param option the option to search for
     * @return the index of the option in the array, or -1 if not found
     */
    public static int getOptionIndex(String[] args, String option) {
        // Search for the option in the array
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(option)) {
                // If found, return the index
                return i;
            }
        }
        // If not found, return -1
        return -1;
    }

    /**
     * Print a vertical histogram of the occurrences of each integer in the array
     *
     * @param values    the array of integers
     * @param symbol    the symbol to use for the histogram
     * @param sortOrder the sort order ("asc" for ascending, "desc" for descending, "null" for no sorting)
     */
    public static void printVerticalHistogram(int[] values, String symbol, String sortOrder) {
        // Get the occurrences of each integer in the array
        int[][] occurrences = getOccurrences(values, sortOrder);
        // Separate the occurrences into two arrays: one for the integer values and one for their counts
        int[] vals = occurrences[0];
        int[] counts = occurrences[1];

        // Find the maximum occurrence count
        int maxOccurrence = 0;
        for (int count : counts) {
            if (count > maxOccurrence) maxOccurrence = count;
        }

        // Determine the width needed for formatting
        int numberWidth = Arrays.stream(vals)
                .mapToObj(String::valueOf)
                .mapToInt(String::length)
                .max()
                .orElse(1);
        // Also consider the symbol width
        int symbolWidth = symbol.length();
        // The maximum width needed for formatting
        int maxWidth = Math.max(numberWidth, symbolWidth);

        // Print the histogram from top to bottom
        for (int i = maxOccurrence; i > 0; i--) {
            // Print each level of the histogram
            for (int j = 0; j < vals.length; j++) {
                // If the count for this value is greater than or equal to the current level, print the symbol
                if (counts[j] >= i) {
                    // Use formatted printing to align the symbols
                    System.out.printf("%" + maxWidth + "s ", symbol);
                } else {
                    // Otherwise, print spaces to maintain alignment
                    System.out.printf("%" + maxWidth + "s ", " ");
                }
            }
            // Move to the next line after printing each level
            System.out.println();
        }
        // Print the integer values at the bottom
        for (int val : vals) {
            System.out.printf("%" + maxWidth + "d ", val);
        }
        System.out.println();
    }
}
