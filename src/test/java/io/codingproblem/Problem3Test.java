package io.codingproblem;

import static io.codingproblem.Problem3.Node;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

public class Problem3Test {

    @Test
    public void serializeDeserializeEmptyTree() {
        Node node = null;

        String serialized = Problem3.serialize(node);
        Assertions.assertNull(serialized);

        Node deserialized = Problem3.deserialize(serialized);
        Assertions.assertEquals(node, deserialized);
    }

    @Test
    public void serializeDeserializeJustRootTree() {
        Node node = new Node("1");

        String serialized = Problem3.serialize(node);
        Assertions.assertEquals("1,-1,-1", serialized);

        Node deserialized = Problem3.deserialize(serialized);
        Assertions.assertEquals(node, deserialized);
    }

    @Test
    public void serializeDeserializeEmptyLeftTree() {
        Node node = new Node("1", null, new Node("3"));

        String serialized = Problem3.serialize(node);
        Assertions.assertEquals("1,-1,3,-1,-1", serialized);

        Node deserialized = Problem3.deserialize(serialized);
        Assertions.assertEquals(node, deserialized);
    }

    @Test
    public void serializeDeserializeEmptyRightTree() {
        Node node = new Node("1", new Node("2"), null);

        String serialized = Problem3.serialize(node);
        Assertions.assertEquals("1,2,-1,-1,-1", serialized);

        Node deserialized = Problem3.deserialize(serialized);
        Assertions.assertEquals(node, deserialized);
    }

    @Test
    public void serializeDeserializeCompleteTree() {
        Node node = new Node("1", new Node("2", new Node("4"), new Node("5")), new Node("3", new Node("6"), new Node("7")));

        String serialized = Problem3.serialize(node);
        Assertions.assertEquals("1,2,3,4,5,6,7,-1,-1,-1,-1,-1,-1,-1,-1", serialized);

        Node deserialized = Problem3.deserialize(serialized);
        Assertions.assertEquals(node, deserialized);
    }
}
