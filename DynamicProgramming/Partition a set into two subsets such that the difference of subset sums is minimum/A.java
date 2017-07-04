
import java.io.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		System.out.println("Enter the size of array");
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		System.out.println("Input Elements");
		for(int i=0;i<N;i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
			sum = sum + arr[i];
		}
		
		boolean dp[][] = new boolean[N+1][sum+1];
		
		for(int i=1;i<=N;i++)
			dp[0][i] = false;
		
		for(int i=0;i<=N;i++)
			dp[i][0] = true;
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=sum;j++)
			{
				dp[i][j] = dp[i-1][j];
				
				if(j >= arr[i-1])
				{
					if(dp[i-1][j-arr[i-1]] == true )
						dp[i][j] = true;
				}
				
			}
		int global_min = 1000;
		
		for(int i=0;i<=N;i++)
			for(int j=0;j<=sum;j++)
			{
				if(dp[i][j] == true)
				{
				if((sum - 2*j) < global_min && (sum - 2*j) > 0)
					global_min = sum - 2*j;
				}
			}
			
			System.out.println(global_min);
	}
}
