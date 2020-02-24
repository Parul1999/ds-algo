/* Question: 
The task is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down.

Input: 
First line consists of T test cases. First line of every test case consists of N and M, denoting the number of rows and number of column respectively.

Output: 
Single line output i.e count of all the possible paths from top left to bottom right of a mXn matrix. Since output can be very large number use %10^9+7.

Constraints:
1<=T<=100
1<=N<=100
1<=M<=100

Example:
Input:
1
3 3
Output:
6
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    void mazePath(int n,int m)
    {
        long dp[][]=new long[n+1][m+1];
          int mod = (int)Math.pow(10,9)+7;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0||j==0)
                dp[i][j]=1;
                else
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%mod;
            }
        }
        System.out.print(dp[n-1][m-1]);
        System.out.println();
    }
	public static void main (String[] args) 
	{
		//code
		Scanner sc=new Scanner(System.in);
		GFG obj=new GFG();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		    int n1=sc.nextInt();
		    int m=sc.nextInt();
		    obj.mazePath(n1,m);//considering source in 0,0 and destination in n,m(as in question)
		}
	}
}