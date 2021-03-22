package examples.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeparatorDistributor {

    private static final String INPUT_MESSAGE_TEMPLATE = "Input  : {}";
    private static final String OUTPUT_MESSAGE_TEMPLATE = "Output : {}";
    private static final String SEPARATOR = "_";
    private static final String ERROR_MESSAGE_TEMPLATE = "Invalid input : [%s]";
    private static final int MINIMAL_LETTERS_COUNT = 2;
    private static final String EMPTY_STRING = "";

    public static String format(String input) {
        log.info(INPUT_MESSAGE_TEMPLATE, input);
        validate(input);

        final var result = new StringBuilder();
        char[] chars = input.replace(SEPARATOR, EMPTY_STRING).toCharArray();
        int lettersCount = getLettersCount(input);
        int availablePlacesCount = lettersCount - 1;
        int separatorCount = input.length() - lettersCount;

        for (char c : chars) {
            result.append(c);

            if (separatorCount > 0) {
                int separatorLength = getSeparatorLength(availablePlacesCount, separatorCount);
                result.append(SEPARATOR.repeat(separatorLength));
                separatorCount -= separatorLength;
                availablePlacesCount--;
            }
        }

        String output = result.toString();
        log.info(OUTPUT_MESSAGE_TEMPLATE, output);
        return output;
    }

    private static int getSeparatorLength(int availablePlacesCount, int separatorCount) {
        if (availablePlacesCount > separatorCount) {
            return 1;
        } else {
            return separatorCount % availablePlacesCount > 0
                    ? separatorCount / availablePlacesCount + 1
                    : separatorCount / availablePlacesCount;
        }
    }

    private static void validate(String input) {
        if (input == null
                || !input.startsWith(SEPARATOR)
                || !input.endsWith(SEPARATOR)
                || getLettersCount(input) < MINIMAL_LETTERS_COUNT) {
            final var errorMessage = String.format(ERROR_MESSAGE_TEMPLATE, input);
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static int getLettersCount(String input) {
        return input.replace(SEPARATOR, EMPTY_STRING).length();
    }
}
