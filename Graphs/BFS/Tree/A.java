import java.io.*;
import java.util.*;

public class A{
	int data;
	A left;
	A right;
	
	public A()
	{}
	
	public A(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.println("Input root");
		//A root = new A(Integer.parseInt(br.readLine()));
		A obj = new A();
		A root = null;
		
		while(true)
		{
			System.out.println("Input data or type quit to exit");
			String str = br.readLine();
		
			if(str.equalsIgnoreCase("quit"))
				break;
			else
				root = obj.make_bst(root, Integer.parseInt(str));		
		}

			//obj.In_order(root);
			obj.BFS(root);
	}
	
	/*public void In_order(A root)
	{
	if(root == null)
			return;
		
	else
	{
		In_order(root.left);
		System.out.println(root.data);
		In_order(root.right);
	}
	}*/
	
	public void BFS(A root)
	{
		if(root == null)
			return;
		
		Queue<A> q = new LinkedList<A>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			A temp_node = q.poll();
			
			System.out.println(temp_node.data);
			
			if(temp_node.left != null)
				q.add(temp_node.left);
			
			if(temp_node.right != null)
				q.add(temp_node.right);
			
		}
		
		
	}
	
	public A make_bst(A node,int data)
	{
		if(node == null)
			return (new A(data));
		
		if(data <= node.data)
			node.left = make_bst(node.left,data);
		
		else if(data > node.data)
			node.right = make_bst(node.right, data);
		
		return node;
	}
}
