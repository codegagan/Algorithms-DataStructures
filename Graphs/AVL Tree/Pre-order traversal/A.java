import java.io.*;

class Node{
	Node left = null;
	Node right = null;
	int key = 0;
	int height = 0;
	public Node(int key)
	{
		this.key = key;
		height = 1;
	}
}


public class A{
	public Node create_tree(Node root,int key)
	{
		if(root == null)
			return (new Node(key));
		
		else if(key >= root.key)
		{
			root.right = create_tree(root.right,key);
		}
		
		else if(key < root.key)
		{
			root.left = create_tree(root.left,key);
		}
		return root;
	}
	
	public static void main(String args[])throws IOException
	{
		A obj = new A();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input size of tree");
		int size = Integer.parseInt(br.readLine());
		
		System.out.println("Input root's value");
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		System.out.println("Enter rest of the values");
		
		for(int i=1;i<size;i++)
		{
			obj.create_tree(root,Integer.parseInt(br.readLine()));
		}
		System.out.println("Printing Pre-order traversal");
		obj.traversal(root);
	}
	
	public void traversal(Node root)
	{
		System.out.println(root.key);
		
		if(root.left != null)
			traversal(root.left);
	
		if(root.right != null)
			traversal(root.right);
	}
}
