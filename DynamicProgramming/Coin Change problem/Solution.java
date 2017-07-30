import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer str = null;
		
		str = new StringTokenizer(br.readLine());
		int max_sum = Integer.parseInt(str.nextToken());
		int arr[] = new int[Integer.parseInt(str.nextToken())];
		
		
		str = new StringTokenizer(br.readLine());
		for(int j=0;j<arr.length;j++)
		{
		arr[j] = Integer.parseInt(str.nextToken());
		}
		
		long dp[] = new long[max_sum + 1];
		dp[0] =1;
		
		for(int j=0;j<arr.length;j++)
		{
			for(int k=arr[j];k<=max_sum;k++)
			{
				if(k >= arr[j])
					dp[k] = dp[k] + dp[k-arr[j]] ;
			}
		}
		
		System.out.println(dp[max_sum]);
		}
}
