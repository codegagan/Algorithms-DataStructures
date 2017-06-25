import java.io.*;
import java.util.*;

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input String");
		String str = br.readLine();
		A obj = new A();
		int arr[][] = new int[str.length()][str.length()];
		
		for(int i=0;i<str.length();i++)
			Arrays.fill(arr[i],-1);
		
		int result = obj.min_chars_to_insert(str,0,str.length()-1,arr);
		System.out.println(result);
	}
	
	public int min_chars_to_insert(String str,int i,int n,int arr[][])
	{
		int result = 0;
		if(i==n || i>n || n<0)
			return 0;
		
		if(arr[i][n] != -1)
			return arr[i][n];
		
		if(str.charAt(i) == str.charAt(n))
			result = min_chars_to_insert(str,i+1,n-1,arr);
		else
		{
			result = 1 + min(min_chars_to_insert(str,i+1,n,arr),min_chars_to_insert(str,i,n-1,arr));
		}
		
		return arr[i][n] = result;
	}
	
	public int min(int a,int b)
	{
		return (a<b)?a:b;
	}
}
