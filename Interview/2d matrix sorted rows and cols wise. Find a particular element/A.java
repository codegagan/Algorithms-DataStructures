import java.io.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input maximum rows");
		int m = Integer.parseInt(br.readLine());
		
		System.out.println("Input maximum columns");
		int n = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[m][n];
		
		
		System.out.println("Input Elements");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				arr[i][j] = Integer.parseInt(br.readLine());
			
		
		
		System.out.println("Input the element you want to find");
		int element = Integer.parseInt(br.readLine());
		
		A obj = new A();
		int res = obj.findElement(arr,m,n,element);
		if(res == 0)
			System.out.println("Element Not Found");
		else
			System.out.println("Element found");
	}
	
	public int findElement(int arr[][],int rows,int cols,int element)
	{
		int j = 0;
		int k = cols-1;
		
		for(int i=1; i<=(rows+cols); i++)
		{
		if(j >= rows || j<0 || k >= cols || k<0)
				return 0;
			
		if(element == arr[j][k])
				return arr[j][k];
			
		else if(element < arr[j][k])
			k = k-1;
		
		else if(element > arr[j][k])
			j = j+1;
		}
		
		return 0;
	}
	
	
}
