package examples.task;

import lombok.NonNull;

public class SortedArrayWithSquaredValues {

    public int[] squareUp(@NonNull int[] values) {
        int[] result = new int[values.length];
        int leftPointer = 0;
        int rightPointer = values.length - 1;

        for (int i = result.length - 1; i >= 0; i--) {
            int leftCurrent = values[leftPointer] * values[leftPointer];
            int rightCurrent = values[rightPointer] * values[rightPointer];

            if (leftCurrent > rightCurrent) {
                result[i] = leftCurrent;
                leftPointer++;
            } else {
                result[i] = rightCurrent;
                rightPointer--;
            }
        }

        return result;
    }
}
