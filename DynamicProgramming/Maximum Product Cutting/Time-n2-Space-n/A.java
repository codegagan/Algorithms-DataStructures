import java.io.*;
import java.util.*;

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the size of rod");
		int size = Integer.parseInt(br.readLine());
		
		long result[] = new long[size+1];
		result[1] = 1;
		long max = 0;
		A obj = new A();
		for(int i=2;i<=size;i++)
		{
			for(int j=1;j<i;j++)
			{
				max = obj.max_val(max,(i-j)*j,result[i-j]*j);	
			}
			result[i] = max;
		}
		System.out.println(result[size]);
	}
	
	public long max_val(long a,long b,long c)
	{
		return (a>b)?(a>c?a:c):(b>c?b:c);
	}
}
