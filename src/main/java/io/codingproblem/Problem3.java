package io.codingproblem;

import java.util.*;

/**
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and
 * deserialize(s), which deserializes the string back into the tree.
 * <br/><br/>
 * For example, given the following Node class
 * <br/><br/>
 * <pre>
 * class Node:
 * def __init__(self, val, left=None, right=None):
 * self.val = val
 * self.left = left
 * self.right = right
 * </pre>
 * The following test should pass:
 * <pre>
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 * </pre>
 */
public class Problem3 {

    public static void main(String[] args) {
        Node node = new Node("1", new Node("2"), new Node("3"));
        String str = Problem3.serialize(node);
        Node newNode = Problem3.deserialize(str);
        System.out.println("Are nodes equal? " + node.equals(newNode));
    }

    protected static String serialize(Node root) {
        //edge case
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.poll();
            sb.append(n.data);
            sb.append(",");
            if (!n.data.equals("-1")) {
                if (n.left != null) {
                    q.add(n.left);
                } else {
                    q.add(new Node("-1"));
                }
                if (n.right != null) {
                    q.add(n.right);
                } else {
                    q.add(new Node("-1"));
                }
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }


    protected static Node deserialize(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] data = str.split(",");
        if (data.length == 1) {
            return new Node(data[0]);
        }
        return traverseArray(data, 0);
    }

    private static Node traverseArray(String[] data, int i) {
        if (i >= data.length) {
            return null;
        }
        if (data[i].equals("-1")) {
            return null;
        }
        Node node = new Node(data[i]);
        node.left = traverseArray(data, (i * 2) + 1);
        node.right = traverseArray(data, (i * 2) + 2);
        return node;
    }

    protected static class Node<T> {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Node node = (Node) obj;
            return (obj instanceof Node &&
                    Objects.equals(this.data, node.data) &&
                    Objects.equals(this.left, node.left) &&
                    Objects.equals(this.right, node.right));
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.data, this.left, this.right);
        }

        @Override
        public String toString() {
            return String.format("[Data=%s, left=%s, right=%s]", this.data, this.left, this.right);
        }
    }
}
