package examples.task;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReversedLinkedList {

    public static MyList reverse(MyList value) {
        log.debug("Input: {}", value);

        if (isInvalidInput(value)) {
            log.debug("Output: {}", value);

            return value;
        }

        MyNode previous = value.node;
        MyNode current = value.node.nextNode;
        previous.nextNode = null;

        while (current != null) {
            MyNode nextNode = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = nextNode;
        }

        value.node = previous;
        log.debug("Output: {}", value);

        return value;
    }

    private static boolean isInvalidInput(MyList input) {
        return input == null || input.node == null || input.node.nextNode == null;
    }

    @AllArgsConstructor
    @ToString
    static class MyList {

        MyNode node;
    }

    @AllArgsConstructor
    @ToString
    static class MyNode {

        String value;
        MyNode nextNode;
    }
}
