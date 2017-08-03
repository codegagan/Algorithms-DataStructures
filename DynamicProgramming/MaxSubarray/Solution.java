import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int final_arr[][] = new int[T][2];
		StringTokenizer str = null;
		for(int i=0;i<T;i++)
		{
		//str = new StringTokenizer(br.readLine());
		int arr[] = new int[Integer.parseInt(br.readLine())];
		//int max_sum = Integer.parseInt(str.nextToken());
		
		int max_sum1 = 0;
		int temp = 0;
		int max_sum2 = 0;
		int min = -100000;
		str = new StringTokenizer(br.readLine());
		for(int j=0;j<arr.length;j++)
		{
		arr[j] = Integer.parseInt(str.nextToken());
		
		temp = temp + arr[j];
		if(temp >= max_sum1)
			max_sum1 = temp;
		else if(temp < 0)
			temp = 0;
		
		if(arr[j] > 0)
			max_sum2 = max_sum2 + arr[j];
		
		if(arr[j] < 0 && arr[j] > min)
			min = arr[j];
		}
		
		if (max_sum1 == 0)
			max_sum1 = min;
		if (max_sum2 == 0)
			max_sum2 = min;
		
		final_arr[i][0] = max_sum1;
		final_arr[i][1] = max_sum2;
		
		
		
		}
		for(int i=0;i<T;i++)
		{
			System.out.print(final_arr[i][0] + " " + final_arr[i][1]);
			System.out.println();
		}
		
		
		}
}
