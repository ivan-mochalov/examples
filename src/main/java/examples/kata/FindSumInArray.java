package examples.kata;

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
