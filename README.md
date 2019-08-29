## Daily Coding Problem

##### Problem 1

Given a list of numbers and sum value, return whether any two numbers from the list add up to sum.

For example, given [10, 15, 3, 7] and sum = 17, return true since 10 + 7 is 17.

_Bonus: Can you do this in one pass?_
 
[Solution](src/main/java/io/codingproblem/Problem1.java) & [Tests](src/test/java/io/codingproblem/Problem1Test.java)

---

##### Problem 1 Variant

Instead of returning true or false, return positions of two numbers from the list which add up to sum.
 
For example, given [10, 15, 3, 7] and sum = 17, return [0, 3] since 10 + 7 is 17, otherwise return [-1, -1]

[Solution](src/main/java/io/codingproblem/Problem1Variant.java)

---

##### Problem 2

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

[Solution](src/main/java/io/codingproblem/Problem2.java) & [Tests](src/test/java/io/codingproblem/Problem2Test.java)

---

##### Problem 3

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class
```
class Node:
   def __init__(self, val, left=None, right=None):
       self.val = val
       self.left = left
       self.right = right
```
The following test should pass:
```
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
```
[Solution](src/main/java/io/codingproblem/Problem3.java) & [Tests](src/test/java/io/codingproblem/Problem3Test.java)

---
