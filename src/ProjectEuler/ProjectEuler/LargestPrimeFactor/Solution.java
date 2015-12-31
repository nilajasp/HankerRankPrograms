package ProjectEuler.ProjectEuler.LargestPrimeFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nilajapatankar on 3/17/15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(sc.nextLine());
        Long[] numbers = new Long[numberOfTestCases];
        try {
            Long maxNumber = 0l;
            for (int i = 0; i < numberOfTestCases; i++) {
                numbers[i] = Long.parseLong(sc.nextLine());
                if(maxNumber < numbers[i])
                    maxNumber = numbers[i];
            }

            List<Long> primeNumbers = GeneratePrimeNumbers(maxNumber);

            for (int i = 0; i < numberOfTestCases; i++) {
                Long maxPrimeNumber = 0l;
                if (IsPrime(numbers[i]))
                    maxPrimeNumber = numbers[i];
                else {
                    for (Long primeNumber : primeNumbers) {
                        if (maxPrimeNumber < primeNumber && numbers[i] % primeNumber == 0) {
                            maxPrimeNumber = primeNumber;
                            while (numbers[i] % primeNumber == 0)
                                numbers[i] /= primeNumber;
                        }
                    }
                }
                if (maxPrimeNumber < numbers[i] && IsPrime(numbers[i]))
                    maxPrimeNumber = numbers[i];
                System.out.println(maxPrimeNumber);
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
    }

    private static boolean IsPrime(Long number) {
        for (Long i = 2l; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static List<Long> GeneratePrimeNumbers(Long number) {
        List<Long> primeNumbers = new ArrayList<Long>();
        Long maxPrimeNumber = ((Double) Math.sqrt(number.doubleValue())).longValue();
        for (Long i = 2l; i <= maxPrimeNumber; i++) {
            if (IsPrime(i)) {
                primeNumbers.add(i);
//                while (number % i == 0) {
//                    number = number / i;
//                    maxPrimeNumber = ((Double) Math.sqrt(number.doubleValue())).longValue();
//                }
            }
        }
        return primeNumbers;
    }
}
