package examples.task;

public class FindSubArrayMaxSum {

    public static int findSubArrayMaxSum(int[] values) {
        int maxSum = Math.min(values[0], 0);
        int currentSum;

        for (int value : values) {
            currentSum = Math.max(value, maxSum + value);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
