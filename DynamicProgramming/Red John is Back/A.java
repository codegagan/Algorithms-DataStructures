import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int result[] = new int[T];
		for(int i=0;i<T;i++)
		{
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N+1];
			if(N >0 && N <=3)
				arr[N] = 1;
			else if(N == 4)
				arr[N] = 2;
			else
			{
				arr[1] = 1;
				arr[2] = 1;
				arr[3] = 1;
				arr[4] = 2;
				
				for(int k=5;k<=N;k++)
				{
					arr[k] = arr[k-1] + arr[k-4];
				}
			}
			A obj = new A();
			result[i] = obj.find_prime(arr[N]);
		}
		
		for(int i=0;i<T;i++)
			System.out.println(result[i]);
	}
	
	public int find_prime(int val)
	{
		boolean arr[] = new boolean[val+1];
		//arr[1] = false;
		
		for(int i=2;i<=val;i++)
			arr[i] = true;
		
		for(int i=2;i*i<=val;i++)
		{
			if(arr[i])
			{
				for(int j=i;j*i<=val;j++)
				{
					arr[i*j] = false;
				}
			}
		}
		
		int max = 0;
		for(int i=2;i<=val;i++)
		{
			if(arr[i] == true)
				max = max+1;
		}
		return max;
	}
}
