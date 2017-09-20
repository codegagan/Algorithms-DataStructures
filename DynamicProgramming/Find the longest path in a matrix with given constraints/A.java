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
			
		int max = 0;	
		A obj = new A();
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
			int a = obj.longest_path(i,j,m-1,n-1,arr);
			if(a > max)
				max = a;
			}
		
		System.out.println("Longest chain will be of length: ");
		System.out.print(max + 1);
	}
	
	public int longest_path(int i,int j,int m,int n,int arr[][])
	{
		int res = 0;
		if(i+1 <= m && j <= n && arr[i+1][j] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i+1,j,m,n,arr));
		
		if(i <= m && j+1 <=n && arr[i][j+1] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i,j+1,m,n,arr));
		
		if(i-1 >= 0 && j <= n && arr[i-1][j] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i-1,j,m,n,arr));
		
		if(i-1 >= 0 && j-1 >= 0 && arr[i-1][j-1] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i-1,j-1,m,n,arr));
		
		return res;
	}
	public int max(int a,int b)
	{
		if(a>=b)
			return a;
		else
			return b;
	}
}import java.io.*;

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
			
		int max = 0;	
		A obj = new A();
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
			int a = obj.longest_path(i,j,m-1,n-1,arr);
			if(a > max)
				max = a;
			}
		
		System.out.println("Longest chain will be of length: ");
		System.out.print(max + 1);
	}
	
	public int longest_path(int i,int j,int m,int n,int arr[][])
	{
		int res = 0;
		if(i+1 <= m && j <= n && arr[i+1][j] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i+1,j,m,n,arr));
		
		if(i <= m && j+1 <=n && arr[i][j+1] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i,j+1,m,n,arr));
		
		if(i-1 >= 0 && j <= n && arr[i-1][j] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i-1,j,m,n,arr));
		
		if(i-1 >= 0 && j-1 >= 0 && arr[i-1][j-1] - arr[i][j] == 1)
			res = max(res,1 + longest_path(i-1,j-1,m,n,arr));
		
		return res;
	}
	public int max(int a,int b)
	{
		if(a>=b)
			return a;
		else
			return b;
	}
}
