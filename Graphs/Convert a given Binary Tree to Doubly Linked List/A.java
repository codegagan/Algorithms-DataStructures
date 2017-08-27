import java.io.*;

public class A{
	int data;
	A left;
	A right;
	
	public A()
	{}
	
	public A(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A obj = new A();
		A root = null;
		while(true)
		{
			System.out.println("Input element into BST or type quit");
			
			String str = br.readLine();
			
			if(str.equalsIgnoreCase("quit"))
				break;
			else
				root = obj.createBST(root, Integer.parseInt(str));
				
		}
		
		//System.out.println(root.data);
		A new_root = obj.convertTree2List(root);
		
		while(new_root.left != null)
		{
			//System.out.println(new_root.data);
			new_root = new_root.left;
		}
		
		while(new_root != null)
		{
			System.out.println(new_root.data);
			new_root = new_root.right;
		}
		
		
	}
	
	public A convertTree2List(A root)
	{
		if(root == null)
			return root;
		
		if(root.left != null)
		{
			A left_sub = convertTree2List(root.left);
			
			for(; left_sub.right != null; left_sub = left_sub.right);
			
			left_sub.right = root;
			root.left = left_sub;
		}
		
		if(root.right != null)
		{
			A right_sub = convertTree2List(root.right);
			
			for(; right_sub.left != null; right_sub = right_sub.left);
			
			right_sub.left = root;
			root.right = right_sub;
		}
		
		return root;
	}
	
	public A createBST(A root, int data)
	{
		if(root == null)
			return (new A(data));
		
		else
		{
			if(data < root.data)
				root.left = createBST(root.left, data);
			
			if(data > root.data)
				root.right = createBST(root.right, data);
		}
		return root;
	}
}
