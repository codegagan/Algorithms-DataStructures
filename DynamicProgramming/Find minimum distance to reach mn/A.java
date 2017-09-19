import java.io.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the max. number of rows");
		int m = Integer.parseInt(br.readLine());
		
		System.out.println("Enter the max. number of columns");
		int n = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[m][n];
		
		System.out.println("Input distances row-wise");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				arr[i][j] = Integer.parseInt(br.readLine());
			}
			
		A obj = new A();
		System.out.println(obj.min_distance(0,0,m-1,n-1,arr));
	}
	
	public int min_distance(int i,int j,int m,int n,int arr[][])
	{
		if(i>m || j>n)
			return 10000;
		
		if(i==m && j==n)
			return arr[i][j];
		
		int res = arr[i][j] + min(min_distance(i+1,j,m,n,arr),min_distance(i,j+1,m,n,arr));
		
		return res;
		
	}
	
	public int min(int a,int b)
	{
		if(a<=b)
			return a;
		else
			return b;
	}
}
