#!/usr/bin/env python

def swap(array, i, j):
    temp = array[i]
    array[i] = array[j]
    array[j] = temp

def shift_negative_numbers(array):
    i = j = 0

    while i < len(array):
        if (array[i] <= 0):
            swap(array, i, j)
            j += 1
        i += 1

    return j

def first_missing_positive_int(array):
    start = shift_negative_numbers(array)
    end = len(array)

    i = start
    while i < end:
        value_index = abs(array[i]) - 1

        if value_index < end and array[value_index] > 0:
            array[value_index] = -1 * array[value_index]

        i += 1

    i = start
    while i < end:
        if (array[i] > 0):
            return (i + 1) - (start - 1)

        i += 1

    return (end - start) + 1

if __name__ == '__main__':
    assert first_missing_positive_int([0]) == 1
    assert first_missing_positive_int([1]) == 2
    assert first_missing_positive_int([1, 2, 3, 4, 5, 6]) == 7
    assert first_missing_positive_int([-1, -2, -3, -4]) == 1
    assert first_missing_positive_int([-1, -2, -3, 1, -4]) == 2
    assert first_missing_positive_int([3, 4, -1, 1]) == 2
    assert first_missing_positive_int([1, 2, 0]) == 3
