#!/usr/bin/env python

def array_products(a):
    b = [None] * len(a)
    i = 0

    while i < len(a):
        j = 0

        while j < len(a):
            if i != j:
                b[i] = b[i] * a[j] if b[i] else a[j]
            j += 1
        i += 1
        
    return b

def _are_lists_equal(a, b):
    if len(a) != len(b):
        return False;

    i = 0

    while i < len(a):
        if a[i] != b[i]:
            return False

        i += 1

    return True

if __name__ == '__main__':
    assert _are_lists_equal([0, 1, 2], [0, 1, 2]) == True
    assert _are_lists_equal([0, 1, 2], [0, 2, 1]) == False
    assert _are_lists_equal([], []) == True
    assert _are_lists_equal([0, 1, 2, 3], [0, 1, 2]) == False

    assert _are_lists_equal(array_products([1, 2, 3, 4, 5]), [120, 60, 40, 30, 24])
    assert _are_lists_equal(array_products([2, -1, 3]), [-3, 6, -2])
