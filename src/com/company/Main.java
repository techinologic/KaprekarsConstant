/**
 * Paolo T. Inocencion
 *
 * Coppin CS Coding Challenge Fall 2018 #3
 *
 * Using the Java language, have the function
 * KaprekarsConstant(num) take the num parameter
 * being passed which will be a 4-digit number with
 * at least two distinct digits. Your program should
 * perform the following routine on the number:
 * Arrange the digits in descending order and in
 * ascending order (adding zeroes to fit it to
 * a 4-digit number), and subtract the smaller
 * number from the bigger number. Then repeat
 * the previous step. Performing this routine
 * will always cause you to reach a fixed number:
 * 6174. Then performing the routine on 6174
 * will always give you 6174 (7641 – 1467 = 6174).
 *
 * Your program should return the number of
 * times this routine must be performed until
 * 6174 is reached. For example: if num is 3524
 * your program should return 3 because of
 * the following steps: (1) 5432 – 2345 = 3087,
 * (2) 8730 – 0378 = 8352, (3) 8532 – 2358 = 6174.
 */

package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int input;

        Scanner sc = new Scanner(System.in);
        Kaprekars kaprekars = new Kaprekars();

        System.out.print("Enter 4-digit number: ");

        try {
            input = sc.nextInt();

            // restrict user from entering more than 4 digits
            if (String.valueOf(input).length() > 4) {
                throw new IllegalArgumentException("Enter positive 4 digits only please");
            }

            // store user input into array for processing
            kaprekars.storeToArray(input);

            System.out.println("Input: " + kaprekars.getInput());
            System.out.println("Output: " + kaprekars.countNumRoutines());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException ex) {
            System.out.println("Enter positive integers only.");
        }
    }
}
