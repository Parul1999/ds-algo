/*Question:
Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
For more description on this problem see wiki page

Input:
The first line of input is  T denoting the number of testcases.Then each of the T lines contains two positive integer N and K where 'N' is the number of eggs and 'K' is number of floor in building.

Output:
For each test case, print a single line containing one integer the minimum number of attempt you need in order find the critical floor.

Constraints:
1<=T<=30
1<=N<=10
1<=K<=50

Example:
Input:
2
2 10
3 5

Output:
4
3
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class eggDrop {
    void eggFloor(int egg,int floor)
    {
        long dp[][]=new long[egg+1][floor+1];
        for (int i = 1; i <= egg; i++) 
    { 
        dp[i][1] = 1; 
        dp[i][0] = 0; 
    } 
 
    for (int j = 1; j <= floor; j++) 
    {
        dp[1][j] = j; 
    }
        for(int i=2;i<=egg;i++)
        {
            for(int j=2;j<=floor;j++)
            {
                 dp[i][j] = Integer.MAX_VALUE; 
                for(int k=1;k<=j;k++)
                {
                    long res=1+Math.max(dp[i-1][k-1],dp[i][j-k]);
                    dp[i][j]=Math.min(res,dp[i][j]);
                }
            }
        }
        System.out.println(dp[egg][floor]);
    }
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		eggDrop obj =new eggDrop();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		    int egg=sc.nextInt();
		    int floor=sc.nextInt();
		    obj.eggFloor(egg,floor);
		    
		}
	}
}