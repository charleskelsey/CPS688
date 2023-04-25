The Longest Increasing Subsequence (LIS) problem is to find the length of the longest
subsequence of a given sequence such that all elements of the subsequence are sorted
in increasing order. For example, the length of LIS for array A = {10, 22, 9, 33, 21, 50, 41,
60, 80} is 6 and LIS of A is {10, 22, 33, 50, 60, 80}.

Write a Dynamic programming solution for LIS. Print the LIS and the elements that formed
this LIS.

Hint: this problem may be converted to a Longest Common Subsequence problem. Create
another array (Array B) of unique elements of the original array (array A) and sort it. The
Longest Increasing Subsequence of A must be present as a subsequence in B.

| Sample Input | Sample Output |
| --- | --- |
| 10 22 9 33 21 50 41 60 | LIS = 50 <br /> LIS is: 10 22 33 50 60 |
