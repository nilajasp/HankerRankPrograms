package ProjectEuler.ProjectEuler.SumOfEvenFibonacciNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nilajapatankar on 3/17/15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long numberOfTestCases = Long.parseLong(sc.nextLine());
        Long[] numbers = new Long[numberOfTestCases.intValue()];
        try {
            for (int i = 0; i < numberOfTestCases; i++) {
                numbers[i] = Long.parseLong(sc.nextLine());
            }
            Long maxNumber = 0l;
            for (Long number : numbers) {
                if(number > maxNumber)
                    maxNumber = number;
            }
            List<Long> FibonacciSeries = GenerateFibonacciSeries(maxNumber);
            for (int i = 0; i < numberOfTestCases; i++) {
                Long sum = 0l;
                for (Long fibonacciNumber : FibonacciSeries) {
                    if(fibonacciNumber < numbers[i] && fibonacciNumber%2 == 0)
                        sum += fibonacciNumber;
                }
                System.out.println(sum);
            }
        }
        catch (Exception e)
        {
            System.out.println("Wrong input");
        }

    }

    private static List<Long> GenerateFibonacciSeries(Long maxNumber) {
        List<Long> result = new ArrayList<Long>();
        Long previousNumber1 = 1l;
        Long previousNumber2 = 2l;
        Long currentNumber;
        if(previousNumber1 < maxNumber) {
            result.add(previousNumber1);
            if (previousNumber2 < maxNumber) {
                result.add(previousNumber2);
                currentNumber = previousNumber1 + previousNumber2;
                while(currentNumber < maxNumber)
                {
                    result.add(currentNumber);
                    previousNumber1 = previousNumber2;
                    previousNumber2 = currentNumber;
                    currentNumber = previousNumber1 + previousNumber2;
                }
            }
        }
        return result;
    }
}
