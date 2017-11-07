import java.io.*;

public class A{
	int data;
	A pointer;
	
	public A()
	{}
	
	public A(int data)
	{
		this.data = data;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A root1 = null;
		A root2 = null;
		A obj = new A();
		
		while(true)
		{
			System.out.println("Input List1 data or type quit");
			String str = br.readLine();
			if(str.equalsIgnoreCase("quit"))
				break;
			
			else
			{
				root1 = obj.createList(root1, Integer.parseInt(str));
				
			}
		}
		
		while(true)
		{
			System.out.println("Input List2 data or type quit");
			String str = br.readLine();
			if(str.equalsIgnoreCase("quit"))
				break;
			
			else
			{
				root2 = obj.createList(root2, Integer.parseInt(str));
				
			}
		}
		
		/*while(root1 != null)
		{
			System.out.print(root1.data + " ");
			root1 = root1.pointer;
		}
		System.out.println();
		while(root2 != null)
		{
			System.out.print(root2.data + " ");
			root2 = root2.pointer;
		}*/
		
		A new_list = obj.findIntersection(root1, root2);
		System.out.println();
		while(new_list != null)
		{
			System.out.print(new_list.data + " ");
			new_list = new_list.pointer;
		}
	}
	
	public A findIntersection(A root1, A root2)
	{
		A new_list = null;
		A return_list = null;
		
		while(root1 != null && root2 != null)
		{
			
			
			if(root1.data == root2.data)
			{
				//System.out.println(root1.data);
				if(new_list == null)
				{
					new_list = (new A(root1.data));
					return_list = new_list;
				}
				else
				{
					while(new_list.pointer != null)
					{
						new_list = new_list.pointer;
					}
					new_list.pointer = (new A(root1.data));
					//new_list = return_list;
				}
				root1 = root1.pointer;
				root2 = root2.pointer;
			}
			
			else if(root1.data < root2.data)
					root1 = root1.pointer;
				
			else if(root1.data > root2.data)
					root2 = root2.pointer;
			
		}
		
		return return_list;
		
	}
	
	public A createList(A root, int data)
	{
		if(root == null)
			return (new A(data));
		
		else
		{
			root.pointer = createList(root.pointer, data);
		}
		return root;
	}
}
