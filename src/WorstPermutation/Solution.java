package WorstPermutation;

import java.util.Scanner;

/**
 * Created by nilajapatankar on 3/11/15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        String[] inputArray1 = input1.split(" ");
        String[] inputArray2 = input2.split(" ");

        int countOfNumbers = Integer.parseInt(inputArray1[0]);
        int maxCountOfSwaps = Integer.parseInt(inputArray1[1]);

        int[] numbers = new int[countOfNumbers];

        for (int i = 0; i < countOfNumbers; i++) {
            if (inputArray2.length > i)
                numbers[i] = Integer.parseInt(inputArray2[i]);
        }

        int swapCount = 0;

        for (int j = 0; j < countOfNumbers; j++) {
            int maxPosition = j;
            for (int k = j+1; k < countOfNumbers; k++) {
                    if (numbers[j] < numbers[k] && numbers[maxPosition] < numbers[k])
                        maxPosition = k;
            }
            if(maxPosition != j) {
                int tmp = new Integer(numbers[j]);
                numbers[j] = new Integer(numbers[maxPosition]);
                numbers[maxPosition] = tmp;
                swapCount++;
            }
            if (swapCount >= maxCountOfSwaps)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
