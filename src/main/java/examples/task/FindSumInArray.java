/*
 * Дано число 'x' и массив чисел. Определить если ли в массиве два числа,
 * сумма которых равняется 'x'. Если да, то вернуть позиции этих чисел в массиве.
 * Пример:
 *   - 9, [2, 7, 15, 9] -> [0, 1]
 *   - 19, [1, 4, 5, 7, 11, 15, 8] -> [1, 5]
 */
package examples.task;

import java.util.HashMap;
import java.util.Map;

public class FindSumInArray {

    private static final String NO_COMBINATIONS_ERROR_MESSAGE = "There is no any possible combinations";

    public int[] findNumbersPosition(int value, int[] array) {
        Map<Integer, Integer> positionByValue = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int temp = value - array[i];

            if (temp > 0) {
                if (positionByValue.get(temp) != null) {
                    return new int[]{positionByValue.get(temp), i};
                } else {
                    positionByValue.put(array[i], i);
                }
            }
        }

        throw new IllegalStateException(NO_COMBINATIONS_ERROR_MESSAGE);
    }
}
