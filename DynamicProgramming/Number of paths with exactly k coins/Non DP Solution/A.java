import java.io.*;

public class A{
	public static void main(String args[])throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of k");
		int k = Integer.parseInt(br.readLine());
		
		System.out.println("Enter the maximum number of rows");
		int R = Integer.parseInt(br.readLine());
		
		System.out.println("Enter the maximum number of columns");
		int C = Integer.parseInt(br.readLine());
		int arr[][] = new int[R][C];
		
		for (int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				{
				arr[i][j] = Integer.parseInt(br.readLine());		
				}
		
		A obj = new A();
		System.out.println(obj.total_paths(0,0,R-1,C-1,arr,k));
		}
		
	
	public int total_paths(int i,int j,int R,int C,int arr[][],int k)
		{
		if (i>R || j>C || k<0)
			return 0;
		
		
		if (k ==arr[i][j])
			{
				
			if(i==R && j == C)
			{
				
				return 1;
			}
				
			else
				return 0;
			}

		
		
		
		int res = total_paths(i+1,j,R,C,arr,k-arr[i][j]) + total_paths(i,j+1,R,C,arr,k-arr[i][j]);
		
		return res;
		}
	}
