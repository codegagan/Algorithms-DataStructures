import java.io.*;

public class A{
	int min[][] = null;
		
	public A(int N)
		{
		min = new int[N][N];
		}
	
	public static void main(String args[])throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Last Station");
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		A obj = new A(N);
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				if(j>i)
				{
					System.out.println("Enter fare from " + i + " to " + j + " station");
					arr[i][j] = Integer.parseInt(br.readLine());
				}
				else
				{
					arr[i][j] = 0;
				}
			obj.min[i][j] = -1;
			}

		obj.min_fare(0,N-1,arr);
		System.out.println(obj.min[0][N-1]);		
		}

	public int min_fare(int k,int N,int arr[][])
		{
		if(k >= N)
			return 0;
		
		int res = 10000;
		for(int i=k;i<=N;i++)
			for(int j=i+1;j<=N;j++)
				{
				res = min_val(res,arr[i][j] + min_fare(j,N,arr));
				//System.out.println(res);
				min[i][j] = res;
				}
		return res;
		}
	public int min_val(int a,int b)
		{
		//System.out.println(a + ":" + b);
		if (a<b)
			return a;
		else
			return b;
		}
}
