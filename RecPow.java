import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * RecPow.java
 * This program calculates the power of 2 raised to a given exponent
 * using recursion. It reads the exponent from an input file and writes
 * the result to an output file.
 * Author: Alex Kapajika
 * Version: 1.1
 * Since: 2025-04-29
 */
public final class RecPow {
    /** Constant for the input file. */
    private static final String INPUT_FILE = "input.txt";
    /** Constant for the output file. */
    private static final String OUTPUT_FILE = "output.txt";
    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * Main Method.
     * @param args Unused.
     */
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(new File(INPUT_FILE));
                FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            // Reading file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    writer.write("Empty line.\n");
                } else {
                    try {
                        int number = Integer.parseInt(line);
                        if (number < 0) {
                            writer.write("Negative number.\n");
                        } else {
                            int result = recPow(2, number);
                            writer.write("2^" + number + " = " + result + "\n");
                        }
                    } catch (NumberFormatException e) {
                        writer.write("Invalid number: "
                         + line + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Recursive method to calculate the power of a number.
     *
     * @param exp Exponent
     * @param base Base
     * @return The result of base raised to the power of exp
     */
    public static int recPow(final int base, final int exp) {
        if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return base;
        } else {
            return base * recPow(base, exp - 1);
        }
    }
}
