#!/usr/bin/env python

import sys


def count_possible_decodings(message):
    # cumulative counts of the current char, previous char, and char before the previous char
    # count is initialized to 1 here to return the proper value for an empty message
    # count_p and count_pp are initialized to 1 because the message is guaranteed to be decodable
    count = count_p = count_pp = 1

    i = 2
    while i <= len(message):
        count = 0

        # if the previous char is non-zero, set count to cumulative count of the previous char
        if message[i - 1] > '0':
            count = count_p

        # if the char before the previous one is '1', or is '2' and the previous char is less than '7',
        # that indicates there is a one- or two-character token starting 2 chars ago
        if message[i - 2] == '1' or (message[i - 2] == '2' and message[i - 1] < '7'):
            count += count_pp

        # only the cumulative counts for the last 2 chars matter
        count_pp = count_p
        count_p = count

        i += 1

    return count


if __name__ == '__main__':
    message = sys.argv[1] if len(sys.argv) == 2 else ''
    num_decodings = count_possible_decodings(message)

    print('There %s %d possible decoding%s of "%s"'
          % ('are' if num_decodings > 1 else 'is', num_decodings, 's' if num_decodings > 1 else '', message))
