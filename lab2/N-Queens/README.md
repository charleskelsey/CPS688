The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two
queens attack each other.

The idea is to place queens one by one in different columns, starting from the leftmost column.
When placing a queen in a column, you should check for clashes with already placed queens (no
more than one Q in the row and column).

See the example below.

Input: \
Your input should take the number of matrix size N. your matrix is a zeros matrix

Output: \
Your output is a binary matrix which has 1s for the blocks where queens are placed.

| Input | Output |
| --- | ---|
| 4 | 0 0 1 0 <br /> 1 0 0 0 <br /> 0 0 0 1 <br /> 0 1 0 0 |
