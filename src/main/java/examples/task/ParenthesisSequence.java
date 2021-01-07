/*
 * Проверить, что скобки сбалансированы (строка содержит только парные скобки).
 * Пример:
 *  - валидная строка: "{}()[]", "{([]())}"
 *  - невалидная строка: "{[]", "({[}])"
 */
package examples.task;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


@Slf4j
public class ParenthesisSequence {

    private static final Set<Character> OPENING_BRACKETS = Set.of('{', '(', '[');
    private static final Map<Character, Character> CLOSING_BRACKETS = Map.of('{', '}', '(', ')', '[', ']');

    public boolean isBalanced(@NonNull String brackets) {
        boolean result = true;
        final Deque<Character> stack = new LinkedList<>();
        final char[] bracketSequence = brackets.toCharArray();
        final boolean evenLength = bracketSequence.length % 2 == 0;

        if (evenLength) {
            for (final char currentBracket : bracketSequence) {
                if (OPENING_BRACKETS.contains(currentBracket)) {
                    stack.push(currentBracket);
                } else {
                    final Character openingBracket = stack.pop();

                    if (openingBracket == null || CLOSING_BRACKETS.get(openingBracket) != currentBracket) {
                        log.info("Brackets are not balanced!");
                        result = false;
                        break;
                    }
                }
            }
        } else {
            log.info("The brackets count is not even!");
            result = false;
        }

        return result;
    }
}
