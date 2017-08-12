import java.io.*;

public class In_order
{


int data;
In_order left;
In_order right;

static int level_left = 100;
static int level_right = 0;


public void tree(In_order new_root, int data)
{
if(new_root == null)
	{
	new_root.data= data;
	new_root.left = null;
	new_root.right = null;
	}

else	
	{
	if(data < new_root.data && new_root.left != null)
		{
		tree(new_root.left,data);
		}

	else if (data < new_root.data && new_root.left == null)
		{
		In_order new_left = new In_order();
		new_left.data = data;
		new_left.left = null;
		new_left.right = null;
		new_root.left = new_left;
		}
	
	else if (data > new_root.data && new_root.right != null)
		{
		tree(new_root.right,data);
		}

	else if (data > new_root.data && new_root.right == null)
		{
		In_order new_right = new In_order();
		new_right.data = data;
		new_right.left = null;
		new_right.right = null;
		new_root.right = new_right;
		}

	else if (data == new_root.data)
		{
		System.out.println("node already exists");
		}
	}
}

public void inorder(In_order node, int var)
	{
	if (var < level_left)
	level_left = var;

	else if(var > level_right)
	level_right = var;	

	if(node.left != null)
		{
		inorder(node.left, var-1);
		}
	
	//System.out.println(node.data + " ");
	
	if(node.right != null)
		{
		inorder(node.right, var+1);
		}
	}

public void vertical(In_order node, int i, int var)
	{
	
	if (var == i)
	System.out.println(node.data + " ");

	if(node.left != null)
		{
		vertical(node.left,i, var-1);
		}
	
	//System.out.println(node.data + " ");
	
	if(node.right != null)
		{
		vertical(node.right,i, var+1);
		}
	}


public static void main(String args[])throws IOException
	{
	In_order root ;
	In_order obj = new In_order();
	
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter total number of nodes");
	int total = Integer.parseInt(br.readLine());
	
	System.out.println("Enter root node");
	root = new In_order();
	root.data= Integer.parseInt(br.readLine());
	root.left = null;
	root.right = null;
	
	System.out.println("Enter other nodes");
	for (int i=1;i<=(total -1) ; i++)
		{
		obj.data = Integer.parseInt(br.readLine());
		obj.tree(root,obj.data);
		}
	
	
	int var = 0;
	obj.inorder(root, var);
	System.out.println("\n" + "Level of left edge is " + level_left);
	System.out.println("\n" + "Level of right edge is " + level_right);
	
	
	for (int i=level_left; i<=level_right; i++)
	{
	var =0;
	System.out.println("\n");
	obj.vertical(root,i,var);
	}
	}
}
