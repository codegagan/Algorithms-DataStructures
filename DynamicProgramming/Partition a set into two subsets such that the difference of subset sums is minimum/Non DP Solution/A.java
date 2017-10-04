import java.io.*;

public class A{
	int arr2[] = null;
	int global_min = 1000;
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the size of array");
		int N = Integer.parseInt(br.readLine());
		
		int arr1[] = new int[N];
		A obj = new A();
		int global_sum = 0;
		System.out.println("Input elements");
		for(int i=0;i<N;i++)
		{
			arr1[i] = Integer.parseInt(br.readLine());
			global_sum = global_sum + arr1[i];
		}
		
		for(int k=1;k<=N;k++)
		{
			obj.arr2 = new int[k];
			obj.combinations(k-1,0,0,N,arr1,global_sum);
		}
		
		System.out.println(obj.global_min);
	}
	
	public void combinations(int len,int i,int l,int N,int arr1[],int global_sum)
	{
		if(l>len)
		{
			int sum = 0;
			//System.out.println();
			for(int j=0;j<=len;j++)
			{
				sum = sum + arr2[j];
			}
			if((global_sum - sum)<global_min && (global_sum - sum) > 0)
				global_min = global_sum - sum;
		return;
		}
		while(i<N)
		{
			arr2[l] = arr1[i];
			//System.out.println(arr2[l]);
			combinations(len,i+1,l+1,N,arr1,global_sum);
			//System.out.println(i);
			i = i+1;
		}
		
	}
}
