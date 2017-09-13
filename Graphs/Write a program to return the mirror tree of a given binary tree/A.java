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
		A root = null;
		A obj = new A();
		
		while(true)
		{
			System.out.println("Input data or type quit exit");
			String str = br.readLine();
		
			if(str.equalsIgnoreCase("quit"))
				break;
			else
			{
				root = obj.createTree(root, Integer.parseInt(str));
			}
		}
		
		obj.InOrderTraversal(root);
		System.out.println();
		System.out.println("Converting Binary tree to a Mirror tree");
		root = obj.convertMirror(root);
		System.out.println();
		System.out.println("Printing Mirror tree");
		obj.InOrderTraversal(root);
		
	}
	
	public A createTree(A root,int data)
	{
		if(root == null)
			return (new A(data));
		
		else
		{
			if(data <= root.data)
				root.left = createTree(root.left, data);
			
			else
				root.right = createTree(root.right, data);
		}
		return root;
	}
	
	public void InOrderTraversal(A root)
	{
		if(root == null)
			return;
		System.out.print(root.data + " ");
		InOrderTraversal(root.left);
		InOrderTraversal(root.right);
	}
	
	public A convertMirror(A root)
	{
		if(root == null)
			return root;
		
		else{
			A temp = root.left;
			root.left = root.right;
			root.right = temp;
			
			root.left = convertMirror(root.left);
			root.right = convertMirror(root.right);
		}
		return root;
	}
}
