import java.io.*;
import java.util.*;

public class A{
	int data;
	A right;
	A left;
	
	public A()
	{}
	
	public A(int data)
	{
		this.data = data;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A obj = new A();
		A root = null;
		
		while(true)
		{
			String str = br.readLine();
			if(str.equalsIgnoreCase("quit"))
			{
				break;
			}
			root = obj.createBst(root,Integer.parseInt(str));
		}
		
		
		//q.add(root);
		
		Stack<A> st = obj.reverseLevelOrder(root);
		
		while(!st.isEmpty())
			System.out.print(st.pop().data + " ");
	}
	
	
	
	public Stack<A> reverseLevelOrder(A root)
	{
		Queue<A> q = new LinkedList<A>();
		Stack<A> st = new Stack<A>();
		q.add(root);
		while(!q.isEmpty())
		{
			A node = q.poll();
			st.push(node);
			
			if(node.right != null)
				q.add(node.right);
			
			if(node.left != null)
				q.add(node.left);
		}
		
		return st;
	}
	
	public A createBst(A node, int data)
	{
		if(node == null)
			return (new A(data));
		
		if(data < node.data)
			node.left = createBst(node.left, data);
		
		if(data > node.data)
			node.right = createBst(node.right, data);
		
		return node;
	}
}
