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

class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A obj = new A();
		Node root = null;
		while(true)
		{
			System.out.println("Input Node or type quit to exit");
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
		System.out.println("Input data whose distance to closest leaf needs to find");
		int temp = Integer.parseInt(br.readLine());
		int height = obj.find_distance(root,temp);
		
		System.out.println("Final Output: " + height);
		}
	}
	
	public int find_distance(Node root, int temp)
	{
		if(root == null)
			return 0;
		
		if(root.data == temp)
			return (1 + dist(root));
		
		int left = find_distance(root.left, temp);
		int right = find_distance(root.right, temp);
		//System.out.println("Left " + left);
		//System.out.println("Right " + left);
		
		return (left < right) ? left+1 : right+1;
	}
	
	public int dist(Node root)
	{
		if(root == null)
			return 0;
		int left = dist(root.left);
		int right = dist(root.right);
		//System.out.println("Left2 " + left);
		//System.out.println("Right2 " + left);
		
		return (left < right) ? left+1 : right+1;
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
