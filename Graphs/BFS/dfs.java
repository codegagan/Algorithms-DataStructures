import java.io.*;
import java.util.*;

public class dfs
{
int data;
dfs next;
public static void main(String args[])throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("Enter the size of the array");
	int n = Integer.parseInt(br.readLine());
	dfs arr[] = new dfs[n];
	StringTokenizer st;
	
	System.out.println("Input relation");
	
		while(true)
		{
		System.out.println("Enter 'X' to terminate else input the relation");
		String str = br.readLine();
	
		if(str.equals("X"))
		break;
	
		else
		{
		st = new StringTokenizer(str);
		
		int j = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dfs obj1 = new dfs();
		obj1.data = k;
		obj1.next = null;
		
		if(arr[j-1]==null)
			{
			arr[j-1]=obj1;
			} 
		
		else
			{
			dfs temp = arr[j-1];
			while(temp.next!=null)
				{
				temp=temp.next;
				}
			temp.next=obj1;
			}
		}
		}
	/*for(int i=0;i<n;i++)
		{
		while(arr[i]!=null)
			{
			System.out.print(arr[i].data + "");
			arr[i] = arr[i].next;
			}
		System.out.println();
		}*/

	boolean visited[] = new boolean[n];
	int queue[] = new int[n];
	queue[0]=1;
	System.out.print(1 + " ");
	visited[0]=true;
	dfs obj = new dfs();
	obj.bfs(visited,queue,arr,0,0,n);	
	}

public void bfs(boolean visited[],int queue[],dfs arr[],int x,int y,int n)
{
int var=0;

while(x<n)
{	
	for(int i=x;i<=y;i++)
		{
		//System.out.println(i + "trial");
		dfs temp = arr[queue[i]-1];
		
		while(temp != null)
			{
			if(visited[temp.data-1]==false)
			{
			System.out.print(temp.data + " ");
			
			var = var+1;
			//System.out.println(var + "trial");
			queue[y+var]=temp.data;	
			visited[temp.data-1]=true;
			}		
			temp = temp.next;
			}

		}
		
		x=y+1;
		y=y+var;
		var=0;
}
}
}
