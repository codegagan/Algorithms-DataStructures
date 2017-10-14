import java.io.*;
import java.util.*;

class Node{
	int data;
	
	public Node(int data)
	{
		this.data = data;
	}
}

public class A{
	
	int edgeConnected[];
	boolean visited[];
	
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the maximum number of vertices");
		int vertices = Integer.parseInt(br.readLine());
		
		LinkedList<Node> ld[] = new LinkedList[vertices];
		
		while(true)
		{
			System.out.println("Input the edges or type quit to exit");
			String str1 = br.readLine();
			
			if(str1.equalsIgnoreCase("quit"))
				break;
			else
			{																		// Formation of Undirected graph.
				int a = Integer.parseInt(str1);
				int b = Integer.parseInt(br.readLine());
				
				if(ld[a] == null)
				{
					ld[a] = new LinkedList<Node>();
					ld[a].add(new Node(b));
					
					if(ld[b] == null)
					{
							ld[b] = new LinkedList<Node>();
							ld[b].add(new Node(a));
					}
					else
						ld[b].add(new Node(a));
				}
				else
				{
					ld[a].add(new Node(b));
					if(ld[b] == null)
					{
							ld[b] = new LinkedList<Node>();
							ld[b].add(new Node(a));
					}
					else
						ld[b].add(new Node(a));
				}
			}
		}
		
		A obj = new A();
		
		obj.visited = new boolean[vertices];
		obj.edgeConnected = new int[vertices];
		
		System.out.println("Input the node that you want to start traversing with");
		int firstVal = Integer.parseInt(br.readLine());
		System.out.println(firstVal);
		obj.visited[firstVal] = true;
		obj.dfs(firstVal,ld);
		
	}
	
	public void dfs(int val, LinkedList<Node> ld[])
	{
		if(ld[val] != null)
		{
		Iterator<Node> itr = ld[val].iterator();
		
		while(itr.hasNext())
		{
			Node n = itr.next();
			
			if(visited[n.data] != true)
			{
				System.out.println(n.data);
				visited[n.data] = true;
				dfs(n.data,ld);
			}
		}
		}
		
	}
}
