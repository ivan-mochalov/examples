package examples.kata;

public class StringZipper {

    public static String zipString(String input) {
        validateInput(input);

        if (input.length() == 1) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        Character current = null;
        int count = 1;

        for(char c : input.toCharArray()) {
            if (current == null) {
                current = c;
            } else if (current == c) {
                count++;
            } else {
                result.append(current);
                current = c;

                if (count > 1) {
                    result.append(count);
                    count = 1;
                }
            }
        }

        result.append(current);

        if (count > 1) {
            result.append(count);
        }

        return result.toString();
    }

    private static void validateInput(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("Wrong input!");
        }
    }
}
