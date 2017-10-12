import java.io.*;

public class A{
	int data;
	A pointer;
	
	public A()
	{}
	
	public A(int data)
	{
		this.data = data;
		this.pointer = null;
	}
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A obj = new A();
		A head = null;
		while(true)
		{
			System.out.println("Input data or type quit exit");
			String str = br.readLine();
		
			if(str.equalsIgnoreCase("quit"))
				break;
			else
			{
				head = obj.createList(head, Integer.parseInt(str));
			}
		}
		
		int flag = obj.checkPalindrome(head);
		
		if(flag == 1)
			System.out.println("LinkedList is a palindrome");
		
		else
			System.out.println("LinkedList is not a Palindrome");
		
		/*while(head != null)
		{
			System.out.println(head.data);
			head = head.pointer;
		}*/
	}
	
	public int checkPalindrome(A head)
	{
		A node = head;
		int i = 0;
		while(node != null)
		{
			i = i+1;
			node = node.pointer;
		}
		//System.out.println("i " + i);
		int j = i/2 + 1;
		//System.out.println("j " + j);
		
		node = head;
		int k = 1;
		while(true)
		{
			
			node = node.pointer;
			//System.out.println(node.data);
			k = k+1;
			
			if(k == j)
				break;
		}
		
		//System.out.println("k" + k);
		
		//System.out.println(node.data);
		
		A temp = node.pointer;
		A temp2 = temp.pointer;
		node.pointer = null;
		//System.out.println(temp);
		//System.out.println(temp2);
		
		while(temp != null)
		{
			temp.pointer = node;
			node = temp;
			temp = temp2;
			
			if(temp == null)
				break;
			//System.out.println(temp2);
			if(temp2.pointer == null)
				temp2 = null;
			else
				temp2 = temp2.pointer;
		}
		
		//System.out.println(head.data);
		//System.out.println(node.data);
		int var = 0;
		while(head != null && node != null)
		{
			if(head.data == node.data)
			{
				head = head.pointer;
				node = node.pointer;
				var = 1;
			}
			
			else
			{
				var = 0;
				break;
			}
				
		}
		return var;
	}
	
	public A createList(A node, int data)
	{
		if(node == null)
		{
			return (new A(data));
		}
		
		else
		{
			node.pointer = createList(node.pointer, data);
		}
		return node;
	}
}
