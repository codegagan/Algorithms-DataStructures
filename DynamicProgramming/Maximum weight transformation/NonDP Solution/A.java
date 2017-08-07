import java.io.*;
import java.util.*;

public class A{
	public static void main(String args[])throws IOException
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input String");
		String str = br.readLine();
		char str1[] = str.toCharArray();
		//System.out.println(str1[1]);
		A obj = new A();
		System.out.println(obj.max_len(str1,0,str.length()-1));
		}
	public int max_len(char str1[], int i, int size)
		{
		if (i > size)
			return 0;
		
		if (i == size)
			return 1;
	
		int res = 1 + max_len(str1, i+1, size);
		
		if (str1[i] == str1[i+1])
			{
			res = max(res, 3 + max_len(str1, i+2, size));
			}
		else if(str1[i] != str1[i+1])
			{
			res = max(res, 4 + max_len(str1, i+2, size));
			}

		return res;
		}
	public int max(int a, int b)
		{
		if (a >= b)
			return a;
		
		else
			return b;
		}
	
	}
