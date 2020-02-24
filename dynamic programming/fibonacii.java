/*Question-->
Given a number N, print the first N fibonacci numbers.
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains the integer N.
Output:
Print the first n fibonacci numbers with a space between each number. Print the answer for each test case in a new line.
Constraints:
1<= T <=100
1<= N <=84
Example:
Input:
2
7
5
Output:
1 1 2 3 5 8 13
1 1 2 3 5
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    void fib(int num)
    {
        long dp[]=new long[num+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=num;i++)
        {
             dp[i]=dp[i-1]+dp[i-2];
        }
        for(int i=1;i<=num;i++)
        System.out.print(dp[i]+" ");
        System.out.println();
    }
	public static void main (String[] args) 
	{
		//code
		GFG obj=new GFG();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		    int num=sc.nextInt();
		obj.fib(num);
		}
	}
}