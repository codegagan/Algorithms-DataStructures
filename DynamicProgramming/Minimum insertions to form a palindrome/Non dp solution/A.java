import java.io.*;
import java.util.*;

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input String");
		String str = br.readLine();
		A obj = new A();
		int result = obj.min_chars_to_insert(str,0,str.length()-1);
		System.out.println(result);
	}
	
	public int min_chars_to_insert(String str,int i,int n)
	{
		int result = 0;
		if(i==n || i>n || n<0)
			return 0;
		
		if(str.charAt(i) == str.charAt(n))
			result = min_chars_to_insert(str,i+1,n-1);
		else
		{
			result = 1 + min(min_chars_to_insert(str,i+1,n),min_chars_to_insert(str,i,n-1));
		}
		
		return result;
	}
	
	public int min(int a,int b)
	{
		return (a<b)?a:b;
	}
}
