import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the maximum number of rows");
		int R = Integer.parseInt(br.readLine());
		System.out.println("Enter the maximum number of columns");
		int C = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[R][C];
		Random ran = new Random();
		System.out.println("Input Elements");
		for (int i=0;i<R;i++)
			for (int j=0;j<C;j++)
				{
				arr[i][j] = ran.nextInt(1000);
				//arr[i][j] = Integer.parseInt(br.readLine());
				}
		
		System.out.println("Enter the Row to find the minimum path");
		int r = Integer.parseInt(br.readLine());
		
		System.out.println("Enter the Column to find the minimum path");
		int c = Integer.parseInt(br.readLine());

		A obj = new A();
		System.out.println(obj.min_path(0,0,arr,r-1,c-1));
		}
	
	public int min_path(int i, int j, int arr[][], int r, int c)
		{
		if(i<0 || j<0 || i>r || j>c)	
			return 1000000;
		
		if(i==r && j==c)
			return arr[r][c];
		
		return arr[i][j] + min(min_path(i,j+1,arr,r,c),min_path(i+1,j+1,arr,r,c), min_path(i+1,j,arr,r,c));
		}
		
	public int min(int a,int b,int c)
		{
		if (a<b && a<c)
			return a;
		
		else if(b<a && b<c)
			return b;
		
		else
			return c;
		}
	}
