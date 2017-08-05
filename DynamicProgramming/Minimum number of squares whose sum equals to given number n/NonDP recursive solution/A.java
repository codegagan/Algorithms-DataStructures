import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[]) throws IOException
		{
		System.out.println("Enter the value");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(br.readLine());
		//double size = val;
		//int size1 = Integer.parseInt(Math.sqrt(size));
		//System.out.println("Enter the size of the array");
		//int size = Integer.parseInt(br.readLine());
		/*System.out.println("Enter values to be pushed inside of the array");
		String s = br.readLine();
		StringTokenizer str = new StringTokenizer(s);
		int size =0;
		while(str.hasMoreTokens())
			{
			size = size +1;
			str.nextToken();
			}
		int arr[] = new int[size];
		int i =0;
		str = new StringTokenizer(s);
		while(str.hasMoreTokens())
			{
			arr[i] = Integer.parseInt(str.nextToken());
			//System.out.println(arr[i]);
			i = i+1;
			}*/
		A obj = new A();
		System.out.println(obj.sum(val));
		}

	public int sum(int val)
		{
		if (val<=3)
			return val;
		
		int res = val;
		
		for (int i=1;i<=val;i++)
			{
			int temp = i*i;
			if (temp > val)
				break;
			else
				{
				res = min(res,1+sum(val-temp));
				//System.out.println(res);
				}
			}
		return res;
		}		

	public int min(int a, int b)
		{
		if (a<b)
			return a;
		else
			return b;
		}
}
