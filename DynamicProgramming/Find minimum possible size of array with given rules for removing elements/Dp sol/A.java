import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[]) throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of k");
		int k = Integer.parseInt(br.readLine());

		System.out.println("Enter the size of array");
		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
  		int n = rand.nextInt(1000);
  		arr[i] = n;
		}
		int dp[][] = new int[size][size];
		
		for (int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				{
				dp[i][j] = -1;
				}
		
		/*System.out.println("Input array");
		StringTokenizer str = new StringTokenizer(br.readLine());
		int i =0;
		while(str.hasMoreTokens())
			{
			arr[i] = Integer.parseInt(str.nextToken());
			i = i+1;
			}*/
		A obj = new A();
		System.out.println(obj.min_arr(0,size-1,arr,k,dp));
		}

	public int min_arr(int low, int high, int arr[], int k,int dp[][])
		{
		
		
		if ((high-low+1)<3)
			return high-low+1;

		if(dp[low][high] !=-1)
			return dp[low][high];

		int res = 1 + min_arr(low+1, high, arr, k,dp);
		
		for (int i=low +1 ; i<=high-1;i++)
			for (int j = i+1; j<=high; j++)
				{
				if(((arr[i]-arr[low])==k) && ((arr[j]-arr[i])==k) && min_arr(low+1,i-1,arr,k,dp)==0 && min_arr(i+1,j-1,arr,k,dp)==0)
					{
					res = min(res,min_arr(j+1,high,arr,k,dp));
					}
				
				}
		return dp[low][high] = res;
		}
	public int min(int a,int b)
		{
		if (a<=b)
			return a;
		else 
			return b;
		}
	}
