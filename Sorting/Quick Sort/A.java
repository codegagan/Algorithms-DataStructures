import java.io.*;
import java.util.*;

public class A{
	private int arr[];
	private int size;
	
	public A(int size)
	{
		this.size = size;
		arr = new int[this.size];
	}
	
	public static void main(String args[])throws IOException
	{
		//System.out.println(9/2);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input the size of array");
		int size = Integer.parseInt(br.readLine());
		
		A obj = new A(size);
		
		System.out.println("Fill array with elements");
		
		for(int i=0;i<size;i++)
		{
			obj.arr[i] = Integer.parseInt(br.readLine());
		}
		
		//int mid = (size-1)/2;
		
		obj.quickSort(0,size-1);
		
		for(int i=0;i<size;i++)
		{
			System.out.println(obj.arr[i]);
		}
	}
	
	public void quickSort(int low,int high)
	{
		if(low < high)
		{
			int p = partition(low,high);
			quickSort(low,p-1);
			quickSort(p+1,high);
		}
	}
	
	public int partition(int low,int high)
	{
		int pivot = high;
		int i = low - 1;
		for(int j = low;j <= high-1; j++)
		{
			if(arr[j] < arr[pivot])
			{
				i++;
				swap(i,j);
			}
		}
		
		swap(i+1,pivot);
		return i+1;
	}
	
	public void swap(int a,int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
