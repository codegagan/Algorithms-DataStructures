import java.io.*;

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input Maximum number of dices");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Input Maximum faces of a dice");
		int m = Integer.parseInt(br.readLine());
		System.out.println("Input maximum sum");
		int sum = Integer.parseInt(br.readLine());
		
		A obj = new A();
		int result = obj.total_possibilities(0,m,n,sum);
		System.out.println(result);
	}
	
	public int total_possibilities(int k,int m,int n,int sum)
	{
		int result = 0;
		if(k==n && sum==0)
		{
			return 1;
		}
		else if(k>n || sum<0)
		{
			return 0;
		}
		else
		{
			for(int i=1;i<=m;i++)
			{
				result = result + total_possibilities(k+1,m,n,sum-i);
			}
		}
		
		return result;
		
	}
}
