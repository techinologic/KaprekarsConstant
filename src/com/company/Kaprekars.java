package com.company;

import java.util.Arrays;

/**
 * Class Containing all the methods required to
 * count the routines to reach kaprekars value
 * based on user input.
 */

public class Kaprekars {

    final int NUMDIGITS = 4;
    final int KAPREKARS = 6174;

    private int input;
    private int result = 0;
    private int count;

    private int[] unsorted = new int[NUMDIGITS];
    private int[] ascending = new int[NUMDIGITS];

    private int[] descending = new int[NUMDIGITS];

    private int descendingInt = 0;
    private int ascendingInt = 0;


    /**
     * Method that will store user input digit by digit
     * into an array (unsorted)
     * @param input
     */
    public void storeToArray(int input) {
        setInput(input);

        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = input % 10;
            input = input / 10;
        }
    }

    /**
     * Method to copy the unsorted array to ascending array
     * then sort them by ascending order.
     * @param input
     */
    public void sortAscending(int[] input) {
        for (int i = 0; i < input.length; i++) {
            ascending[i] = input[i];
        }
        Arrays.sort(ascending);
    }

    /**
     * Method that will copy the unsorted array to descending
     * array then sort it by descending order
     * @param input
     */
    public void sortDescending(int[] input) {
        int counter = NUMDIGITS - 1;
        int index = 0;
        while (index < unsorted.length) {
            descending[index] = ascending[counter];
            index++;
            counter--;
        }
    }

    /**
     * Method that will convert the ascending array into
     * integer
     * @param ascending
     */
    public void convertAscendingToInteger(int[] ascending) {
        StringBuilder strAscending = new StringBuilder();

        for (int num : ascending) {
            strAscending.append(num);
        }
        setAscendingInt(Integer.parseInt(strAscending.toString()));
    }

    /**
     * Method that will convert the descending array
     * into integer.
     * @param descending
     */
    public void convertDescendingToInteger(int[] descending) {
        StringBuilder strDescending = new StringBuilder();

        for (int num : descending) {
            strDescending.append(num);
        }
        setDescendingInt(Integer.parseInt(strDescending.toString()));
    }

    /**
     * Method that will count the number of routines/steps
     * to reach the kaprekars value.
     * @return
     */
    public int countNumRoutines() {

        while ((getResult() != KAPREKARS) || (getResult() < 0)) {
            sortAscending(getUnsorted());
            sortDescending(getUnsorted());

            convertAscendingToInteger(getAscending());
            convertDescendingToInteger(getDescending());

            setResult(getDescendingInt() - getAscendingInt());

            storeToArray(result);

            count++;
        }
        return count;
    }

    /**
     * Getters and Setters.
     * @return
     */
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getDescendingInt() {
        return descendingInt;
    }

    public void setDescendingInt(int descendingInt) {
        this.descendingInt = descendingInt;
    }

    public int getAscendingInt() {
        return ascendingInt;
    }

    public void setAscendingInt(int ascendingInt) {
        this.ascendingInt = ascendingInt;
    }

    public int[] getUnsorted() {
        return unsorted;
    }

    public int[] getAscending() {
        return ascending;
    }

    public int[] getDescending() {
        return descending;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }


}
