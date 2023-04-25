**Problem 1 - N-Queens** \

**Problem 2 - Acyclic Graph** \
Given an undirected graph, you are required to check if the graph has a cycle.

Hint: consider using BFS/DFS

Input \
Your program will be tested against multiple test cases. Each test case begins with two integers
n and e, representing the number of vertices and edges. The next e lines represent the vertices
that are connected by an edge.

Output \
For each test case, print “no” if the graph contains a cycle; else print “yes”

| Sample Input | Sample Output |     
| --- | --- |
| 6 6 <br /> 0 1 <br /> 0 3 <br /> 1 2 <br /> 2 4 <br /> 3 4 <br /> 3 5 | no |

| Sample Input | Sample Output |     
| --- | --- |
| 6 6 <br /> 0 1 <br /> 0 2 <br /> 0 3 <br /> 1 4 <br /> 2 5 | yes |

**Problem 3 - Minimum Spanning Tree** \

**Problem 4 - Knapsack without Repetition** \
John enters a candy shop and in his hand is a very light-thin bag. He is given 20 mins to collect
as much candy as possible, but he needs to make sure that the bag doesn’t tear apart. There’s a
fixed number of candies in the shop – each with its own weight and sentimental value. Of course,
his goal is to put as many candies in the bag as possible while also maximizing the number of
best-quality candies so that he can enjoy the treat during the weekend. Plus, he doesn’t want to
share the candy with anyone since the candy placed in the bag is of the most value with respect
to him.

But John needs your help! So, can you be kind and help him choose the candy he’s required to
put in the bag and the ones he’s supposed to keep at the store?

Input:
  * The first line contains one integer N; the number of candies present in the shop. Then 3 lines follow.
  * The second line contains N integers where Ni represents the sentimental value of the candy w.r.t John
  * The third line contains N integers where Ni represents the weight of each candy.
  * The last line contains one integer W representing the maximum weight that can be carried by the bag

Output: \
Output the highest sentimental aggregated value

| Sample Input | Sample Output |
| --- | --- |
| 3 <br /> 6 10 12 <br /> 1 2 3 <br /> 5 | 22 |

**Problem 5 - Longest Increasing Subsequence** \
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
