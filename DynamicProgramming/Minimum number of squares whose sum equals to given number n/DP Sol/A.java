import java.io.*;
import java.util.*;

public class A{
	
	static int dp[] = null;
	public static void main(String args[]) throws IOException
		{
		System.out.println("Enter the value");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(br.readLine());
		dp = new int[val+1];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i=4; i<val+1; i++)
			{
			dp[i] = -1;
			}
		
		A obj = new A();
		System.out.println(obj.sum(val));
		}

	public int sum(int val)
		{
		

		if (dp[val] != -1)
			return dp[val];

		
		
		int res = val;
		
		for (int i=1;i<=val;i++)
			{
			int temp = i*i;
			if (temp > val)
				break;
			else
				{
				res = min(res,1+sum(val-temp));
				
				}
			}
		
		return dp[val] = res;
		}		

	public int min(int a, int b)
		{
		if (a<b)
			return a;
		else
			return b;
		}
}
