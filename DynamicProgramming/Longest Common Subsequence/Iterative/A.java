import java.io.*;

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
	}
	
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
}
