package examples.task;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringUnzipper {

    public static String unzip(String input) {
        validate(input);
        String[] values = input.split("[\\[\\]]");
        StringBuilder builder = new StringBuilder();
        Deque<String> cache = new ArrayDeque<>();

        for (String s : values) {
            if (isAlphabetic(s)) {
                if (cache.isEmpty()) {
                    builder.append(s);
                } else {
                    String lastCached = cache.pollLast();

                    if (isAlphabetic(lastCached)) {
                        s = lastCached + s;
                        builder.append(s.repeat(getCount(cache.pollLast())));
                    } else {
                        int times = getCount(lastCached);

                        if (cache.isEmpty()) {
                            builder.append(s.repeat(times));
                        } else {
                            cache.add(s.repeat(times));
                        }
                    }
                }
            } else {
                cache.add(s);
            }
        }

        return builder.toString();
    }

    private static void validate(String input) {
        if (input == null || input.isBlank()
                || !input.matches("[\\[\\]A-z0-9]*") || input.matches("\\S*\\d$")) {
            throw new IllegalArgumentException("Wrong input!");
        }
    }

    private static int getCount(String value) {
        return Integer.parseInt(value);
    }

    private static boolean isAlphabetic(String lastCached) {
        return Character.isAlphabetic(lastCached.charAt(0));
    }
}
