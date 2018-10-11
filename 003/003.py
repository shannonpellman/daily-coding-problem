#!/usr/bin/env python

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def deserialize(s):
    def _deserialize(nodes):
        value = nodes.pop(0)

        if value == 'None':
            return None

        node = Node(value)
        node.left = _deserialize(nodes)
        node.right = _deserialize(nodes)

        return node

    return _deserialize(s.split(' '))


def serialize(root):
    def _serialize(node, nodes):
        if node is None:
            nodes.append('None')
        else:
            nodes.append(node.val)
            _serialize(node.left, nodes)
            _serialize(node.right, nodes)

        return nodes

    return ' '.join(_serialize(root, []))


if __name__ == '__main__':
    node = Node('root', Node('left', Node('left.left')), Node('right'))
    assert deserialize(serialize(node)).left.left.val == 'left.left'

    node = Node('root')
    assert deserialize(serialize(node)).val == 'root'

    assert deserialize(serialize(None)) == None
