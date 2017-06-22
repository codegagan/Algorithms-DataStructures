import java.io.*;

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input maximum rows");
		int R = Integer.parseInt(br.readLine());
		
		System.out.println("Input maximum columns");
		int C = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[R][C];
		
		System.out.println("Input elements");
		
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
			{
				arr[i][j] = Integer.parseInt(br.readLine());
			}
			
		A obj = new A();
		
		System.out.println(obj.find_min_points(arr,R,C,0,0,0,0) + 1);
	}
	
	public int find_min_points(int arr[][],int R,int C,int i,int j,int temp1,int temp2)
	{
		
		
		if(i > R-1 && j == C-1)
		{
			//System.out.print(temp1 + " ");
			return temp1;
		}
		else if(i == R-1 && j > C-1)
		{
			//System.out.print(temp1 + " ");
			return temp1;
		}
		
		if(i>R-1 || j>C-1)
			return 1000;
			
		int res = 10000;
		
		int val1 = arr[i][j];
		//System.out.println("val1" + val1);
		if(val1 < 0)
		{
			val1 = val1 * -1;
			if(temp2 != 0)
			{
				if(val1 < temp2)
					temp2 = temp2 - val1;
			
				else
				{
					val1 = val1 - temp2;
					temp2 = 0;
					temp1 = temp1 + val1;
				}
			}
			else
				{
					temp1 = temp1 + val1;
				}
		}
		else
		{
		temp2 = temp2 + val1;	
		}
		//System.out.print(temp1 + " ");
		
		
		if(j<C)
		{
			res = min(res, find_min_points(arr,R,C,i,j+1,temp1,temp2));
		}
		if(i<R)
		{
			res = min(res,find_min_points(arr,R,C,i+1,j,temp1,temp2));
		}
		
		return res;
	}
	
	public int min(int a,int b)
	{
		return a<b?a:b;
	}
}
