import re

# read input
_input = open('input.txt', 'r')
lines = _input.readlines()

# regex e.g. 6-8 b: bbbnvbbb
regex = r"(\d+)-(\d+) ([a-z]): (\w+)"

# keep a valid count
valid_count = 0

# iterate through lines
for line in lines:
    # search for pattern
    match = re.search(regex, line.strip())
    if match:

        # min/max
        _min = int(match.group(1))
        _max = int(match.group(2))

        # letter
        letter = match.group(3)

        # password
        password = match.group(4)

        # Policy 1
        # count = 0
        # for char in password:
        #     if char == letter:
        #         count += 1
        #
        # if _min <= count <= _max:
        #     valid_count += 1

        # Policy 2
        chat_at_min = password[_min - 1]
        chat_at_max = password[_max - 1]

        # check if policy is valid
        if chat_at_min != chat_at_max and (chat_at_min == letter or chat_at_max == letter):
            valid_count += 1


print("Result: {}".format(valid_count))
