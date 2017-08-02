import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int final_arr[] = new int[T];
		StringTokenizer str = null;
		for(int i=0;i<T;i++)
		{
		str = new StringTokenizer(br.readLine());
		int arr[] = new int[Integer.parseInt(str.nextToken())];
		int max_sum = Integer.parseInt(str.nextToken());
		
		str = new StringTokenizer(br.readLine());
		for(int j=0;j<arr.length;j++)
		{
		arr[j] = Integer.parseInt(str.nextToken());
		}
		
		int dp[] = new int[max_sum + 1];
		dp[0] =1;
		
		for(int j=0;j<arr.length;j++)
		{
			for(int k=arr[j];k<=max_sum;k++)
			{
				if(k >= arr[j])
					dp[k] = dp[k] + dp[k-arr[j]] ;
			}
		}
		
		for(int m = max_sum; m>=0; m-- )
		{
			if(dp[m] != 0)
			{
				final_arr[i] = m;
				break;
			}
		}
		
		}
		
		for(int i=0;i<T;i++)
			System.out.println(final_arr[i]);
		}
}
