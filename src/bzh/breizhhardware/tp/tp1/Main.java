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

        // Get the values after the -v option
        String[] valueArgs = new String[0];
        // If there are values after the -v option, get them, stopping at the next option if present
        if (vIndex < args.length - 1) {
            int cutIndex = args.length;
            if (sIndex > vIndex) cutIndex = Math.min(cutIndex, sIndex);
            if (oIndex > vIndex) cutIndex = Math.min(cutIndex, oIndex);
            valueArgs = Arrays.copyOfRange(args, vIndex + 1, cutIndex);
        }

        // Transform the argument into an array of strings and display it
        System.out.println(Arrays.toString(args));
        // Transform the array of strings into an array of integers
        int[] values = getIntegerValues(valueArgs);
        System.out.println(Arrays.toString(values));
        // Get the occurrences of each integer in the array (values are between 0 and 9)
        int[] occurences = getOccurrences(values);
        System.out.println(Arrays.toString(occurences));
        // Print the occurrences histogram
        if (orientation.equals("v")) {
            printVerticalHistogram(values, symbol);
        } else {
            printHorizontalHistogram(values, symbol);
        }
    }

    /** Transform an array of strings into an array of integers
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

    /** Get the occurrences of each integer in the array
     * @param values the array of integers
     * @return the occurrences of each integer in the array
     */
    public static int[] getOccurrences(int[] values) {
        // Get the min and max values in the array
        int min = getMinValue(values);
        int max = getMaxValue(values);
        // Create an array to store the occurrences of each integer
        // The size of the array is max - min + 1 to include all values between min and max
        int[] occurences = new int[max - min + 1];
        // Count the occurrences of each integer in the array
        for (int value : values) {
            // Increment the occurrence of the integer (value - min) to map the value to the index of the occurrences array
            occurences[value - min]++;
        }
        return occurences;
    }

    /** Get the minimum value in the array
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

    /** Get the maximum value in the array
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

    /** Print a horizontal histogram of the occurrences of each integer in the array
     * @param values the array of integers
     * @param symbol the symbol to use for the histogram
     */
    public static void printHorizontalHistogram(int[] values, String symbol) {
        // Get the occurrences of the integer in the array
        int[] occurrences = getOccurrences(values);
        // Get the min and max values in the array
        int min = getMinValue(values);
        int max = getMaxValue(values);
        // Try i from min to max (need the +1 to include max)
        for (int i = min; i < max + 1; i++) {
            // Display the integer followed by a space
            System.out.print(i + " ");
            // Print a star for each occurrence
            for (int j = 0; j < occurrences[i - min]; j++) {
                System.out.print(symbol);
            }
            // Print a new line
            System.out.println();
        }
    }

    /** Get the index of an option in the array of arguments
     * @param args the array of arguments
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

    /** Print a vertical histogram of the occurrences of each integer in the array
     * @param values the array of integers
     * @param symbol the symbol to use for the histogram
     */
    public static void printVerticalHistogram(int[] values, String symbol) {
        // Get the occurrences of the integer in the array
        int[] occurrences = getOccurrences(values);
        // Get the min and max values in the array
        int min = getMinValue(values);
        int max = getMaxValue(values);
        // Calculate the width of the largest number for formatting
        int numberWidth = String.valueOf(max).length();
        // Get the maximum occurrence to know the height of the histogram
        int maxOccurrence = 0;
        for (int occurrence : occurrences) {
            maxOccurrence = Math.max(maxOccurrence, occurrence);
        }
        // Print the histogram from top to bottom
        for (int i = maxOccurrence; i > 0; i--) {
            // For each value from min to max
            for (int j = min; j <= max; j++) {
                // If the occurrence of the value is greater than or equal to i, print the symbol
                if (occurrences[j - min] >= i) {
                    // Print the symbol with the correct width
                    System.out.printf("%" + numberWidth + "s ", symbol);
                    // Print the symbol followed by a space (old version)
                    //System.out.print(symbol + " ");
                } else {
                    // Else print a space (old version)
                    //System.out.print("  ");

                    // Print spaces to align with the number width
                    System.out.printf("%" + numberWidth + "s ", " ");
                }
            }
            // Print a new line
            System.out.println();
        }
        // Print the x-axis
        for (int j = min; j <= max; j++) {
            System.out.printf("%" + numberWidth + "d ", j);
        }
        System.out.println();
    }
}
