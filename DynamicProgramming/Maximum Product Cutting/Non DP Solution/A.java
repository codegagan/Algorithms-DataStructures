import java.io.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input length of rod");
		int len = Integer.parseInt(br.readLine());
		A obj = new A();
		
		int max = obj.max_len(len);
		System.out.println(max);
	}
	
	public int max_len(int n)
	{
		if(n<=1)
			return 0;
		
		int max_val = 0;
		for(int i=1;i<n;i++)
		{
			max_val = max(max_val, (n-i)*i, max_len(n-i)*i);
		}
		
		return max_val;
	}
	
	public int max(int a,int b,int c)
	{
		return (a>b)?(a>c?a:c):(b>c?b:c);
	}
}
