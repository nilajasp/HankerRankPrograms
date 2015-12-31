package ProjectEuler.ProjectEuler.SumOfMultipleOf3And5;

import java.util.Scanner;

/**
 * Created by nilajapatankar on 3/16/15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long numberOfTestCases = Long.parseLong(sc.nextLine());
        Long[] answers = new Long[numberOfTestCases.intValue()];
        try {
            for (int i = 0; i < numberOfTestCases; i++) {
                Long number = Long.parseLong(sc.nextLine());
                Long sumOfNumberDivisibleBy3 = FindSummationOfArithmeticProgression(number, 3l);
                Long sumOfNumberDivisibleBy5 = FindSummationOfArithmeticProgression(number, 5l);
                Long sumOfNumberDivisibleBy15 = FindSummationOfArithmeticProgression(number, 15l);
                answers[i] = sumOfNumberDivisibleBy3 + sumOfNumberDivisibleBy5 - sumOfNumberDivisibleBy15;
            }
            for (Long answer : answers) {
                System.out.println(answer);
            }
        }
        catch (Exception e)
        {
            System.out.println("Wrong input");
        }
    }

    private static Long FindSummationOfArithmeticProgression(Long number, Long d) {
        Long count = (number-1)/d;
        Long sum = (count * ((2 * d) + ((count - 1) * d)) / 2);
        return sum;
    }
}