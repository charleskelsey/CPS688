Given a directed graph, write a program that checks if the given graph is strongly connected
or not. A directed graph is said to be strongly connected if every vertex is reachable from
every other vertex.

Following is Kosaraju’s DFS-based solution that does two DFS traversals of graph:
  1. Initialize all vertices as not visited.
  2. Do a DFS traversal of graph starting from any arbitrary vertex v. If DFS traversal doesn’t visit all vertices, then return false.
  3. Reverse all arcs (or find transpose or reverse of graph)
  4. Mark all vertices as not-visited in reversed graph.
  5. Do a DFS traversal of reversed graph starting from same vertex v (Same as step 2). If DFS traversal doesn’t visit all vertices, then return false. Otherwise return true.

The idea is, if every node can be reached from a vertex v, and every node can reach v, then the
graph is strongly connected. In step 2, we check if all vertices are reachable from v. In step 4, we
check if all vertices can reach v (In reversed graph, if all vertices are reachable from v, then all
vertices can reach v in original graph).

Input \
Your program will be tested against multiple test cases. Each test case begins with two
integers n and e, representing the number of antennas and cables. The next e lines represent
the antennas that are connected by a cable.

Output \
For each test case, print “yes” if all the antennas can communicate with each other; else print “no”.

| Sample Input | Sample Output |
| --- | --- |
| 4 4 <br /> 0 1 <br /> 1 2 <br /> 2 3 <br /> 3 0 | yes |
| 6 7 <br /> 0 1 <br /> 0 2 <br /> 2 4 <br /> 3 1 <br /> 3 5 <br /> 4 5 <br /> 5 0 | no |
