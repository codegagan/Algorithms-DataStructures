import java.io.*;

public class A{
	int data;
	A left;
	A right;
	int left_max;
	int right_max;
	
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
			System.out.println("Input element into BST or type quit");
			
			String str = br.readLine();
			
			if(str.equalsIgnoreCase("quit"))
				break;
			else
				root = obj.createBST(root, Integer.parseInt(str));
		}
		
		int temp = 0;
		//int right = 0;
		
		obj.getMaxLeftRight(root,temp);
		
		System.out.println(obj.left_max + " " + obj.right_max);
		
		for(int i = obj.left_max;i<= obj.right_max;)
		{
			System.out.println();
			obj.Inorder(root,i,0);
			System.out.println();
			obj.PostOrder(root,i+1,0);
			i = i+2;
		}
		
		
	}
	
	public void Inorder(A root,int i,int temp)
	{
		if(root == null)
			return;
		
		if(temp == i)
			System.out.print(root.data + " ");
		
		Inorder(root.left,i, temp-1);
		Inorder(root.right,i, temp+1);
	}
	
	public void PostOrder(A root,int i,int temp)
	{
		if(root == null)
			return;
		
		
		PostOrder(root.left,i, temp-1);
		PostOrder(root.right,i, temp+1);
		
		if(temp == i)
			System.out.print(root.data + " ");
	}
	
	public A createBST(A root, int data)
	{
		if (root == null)
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
	
	public void getMaxLeftRight(A root,int temp)
	{
		if(root == null)
			return;
		
		if(temp < left_max)
			left_max = temp;
		
		if(temp > right_max)
			right_max = temp;
		
		getMaxLeftRight(root.left, temp-1);
		getMaxLeftRight(root.right, temp+1);
	}
}
