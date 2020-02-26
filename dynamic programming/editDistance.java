/*Question:
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of cost=1.
Both the strings are of lowercase.

Input:
The First line of the input contains an integer T denoting the number of test cases. Then T test cases follow. Each tese case consists of two lines. The first line of each test case consists of two space separated integers P and Q denoting the length of the strings str1 and str2 respectively. The second line of each test case coantains two space separated strings str1 and str2 in order.

Output:
Corresponding to each test case, pirnt in a new line, the minimum number of operations required.

Constraints:
1 <= T <= 50
1 <= P <= 100
1 <= Q <= 100

Example:
Input:
1
4 5
geek gesek

Output:
1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class editDistance {
	public static void main (String[] args)
	{
		//code
		Scanner sc=new Scanner(System.in);
		editDistance obj =new GFG();
		int num=sc.nextInt();
		for(int i=0;i<num;i++)
		{
		    int n1=sc.nextInt();
		    int n2=sc.nextInt();
		    String word1=sc.next();
		    String word2=sc.next();
		    int res=obj.editDis(word1,word2);
		    System.out.println(res+" ");
		}
	}
	 int editDis(String word1, String word2) 
	 {
	int[][] dp = new int[word1.length()+ 1][word2.length() + 1];


	for (int i = 0; i <= word1.length(); i++) {
		for (int j = 0; j <= word2.length(); j++) {
			if(j==0) 
			dp[i][j]=i;
			else if(i==0) 
			dp[i][j]=j;
			else if (word1.charAt(i-1) == word2.charAt(j-1)) {
				dp[i][j] = dp[i-1][j-1]; 
			} else {
				int replace = dp[i-1][j-1] ;
				int insert = dp[i][j-1] ;
				int delete = dp[i -1][j] ;

				int min =1+Math.min(replace,Math.min(insert,delete));
				dp[i][j] = min;
			}
		}
	}
 
	return dp[word1.length()][word2.length()];
	}
}