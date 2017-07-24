import java.io.*;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A obj = new A();
		Node root = null;
		
		while(true)
		{
			System.out.println("Input data or type quit to come out of loop");
			
			String str = br.readLine();
			if(str.equalsIgnoreCase("quit"))
				break;
			else
			{
				root = obj.createBST(root,Integer.parseInt(str));
			}
		}
		
		while(true)
		{
			System.out.println("Input two entries whose least common ancestor you want to find or type quit to exit");
			
			String str = br.readLine();
			if(str.equalsIgnoreCase("quit"))
				break;
			else
			{
				int a = Integer.parseInt(str);
				int b = Integer.parseInt(br.readLine());
				
				Node node = obj.LCA(root, a, b);
				if(node == null)
					System.out.println("Entries you mentioned are not present in the bst");
				else
					System.out.println(node.data);
			}
		}
	}
	
	public Node LCA(Node node, int a, int b)
	{
		if(node == null)
			return null;
		
		if(node.data == a || node.data == b)
			return node;
		
		Node left_lca = LCA(node.left, a , b);
		Node right_lca = LCA(node.right, a, b);
		
		if(left_lca != null && right_lca != null)
			return node;
		
		return (left_lca != null) ? left_lca : right_lca;
		
	}
	
	public Node createBST(Node root, int data)
	{
		if(root == null)
			return (new Node(data));
		
		if(data < root.data)
			root.left = createBST(root.left, data);
		
		if(data > root.data)
			root.right = createBST(root.right, data);
		
		return root;
	}
}
