import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input first String");
		String first = br.readLine();
		char f1[] = first.toCharArray();
		int m = f1.length;
		
		System.out.println("Input Second String");
		String second = br.readLine();
		char f2[] = second.toCharArray();
		int n = f2.length;
		int dp[][] = new int[m][n];
		
		for (int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				dp[i][j] = -1;

		A obj = new A();
		System.out.println(obj.longest_sub(f1,f2,m-1,n-1,dp));
		}

	public int longest_sub(char f1[], char f2[], int m,int n, int dp[][])
		{
		if (m<0 || n<0)
			return 0;
		if (dp[m][n] != -1)
			return dp[m][n];
		
		if (f1[m] == f2[n])
			return dp[m][n] = 1 + longest_sub(f1,f2,m-1,n-1,dp);
		else
			return dp[m][n] = max(longest_sub(f1,f2,m-1,n,dp),longest_sub(f1,f2,m,n-1,dp));
		}
	
	public int max(int a, int b)
		{
		if (a<=b)
			return b;
		else
			return a;
		}
	}
