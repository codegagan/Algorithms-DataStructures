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
		
		System.out.println("Input the sub-set sum");
		int sum_subset = Integer.parseInt(br.readLine());
		
		boolean dp[][] = new boolean[N+1][sum+1];
		
		for(int i=1;i<=N;i++)
			dp[0][i] = false;
		
		for(int i=0;i<=N;i++)
			dp[i][0] = true;
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=sum;j++)
			{
				dp[i][j] = dp[i-1][j];
				//System.out.println(i-1 + " and " + j + " " + dp[i-1][j] );
				
				if(j >= arr[i-1])
				{
					if(dp[i-1][j-arr[i-1]] == true )
						dp[i][j] = true;
					
					//dp[i][j] |= dp[i-1][j-arr[i-1]];
				}
				
			}
			int q = 0;
			for(int i=0;i<=N;i++)
			{
				if(sum_subset <= sum)
				{
				if(dp[i][sum_subset] == true)
				{
					System.out.println(i + " : " + sum_subset + " is possible!!!");
					q = 1;
					break;
				}
				}
				
				else
					System.out.println("sum_subset is out of bounds");
			}
			
			if(q == 0)
				System.out.println("sum_subset is not possible");
		
	}
}
