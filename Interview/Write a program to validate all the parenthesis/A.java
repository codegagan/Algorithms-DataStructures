import java.io.*;
import java.util.*;

public class A{
	public A()
	{}
	
	public static void main(String args[])throws IOException
	{
		Stack<Character> stk = new Stack<Character>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input String");
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++)
		{
			char temp = str.charAt(i);
			
			if(temp == '(' || temp ==')')
				if(!stk.isEmpty())
					if(temp == ')' && stk.peek().equals('('))
						stk.pop();
					else
						stk.push(temp);
				else
					stk.push(temp);
		}
		
		if(stk.isEmpty())
			System.out.println("String has all valid parenthesis");
		else
			System.out.println("String does not have valid parenthesis");
	}
}
