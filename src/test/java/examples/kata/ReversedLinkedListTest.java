package examples.kata;

import org.junit.jupiter.api.Test;

import static examples.kata.ReversedLinkedList.reverse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReversedLinkedListTest {

    @Test
    void givenLinkedList_whenReverse_thenReturnReversed() {
        ReversedLinkedList.MyNode tail = new ReversedLinkedList.MyNode("567", null);
        ReversedLinkedList.MyNode beforeTail = new ReversedLinkedList.MyNode("456", tail);
        ReversedLinkedList.MyNode central = new ReversedLinkedList.MyNode("345", beforeTail);
        ReversedLinkedList.MyNode afterHead = new ReversedLinkedList.MyNode("234", central);
        ReversedLinkedList.MyNode head = new ReversedLinkedList.MyNode("123", afterHead);
        ReversedLinkedList.MyList list = new ReversedLinkedList.MyList(head);

        ReversedLinkedList.MyList result = reverse(list);

        assertEquals(tail.value, result.node.value);
        assertEquals(beforeTail.value, result.node.nextNode.value);
        assertEquals(central.value, result.node.nextNode.nextNode.value);
        assertEquals(afterHead.value, result.node.nextNode.nextNode.nextNode.value);
        assertEquals(head.value, result.node.nextNode.nextNode.nextNode.nextNode.value);
        assertNull(result.node.nextNode.nextNode.nextNode.nextNode.nextNode);
    }

    @Test
    void givenTwoValuesLinkedList_whenReverse_thenReturnReversed() {
        ReversedLinkedList.MyNode tail = new ReversedLinkedList.MyNode("234", null);
        ReversedLinkedList.MyNode head = new ReversedLinkedList.MyNode("123", tail);
        ReversedLinkedList.MyList list = new ReversedLinkedList.MyList(head);

        ReversedLinkedList.MyList result = reverse(list);

        assertEquals(tail.value, result.node.value);
        assertEquals(head.value, result.node.nextNode.value);
        assertNull(result.node.nextNode.nextNode);
    }

    @Test
    void givenOneValueLinkedList_whenReverse_thenReturnTheSame() {
        ReversedLinkedList.MyNode head = new ReversedLinkedList.MyNode("123", null);
        ReversedLinkedList.MyList list = new ReversedLinkedList.MyList(head);

        ReversedLinkedList.MyList result = reverse(list);

        assertEquals(head.value, result.node.value);
        assertNull(result.node.nextNode);
    }

    @Test
    void givenEmptyList_whenReverse_thenReturnTheSame() {
        ReversedLinkedList.MyList result = reverse(new ReversedLinkedList.MyList(null));

        assertNull(result.node);
    }

    @Test
    void givenNullValue_whenReverse_thenReturnTheSame() {
        assertNull(reverse(null));
    }
}
