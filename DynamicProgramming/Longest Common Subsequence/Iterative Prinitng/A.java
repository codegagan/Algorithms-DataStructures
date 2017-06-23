import java.io.*;
import java.util.*;

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input First String");
		String str1 = br.readLine();
		
		System.out.println("Input Second String");
		String str2 = br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int dp[][] = new int[len1+1][len2+1];
		
		for(int i=0;i<=len1;i++)
			for(int j=0;j<=len2;j++)
			{
				if(i==0 || j==0)
					dp[i][j] = 0;
				
				else if(str1.charAt(i-1) == str2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1] + 1;
					
				}
				
				else if(str1.charAt(i-1) != str2.charAt(j-1))
				{
					dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
			System.out.println("Length of Longest Common Subsequence is: " + dp[len1][len2]);
			StringBuilder sb = new StringBuilder();
			
			while(len1>0 && len2>0)
			{
				if(str1.charAt(len1-1) == str2.charAt(len2-1))
				{
					//System.out.print(str1.charAt(len1-1));
					sb.insert(0,str1.charAt(len1-1));
					len1 = len1-1;
					len2 = len2-1;
				}
				else if(dp[len1-1][len2] > dp[len1][len2-1])
				{
					len1 = len1-1;
				}
				else
					len2 = len2 -1;
			}
		System.out.println(sb);	
	}
	
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
}
