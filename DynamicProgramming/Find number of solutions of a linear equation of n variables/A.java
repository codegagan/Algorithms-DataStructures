import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[]) throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Sum");
		int sum = Integer.parseInt(br.readLine());
		System.out.println("Enter the size of array");
		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		System.out.println("Input Co-efficients");
		for(int i=0; i<size; i++)
			{
			arr[i] = Integer.parseInt(br.readLine());
			}
		A obj = new A();
		System.out.println(obj.linear_equation(sum,arr,0));
		}

	public int linear_equation(int sum, int arr[],int k)
		{
		int res =0;
		if (sum == 0)
			return 1;
		
		if (sum < 0)
			return 0;

		for (int i=k;i<arr.length; i++)
			{
			res = res + linear_equation(sum-arr[i],arr,i);  
			}
		return res;
		}
	
	
	}
