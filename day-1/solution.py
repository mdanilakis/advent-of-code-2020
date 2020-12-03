# looking for a sum of
sum_to_find = 2020

# read input
_input = open('input.txt', 'r')
lines = _input.readlines()


def find_sum_and_multiply():
    for line_x in lines:
        x = int(line_x.strip())
        for line_y in lines:
            y = int(line_y.strip())
            # if we find the sum
            if x + y == sum_to_find:
                # multiply the 2 numbers and return the result
                return x * y


print("Result: {}".format(find_sum_and_multiply()))
