import java.io.*;

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input the size of array");
		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		
		System.out.println("Input Elements");
		for(int i=0;i<size;i++)
		{
		arr[i] = Integer.parseInt(br.readLine());	
		}
		
		A obj = new A();
		
		int final_result = obj.find_max(0,size-1,arr);
		
		System.out.println(final_result);
	}
	
	public int find_max(int i,int size,int arr[])
	{
		if(size<0 || i>=arr.length || i>size)
			return 0;
		
		//int result = max(arr[i] + find_max(i+1,size,arr), arr[size] + find_max(i,size-1,arr));
		int result = arr[i] + min(find_max(i+2,size,arr),find_max(i+1,size-1,arr));
		
		result = max(result,arr[size] + min(find_max(i,size-2,arr),find_max(i+1,size-1,arr)));
		
		
		return result;
	}
	
	public int min(int a,int b)
	{
		return (a<b)?a:b;
	}
	
	public int max(int a,int b)
	{
		return (a>b)?a:b;
	}
}
