It is the hiring season and many companies have already started looking for applicants to fill
positions. There are M job applicants and N jobs. Each applicant has a subset of jobs that he/she
is interested in. Each job opening can only accept one applicant and a job applicant can be
appointed for only one job. Implement and use the Ford-Fulkerson Algorithm for Maximum
Flow Problem to find the assignment of jobs to applicants such that as many applicants as
possible get jobs as shown below.

![image](https://user-images.githubusercontent.com/130581038/234332991-ea9afb89-82fe-4f2f-b6ac-bc4eea6d9763.png)

Steps:
  1. Convert the problem into a Flow Network: Add a source and add edges from the source
to all applicants. Similarly, add edges from all jobs to the target. The capacity of every
edge is marked as 1.
  2. Find the maximum flow: Use the Ford-Fulkerson algorithm to find the maximum flow in
the flow network built in step 1. The maximum flow is the maximum bipartite matching
we are looking for.

Input \
Your program will be tested against multiple test cases. Each test case includes the adjacency
list representation of the problem.

Output \
For each test case, determine the maximum number of applicants matching the jobs.

| Sample Input | Sample Output |
| 0 1 1 0 0 0 <br /> 0 0 0 0 0 0 <br /> 1 0 0 1 0 0 <br /> 0 0 1 0 0 0
0 0 1 1 0 0 <br /> 0 0 0 0 0 1 | The maximum number of applicants matching for the jobs is 5 |
