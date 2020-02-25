/*Question
Input:
First line of the input contains no of test cases  T,the T test cases follow.
Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2 respectively
The next two lines contains the 2 string str1 and str2 .

Output:
For each test case print the length of longest  common subsequence of the two strings .

Constraints:
1<=T<=200
1<=size(str1),size(str2)<=100

Example:
Input:
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC

Output:
3
2 */

import java.util.*;
import java.lang.*;
import java.io.*;

class longestCommonSubsequence {
    void common(String str1,String str2)
    {
    
        long dp[][]=new long[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++)
        {
            for(int j=0;j<=str2.length();j++)
            {
                 if (i == 0 || j == 0) 
                 {
                    dp[i][j] = 0; 
                 }//this is basically for initiAlizing the array to 0
                else if((str1.charAt(i-1))==(str2.charAt(j-1)))
                //i-1 n j-1 cuz basically string begins from 0 and when initially i was 0 , it was used for initializing
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		longestCommonSubsequence  obj=new longestCommonSubsequence ();
		int num=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
		    int n1=sc.nextInt();
		    int n2=sc.nextInt();
		    sc.nextLine();
		    String str1=sc.next();
		    String str2=sc.next();
		    obj.common(str1,str2);
		}
	}
}