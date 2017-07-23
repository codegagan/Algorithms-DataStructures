import java.io.*;
import java.util.*;

public class A{
	int data;
	A left;
	A right;
	
	public A()
	{}
	
	public A(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.println("Input root");
		//A root = new A(Integer.parseInt(br.readLine()));
		A obj = new A();
		A root = null;
		
		while(true)
		{
			System.out.println("Input data or type quit to exit");
			String str = br.readLine();
		
			if(str.equalsIgnoreCase("quit"))
				break;
			else
				root = obj.make_bst(root, Integer.parseInt(str));		
		}
		
		int height = obj.height_tree(root);
		System.out.println("height " + (height));
		ArrayList<Integer> lis = obj.convert_bst_to_list(root);
			
		while(true)
		{
			System.out.println("Input two nodes to find common ancestor of or type quit to exit");
			String str1 = br.readLine();
			String str2 = br.readLine();
			int a = Integer.parseInt(str1);
			int b = Integer.parseInt(str2);
		
			//System.out.println(a/b);
			if(str1.equalsIgnoreCase("quit"))
				break;
			else
			{
				int arr1[] = new int[lis.size()];
				int arr2[] = new int[lis.size()];
				
				int i = 0;
				int index = lis.indexOf(a);
				while(index >= 0)
				{
					arr1[i] = lis.get(index);
					System.out.println("a " + arr1[i]);
					if(index%2 != 0)
						index = index/2;
					else
						index = (index/2) - 1;
					
					i = i+1;	
				}
				
				i = 0;
				index = lis.indexOf(b);
				while(index >= 0)
				{
					arr2[i] = lis.get(index);
					System.out.println("b " + arr2[i]);
					if(index%2 != 0)
						index = index/2;
					else
						index = (index/2) - 1;
					
					i = i+1;	
				}
				int flag = 0;
				for(int j=0;j<lis.size();j++)
				{
					for(int k= 0;k<lis.size();k++)
					{
						if(arr1[j] == arr2[k])
						{
							System.out.println("Common ancestor is " + arr1[j]);
							flag = 1;
							break;
						}
					}
					if(flag == 1)
						break;
				}
			}	
		}
	}
	
	public ArrayList<Integer> convert_bst_to_list(A root)
	{
		if(root == null)
			return null;
		
		Queue<A> q = new LinkedList<A>();
		q.add(root);
		ArrayList<Integer> lis = new ArrayList<Integer>();
		
		while(!q.isEmpty())
		{
			A temp_node = q.poll();
			
			if(temp_node == null)
			{
				//System.out.println("null");
				lis.add(0);
			}
			else
			{
			//System.out.println(temp_node.data);
			lis.add(temp_node.data);
			
			if(temp_node.left != null)
				q.add(temp_node.left);
			else
				q.add(null);
			
			if(temp_node.right != null)
				q.add(temp_node.right);
			else
				q.add(null);
			}	
		}
		
		return lis;
	}
	
	public int height_tree(A root)
	{
		if (root == null)
			return 0;
		
		int left = height_tree(root.left);
		int right = height_tree(root.right);
		
		if(left >= right)
			return left + 1;
		else
			return right + 1;
	}
	
	public A make_bst(A node,int data)
	{
		if(node == null)
			return (new A(data));
		
		if(data <= node.data)
			node.left = make_bst(node.left,data);
		
		else if(data > node.data)
			node.right = make_bst(node.right, data);
		
		return node;
	}
}
