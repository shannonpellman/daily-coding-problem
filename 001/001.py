#!/usr/bin/env python

def adds_up_to_k(list, k):
    """Checks whether any two numbers in a list add up to a given sum

    Args:
        list: A list containing numbers
        k: The given sum

    Returns:
        True if any two numbers in list add up to k. False otherwise
    """

    dict = {}

    for number in list:
        if k - number in dict:
            return True

        dict[number] = True

    return False

if __name__ == '__main__':
    assert adds_up_to_k([10, 15, 3, 7], 17) == True
    assert adds_up_to_k([10, 15, 3, 7], 12) == False
    assert adds_up_to_k([1], 1) == False
    assert adds_up_to_k([0, 0], 0) == True
    assert adds_up_to_k([1, 2], 3) == True
    assert adds_up_to_k([-1, -2], -3) == True
    assert adds_up_to_k([-1, 1], 0) == True
