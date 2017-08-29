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
	int local_max;
	int global_max;
	int level;
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
		
		int ht = obj.height(root);
		
		for(int i=1; i<=ht; i++)
		{
			obj.levelTraversal(root, i);
			if(obj.local_max > obj.global_max)
			{
				obj.global_max = obj.local_max;
				obj.level = i-1;
				obj.local_max = 0;
			}
		}
		
		System.out.println("Level " + obj.level + " has maximum number of nodes");
	}
	
	public void levelTraversal(Node root,int i)
	{
		if(root == null)
			return;
		if(i == 1)
		{
			local_max = local_max +1;
		}
		else
		{
			levelTraversal(root.left, i-1);
			levelTraversal(root.right, i-1);
			
		}
		
	}
	
	public int height(Node root)
	{
		if(root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		
		if(left > right)
			return (left + 1);
		else
			return (right + 1);
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
