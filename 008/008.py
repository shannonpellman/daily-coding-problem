#!/usr/bin/env python


class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def count_unival_subtrees(node):
    if not node:
        return 0

    if not node.left and not node.right:
        return 1

    left_unival_subtrees = count_unival_subtrees(node.left)
    right_unival_subtrees = count_unival_subtrees(node.right)

    is_left_unival = not node.left or (node.value == node.left.value and left_unival_subtrees > 0)
    is_right_unival = not node.right or (node.value == node.right.value and right_unival_subtrees > 0)

    return (1 if is_left_unival and is_right_unival else 0) + left_unival_subtrees + right_unival_subtrees


if __name__ == '__main__':
    assert count_unival_subtrees(Node(0)) == 1
    assert count_unival_subtrees(Node(1)) == 1
    assert count_unival_subtrees(Node(0, Node(0))) == 2
    assert count_unival_subtrees(Node(0, Node(1))) == 1
    assert count_unival_subtrees(Node(0, Node(0), Node(0))) == 3
    assert count_unival_subtrees(Node(1, Node(1), Node(0))) == 2
    assert count_unival_subtrees(Node(0, Node(1), Node(0, Node(1, Node(1), Node(1)), Node(0)))) == 5
