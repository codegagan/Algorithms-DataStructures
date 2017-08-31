import java.io.*;

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
			{
				break;
			}
			root = obj.createBst(root,Integer.parseInt(str));
		}
		
		int ht = obj.height(root);
		//System.out.println(ht);
		boolean flag = false;
		for(int i =1 ;i<=ht; i++)
		{
			obj.levelOrder(root, i, flag);
			flag = !flag;
			
		}
		
	}
	
	public void levelOrder(Node root, int i, boolean flag)
	{
		if(root == null)
			return;
		
		if(i == 1)
			System.out.print(root.data + " ");
		else
		{
				if(flag)
				{
					levelOrder(root.right, i-1, flag);
					levelOrder(root.left, i-1, flag);
				}
				else
				{
					levelOrder(root.left, i-1, flag);
					levelOrder(root.right, i-1, flag);
				}
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
			return (right +1);
		
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

