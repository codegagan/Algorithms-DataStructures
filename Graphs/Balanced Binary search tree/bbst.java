import java.io.*;

public class bbst
{
int value;
bbst left;
bbst right;

public static void main(String args[])throws Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the size of the array");
	int n = Integer.parseInt(br.readLine());
	System.out.println("Enter the elements of the sorted array");
	int arr[] = new int[n];
	bbst root = new bbst();

	for(int i=0;i<n;i++)
		{
		arr[i] = Integer.parseInt(br.readLine());		
		}
	int x = (n-1)/2;
	root.value = arr[x];
	root.left=null;
	root.right=null;
	
	bbst obj = new bbst();
	obj.recursion(root,arr,0,n-1);
	//System.out.println(root);
	obj.print(root);		
	}

public void print(bbst root)
	{
	if(root.left!=null)
	print(root.left);
	
	System.out.println(root.value);

	if(root.right!=null)
	print(root.right);
	
	
	}

public void recursion(bbst root,int arr[],int l,int h)
	{
	if(l>=h)
	return;
	
	else
		{
		int mid = (l+h)/2;
		System.out.println(root);
		tree(arr[mid],root);

		recursion(root,arr,l,mid);
		recursion(root,arr,mid+1,h);
		}
	}


public void tree(int element,bbst root)
	{
	if(root == null)
		{
		root = new bbst();
		root.value = element;
		root.left = null;
		root.right = null;
		//return root;
		}
	else{
	//System.out.println(root);
	bbst node = root;
	if(element < node.value && node.left != null)
		{
		tree(element,node.left);
		}
	else if(element < node.value && node.left == null)
		{
		bbst new_node = new bbst();
		new_node.value = element;
		new_node.left = null;
		new_node.right = null;
		node.left = new_node;
		}
	else if(element > node.value && node.right != null)
		{
		tree(element,node.right);
		}
	else if(element > node.value && node.right == null)
		{
		bbst new_node = new bbst();
		new_node.value = element;
		new_node.left = null;
		new_node.right = null;
		node.right = new_node;
		}
	}
	
	
	}
}
