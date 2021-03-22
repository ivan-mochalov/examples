package examples.task;

import java.util.HashMap;
import java.util.Map;

public class DuplicatedValue {

    private static final String NO_DUPLICATES_ERROR_MESSAGE = "There is no any duplicates!";

    public int findDuplicatedValue(int[] intSequence) {
        Map<Integer, Integer> positionByValue = new HashMap<>();
        Integer position = null;

        for (int i = 0; i < intSequence.length && position == null; i++) {
            position = positionByValue.put(intSequence[i], i);
        }

        if (position != null) {
            return intSequence[position];
        } else {
            throw new IllegalArgumentException(NO_DUPLICATES_ERROR_MESSAGE);
        }
    }
}
