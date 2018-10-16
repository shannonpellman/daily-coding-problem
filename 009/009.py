#!/usr/bin/env python

import sys


def max_sum_nonadjacent_numbers(arr):
    # The max value for the last 2 positions scanned. Never has more than 2 elements
    max_values = []

    # The max value at the current position
    max_value = None

    # The max sum for the whole array
    max_sum = None

    i = 0

    while i < len(arr):
        if i < 2:
            if max_value is None or arr[i] > max_value:
                max_value = arr[i]

            max_values.append(max_value)
        else:
            value = max_values.pop(0) + arr[i]
            max_value = max(max_value, value, arr[i])
            max_values.append(max_value)

            if max_sum is None or max_value > max_sum:
                max_sum = max_value

        i += 1

    return max_sum


if __name__ == '__main__':
    assert max_sum_nonadjacent_numbers([1, 2, 3, 4, 5, 6, 7, 8]) == 20
    assert max_sum_nonadjacent_numbers([5, 1, 1, 5]) == 10
    assert max_sum_nonadjacent_numbers([5, 1, 1, 3, 1, 5]) == 13
    assert max_sum_nonadjacent_numbers([5, -1, 2, 11, -7, 1]) == 17
    assert max_sum_nonadjacent_numbers([]) is None
    assert max_sum_nonadjacent_numbers([1]) is None
    assert max_sum_nonadjacent_numbers([1, 1]) is None

    if len(sys.argv) > 1:
        numbers = list(map(lambda x: int(x), sys.argv[1:]))
        print(max_sum_nonadjacent_numbers(numbers))

