import java.io.*;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
	this.data = data;	
	}
}


public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A obj = new A();
		Node root = null;
		
		while(true)
		{
			String str = br.readLine();
			
			if(str.equalsIgnoreCase("quit"))
				break;
			else
				root = obj.createBst(root, Integer.parseInt(str));
		}
		
		obj.LevelOrderTraversal(root);
	}
	
	public void LevelOrderTraversal(Node root)
	{
		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();
		
		st1.push(root);
		
		while(!st1.empty() || !st2.empty())
		{
			while(!st1.empty())
			{
				Node n = st1.pop();
				System.out.print(n.data + " ");
				
				if(n.left != null)
					st2.push(n.left);
				
				if(n.right != null)
					st2.push(n.right);
			}
			
			while(!st2.empty())
			{
				Node n = st2.pop();
				System.out.print(n.data + " ");
				
				if(n.right != null)
					st1.push(n.right);
				
				if(n.left != null)
					st1.push(n.left);
			}
		}
	}
	
	public Node createBst(Node root, int data)
	{
		if(root == null)
			return (new Node(data));
		
		if(data < root.data)
			root.left = createBst(root.left, data);
		
		if(data > root.data)
			root.right = createBst(root.right, data);
		
		return root;
	}
}
