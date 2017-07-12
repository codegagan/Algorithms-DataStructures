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
	public Node rotate_right(Node node)
	{
		Node y = node.left;
		node.left = y.right;
		y.right = node;
		
		node.height = max(height(node.left),height(node.right)) + 1;
		y.height = max(height(y.left),height(y.right)) + 1;
		
		return y;
	}
	
	public Node rotate_left(Node node)
	{
		Node y = node.right;
		node.right = y.left;
		y.left = node;
		
		node.height = max(height(node.left),height(node.right)) + 1;
		y.height = max(height(y.left),height(y.right)) + 1;
		
		return y;
	}
	
	public int height(Node n)
	{
		if(n == null)
			return 0;
		else
			return n.height;
	}
	
	public int max(int a,int b)
	{
		if(a >= b)
			return a;
		else
			return b;
	}
	
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
		
		root.height = max(height(root.left),height(root.right)) + 1;
		
		int balance = 0;
		
		if(root != null)
			balance = height(root.left) - height(root.right);
		
		
		if(balance > 1 && key < root.left.key)
		{
		return rotate_right(root);	
		}
		
		else if(balance > 1 && key > root.left.key)
		{
		root.left = rotate_left(root.left);	
		return rotate_right(root);
		}
		else if(balance < -1 && key > root.right.key)
		{
			return rotate_left(root);
		}
		
		else if(balance < -1 && key < root.right.key)
		{
			root.right = rotate_right(root.right);
			return rotate_left(root);
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
			root = obj.create_tree(root,Integer.parseInt(br.readLine()));
		}
		System.out.println("Printing Pre-order traversal");
		obj.traversal(root);
		
		while(true)
		{
			System.out.println("Enter the data of node, you want to delete of write exit to come out of deletion loop");
			String str = br.readLine();
			
			if(str.equals("exit"))
			{
				obj.traversal(root);
				break;
			}
			else{
				Node new_root = obj.deletion(root,Integer.parseInt(str));
				obj.traversal(new_root);
			}
		}
	}
	
	public Node deletion(Node root, int key)
	{
		if(root == null)
			return root;
		
		if(key > root.key)
		{
			root.right = deletion(root.right,key);
		}
		
		else if(key < root.key)
		{
			root.left = deletion(root.left,key);
		}
		
		else if(key == root.key)
		{
			if(root.left == null && root.right == null)
			{
				root = null;
			}
			else if(root.left != null && root.right == null)
			{
				root = root.left;
			}
			else if(root.left == null && root.right != null)
			{
				root = root.right;
			}
			else if(root.left != null && root.right != null)
			{
				Node right_left_node = find_right_min_node(root.right);
				root.key = right_left_node.key;
				
				root.right = deletion(root.right,right_left_node.key);
			}
		}
		
		if(root == null)
			return root;
		
		root.height = max(height(root.left),height(root.right)) + 1;
		
		int balance = 0;
		
		
		balance = height(root.left) - height(root.right);
		
		if(balance > 1 && getBalance(root.left) >= 0)
			return rotate_right(root);
		
		else if(balance > 1 && getBalance(root.left) < 0)
		{
			root.left = rotate_left(root.left);
			return rotate_right(root);
		}
		
		else if(balance < -1 && getBalance(root.right) <=0)
			return rotate_left(root);
		
		else if(balance < -1 && getBalance(root.right) > 0)
		{
			root.right = rotate_right(root.right);
			return rotate_left(root);
		}
		
		return root;
		
		
	}
	
	public int getBalance(Node node)
	{
		if(node == null)
			return 0;
		else
		{
			return (height(node.left) - height(node.right));
		}
	}
	
	public Node find_right_min_node(Node node)
	{
		while(node.left != null)
		{
			node = node.left;
		}
		return node;
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
