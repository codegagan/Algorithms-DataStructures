import java.io.*;

public class A{
	public static void main(String args[])throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Maximum sum");
		int sum = Integer.parseInt(br.readLine());
		
		int arr[] = new int[3];
		arr[0] = 3;
		arr[1] = 5;
		arr[2] = 10;

		int dp[] = new int[sum+1];
		dp[0] =1;
		for(int i=0;i<3;i++)
			for(int j=arr[i]; j<=sum; j++)
				{
				dp[j] += dp[j-arr[i]]; 	
				}

		System.out.println(dp[sum]);
		}
}
