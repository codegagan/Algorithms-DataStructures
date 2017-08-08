import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long result_arr[] = new long[T];
		for(int i=0;i<T;i++)
		{
			int n = Integer.parseInt(br.readLine());
			//String arr[] = br.readLine().split("\\s");
			StringTokenizer st = new StringTokenizer(br.readLine());
			long arr[] = new long[n];
			int k=0;
			while(st.hasMoreTokens())
			{
				arr[k] = Long.parseLong(st.nextToken());
				k = k+1;
			}
			A obj = new A();
			long dp[] = new long[n];
			Arrays.fill(dp,-1);
			result_arr[i] = obj.bricks(0,n-1,arr, dp);
			
		}
		
		for(int i=0;i<T;i++)
			System.out.println(result_arr[i]);
	}
	
	public long bricks(int i,int n,long arr[],long dp[])
	{
		if(i>n)
			return 0;
		if(dp[i] != -1)
			return dp[i];
		
		long result = arr[i] + min(bricks(i+2,n,arr,dp),bricks(i+3,n,arr,dp),bricks(i+4,n,arr,dp));
		if(i+1 <= n)
			result = max(result,arr[i] + arr[i+1] + min(bricks(i+3,n,arr,dp),bricks(i+4,n,arr,dp),bricks(i+5,n,arr,dp)));
		if(i+2 <=n)
			result = max(result,arr[i] + arr[i+1]+ arr[i+2] + min(bricks(i+4,n,arr,dp),bricks(i+5,n,arr,dp),bricks(i+6,n,arr,dp)));
		
		return dp[i] = result;
	}
	
	public long max(long a,long b)
	{
		return (a>b)?a:b;
	}
	
	public long min(long a,long b,long c)
	{
		if(a<b && a<c)
			return a;
		else if(b<a && b<c)
			return b;
		else
			return c;
	}
}
