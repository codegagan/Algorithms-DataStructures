import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input size of array");
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		System.out.println("Input elements");
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result[][] = new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				result[i][j] = 2;
			
		int max_val = 0;
		A obj = new A();
		for(int j = n-2;j>0;j--)
		{
			int i = j-1;
			int k = j+1;
			
			while(i>=0 && k<=n-1)
			{
				if((arr[i] + arr[k]) < (2*arr[j]))
				{
					k++;
				}
				
				else if((arr[i] + arr[k]) > (2*arr[j]))
				{
					i--;
				}
				
				else if((arr[i] + arr[k]) == (2*arr[j]))
				{
					result[i][j] = result[j][k] + 1;
					max_val = obj.max(max_val, result[i][j]);
					i--;
					k++;
				}
			}
		}
		
		System.out.println(max_val);
		
	}
	
	public int max(int a,int b)
	{
		return a>b?a:b;
	}
}
