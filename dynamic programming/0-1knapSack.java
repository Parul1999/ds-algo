/*Question--->
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines.
The first line consists of N the number of items.
The second line consists of W, the maximum capacity of the knapsack.
In the next line are N space separated positive integers denoting the values of the N items,
and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.

Output:
For each testcase, in a new line, print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000

Example:
Input:
2
3
4
1 2 3
4 5 1
2
3
1 2 3
4 5 6
Output:
3
1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    void knapSack(int val[],int w[],int capacity)
    {
        int n = val.length;
        long dp[][]=new long[n+1][capacity+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=capacity;j++)
            {
                if(i==0||j==0)
                dp[i][j]=0;
                else if(w[i-1] <= j)
                {
                    dp[i][j]=Math.max(val[i-1] + dp[i-1][j-w[i-1]],  dp[i-1][j]); 
                    
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[w.length][capacity]);
    }
	public static void main (String[] args) 
	{
		//code
		Scanner sc=new Scanner(System.in);
		GFG obj=new GFG();
		int num=sc.nextInt();
		for(int i=0;i<num;i++)
		{
		    int n=sc.nextInt();
		    int capacity=sc.nextInt();
		    int wt[]=new int[n];
		    int val[]=new int[n];
		    for(int j=0;j<n;j++)
		    {
		        wt[j]=sc.nextInt();
		    }
		    for(int k=0;k<n;k++)
		    {
		        val[k]=sc.nextInt();
		    }
		    obj.knapSack(wt,val,capacity);
		}
	}
}