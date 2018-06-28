import java.util.Scanner;

/**
 * Write a program that asks the user to enter a number (integer).
 * The program should then convert the number into it's US English word representation.
 * Range from 0 to 99999.
 *
 * For example, if “1234” is given as input, output should be “one thousand two hundred thirty four”.
 */
class NumberToWord {

//Variable(s)-
    //Unit digits array.
    private static final String unit_digits[] = { "Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    //Tens multiple array.
    private static final String tens_multiple[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};


//Private Method(s)-
    /**
     * Method that mathematically converts a number into it's US English word representation.
     *
     * @param number to convert to word.
     * @return the US English word representation.
     */
    private static String convertToWord(int number) {

        if (number < 0 || number > 99999) { return "Valid Rang is from 0 to 99999"; }

        StringBuilder word = new StringBuilder();

        if (number == 0) { word.append(unit_digits[number]); }

        if ((number / 1000) > 0) {

            if ((number / 1000) < 20) {

                word.append(unit_digits[number / 1000]).append(" Thousand ");
                number %= 1000;
            } else {

                word.append(tens_multiple[number / 10000]);
                number %= 10000;

                if ((number / 1000) > 0){

                    word.append("-").append(unit_digits[number / 1000]);
                    number %= 1000;
                }
                word.append(" Thousand ");
            }
        }

        if ((number / 100) > 0) {

            word.append(unit_digits[number / 100]).append(" Hundred ");
            number %= 100;
        }

        if (number > 0) {

            if (number < 20) {

                word.append(unit_digits[number]);
            } else {

                word.append(tens_multiple[number / 10]);

                if ((number % 10) > 0) { word.append("-").append(unit_digits[number % 10]); }
            }
        }
        return word.toString();
    }

    /**
     * Helper print method.
     *
     * @param number to print.
     */
    private static void print(int number) {

        System.out.printf("%nEntered Integer: %d%n",number);
        System.out.printf("US English Word Representation: %s%n", convertToWord(number));
    }


//Package Private Method(s)-
    /**
     * Test's user input.
     */
    static void inputProcessor() {

        Scanner cin = new Scanner(System.in);
        boolean isInt = false;
        int temp = -1;

        System.out.print("\nEntered integer will be converted into its US English word representation: ");

        do {
            try {

                temp = Integer.parseInt(cin.next().trim());
                isInt = true;

                if (temp < 0 || temp > 99999) {

                    System.out.print("Valid Rang is from 0 to 99999, try again: ");
                    isInt = false;
                }
            } catch (NumberFormatException | NullPointerException e) {

                System.out.print("Did not enter an integer, try again: ");
            }
        } while (!isInt);
        print(temp);
    }

}//End of Class.
