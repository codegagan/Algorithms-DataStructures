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
		System.out.println(Integer.MAX_VALUE-5);
		System.out.println("Input the size of array");
		int size = Integer.parseInt(br.readLine());
		
		A obj = new A(size);
		
		System.out.println("Filling array with random elements");
		
		Random r = new Random();
		for(int i=0;i<size;i++)
		{
			//obj.arr[i] = Integer.parseInt(br.readLine());
			obj.arr[i] = r.nextInt(101);
		}
		
		//int mid = (size-1)/2;
		
		Long startTime = System.currentTimeMillis();
		obj.mergeSort(0,size-1);
		Long stopTime = System.currentTimeMillis();
        Long singleThreadTimes = (stopTime - startTime);
        System.out.println(singleThreadTimes + "ms" + " to sort " + size + " elements");
		
		/*for(int i=0;i<size;i++)
		{
			System.out.println(obj.arr[i]);
		}*/
		
	}
	
	public void mergeSort(int low,int high)
	{
		if(low < high)
		{
			int mid = (low + high)/2;
			mergeSort(low,mid);
			mergeSort(mid+1,high);
			
			merge(low,mid,high);
		}
	}
	
	public void merge(int low,int mid,int high)
	{
		//System.out.println(low + " " + mid + " " + high);
		int size = high - low + 1;
		int arrTemp[] = new int[size];
		int i = low;
		int k = mid + 1;
		int temp = 0;
		while((i <= mid) && (k <= high))
		{
			//System.out.println(i + " " + k + " " + high);
			if(arr[i] < arr[k])
			{
				//System.out.println("i :" + arr[i] + "k :" + arr[k]);
				arrTemp[temp] = arr[i];
				temp = temp + 1;
				i = i + 1;
			}
			else
			{
				//System.out.println("k :" + arr[k] + "i :" + arr[i] );
				arrTemp[temp] = arr[k];
				temp = temp + 1;
				k = k + 1;
			}
		}
		
		if(i > mid)
		{
			while(k <= high)
			{
				arrTemp[temp] = arr[k];
				temp = temp + 1;
				k = k + 1;
			}
		}else
		{
			while(i <= mid)
			{
				//System.out.println("mid: " + arr[i]);
				//System.out.println("temp: " + temp);
				arrTemp[temp] = arr[i];
				temp = temp + 1;
				i = i + 1;
			}
		}
		int v = 0;
		for(int j = low; j <= high; j++)
		{
			
			//System.out.println( v +  " ada" + arrTemp[v]);
			arr[j] = arrTemp[v];
			v = v + 1;
		}
	}
}
