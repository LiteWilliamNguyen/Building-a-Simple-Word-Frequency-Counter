# Building-a-Simple-Word-Frequency-Counter

Explanation of the Code:
Reading Input: The program prompts the user to enter text. It keeps reading lines until "exit" is typed.

Processing and Normalization:

Converts each line to lowercase.
Strips punctuation using replaceAll("[^a-zA-Z ]", "").
Splits the line into words using split("\\s+").
Counting Frequencies:

Uses a HashMap to count each word's frequency. If the word exists, it increments the count; otherwise, it adds the word with a count of 1.
Sorting and Displaying:

Converts HashMap to TreeMap for alphabetical sorting.
Prints each word and its frequency.

Sample:

Enter Text, and type 'exit' to finish

Hello nice to meet you
how can you. It is nice to see you too.
exit

Word Frequency:

can: 1

hello: 1

how: 1

is: 1

it: 1

meet: 1

nice: 2

see: 1

to: 2

too: 1

you: 3


Process finished with exit code 0
