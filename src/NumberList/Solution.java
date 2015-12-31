package NumberList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nilajapatankar on 3/11/15.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long numberOfTestCases = Long.parseLong(sc.nextLine());
        Long[] answers = new Long[numberOfTestCases.intValue()];
        try {
            for (int i = 0; i < numberOfTestCases; i++) {
                String line1 = sc.nextLine();
                String[] inputArray1 = line1.split(" ");
                Long countOfNumber = Long.parseLong(inputArray1[0]);
                Long minNumber = Long.parseLong(inputArray1[1]);
                String line2 = sc.nextLine();
                String[] inputArray2 = line2.split(" ");

                List<Long> numbers = new ArrayList<Long>();

                for (int j = 0; j < countOfNumber; j++) {
                    if (inputArray2.length > j)
                        numbers.add(Long.parseLong(inputArray2[j]));
                }

                List<Long> largerNumbers = new ArrayList<Long>();
                for (Long number : numbers)
                    if (number > minNumber)
                        largerNumbers.add(number);

                int numbersLength = numbers.size();
                Long arrayWithLargerNumberCount = 0l;
                for (int c = 0; c < numbersLength; c++) {
                    for (int d = 1; d <= numbersLength - c; d++) {
                        List<Long> subList = numbers.subList(c, c + d);
                        for (Long largerNumber : largerNumbers) {
                            if (subList.contains(largerNumber)) {
                                arrayWithLargerNumberCount++;
                                break;
                            }
                        }
                    }
                }
                answers[i] = arrayWithLargerNumberCount;
            }

            for (Long answer : answers) {
                System.out.println(answer);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error parsing input");
        }
    }
}
