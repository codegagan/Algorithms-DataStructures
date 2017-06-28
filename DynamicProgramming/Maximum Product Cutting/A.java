import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input length of rod");
		int len = Integer.parseInt(br.readLine());
		A obj = new A();
		int dp[] = new int[len+1];
		Arrays.fill(dp,-1);
		int max = obj.max_len(len, dp);
		System.out.println(max);
	}
	
	public int max_len(int n,int dp[])
	{
		if(n<=1)
			return 0;
		
		int max_val = 0;
		
		if(dp[n] != -1)
			return dp[n];
		
		for(int i=1;i<n;i++)
		{
			max_val = max(max_val, (n-i)*i, max_len(n-i,dp)*i);
		}
		
		return dp[n] = max_val;
	}
	
	public int max(int a,int b,int c)
	{
		return (a>b)?(a>c?a:c):(b>c?b:c);
	}
}
