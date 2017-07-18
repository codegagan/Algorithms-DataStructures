import java.io.*;
import java.util.*;

class Node{
	int data;
	public Node(int data)
	{
		this.data = data;
	}
}

public class Graph{
	LinkedList<Node> ld[];
	int temp;
	
	public Graph(int v)
	{
		ld = new LinkedList[v];
		
		for(int i=0;i<v;i++)
		{
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
		ld[b].add(new Node(a));
	}
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the maximum number of vertices in the graph");
		int V = Integer.parseInt(br.readLine());
		Graph obj = new Graph(V);
		
		System.out.println("Enter an edge or type quit to exit");
		String str = br.readLine();
		
		while(!str.equalsIgnoreCase("quit")){
			
			int b = Integer.parseInt(br.readLine());
			
			obj.addEdge(Integer.parseInt(str),b);
			System.out.println("Enter an edge or type quit to exit");
			str = br.readLine();
		}
		
		
		System.out.println("Finding Bridges");
		obj.findBridges(V);
	}
	
	public void findBridges(int vertices)
	{
		boolean visited[] = new boolean[vertices];
		int parent[] = new int[vertices];
		int low[] = new int[vertices];
		int disc[] = new int[vertices];
		
		for(int i=0;i<vertices;i++)
		{
			if(visited[i] != true)
			{
				bridgeUtil(i,visited,parent,low,disc);
			}
		}
	}
	
	public int min(int a,int b)
	{
		return (a<b)?a:b;
	}
	
	public void bridgeUtil(int u,boolean visited[],int parent[],int low[],int disc[])
	{
		low[u] = disc[u] = ++temp;
		visited[u] = true;
		
		LinkedList<Node> l = ld[u];
		Iterator<Node> itr = l.iterator();
		while(itr.hasNext())
		{
			int v = itr.next().data;
			
			if(visited[v] != true)
			{
				parent[v] = u;
				bridgeUtil(v,visited,parent,low,disc);
				
				low[u] = min(low[u], low[v]);
				
				if(low[v] > disc[u])
					System.out.println(u + "  " + v);
				
				
			}else if(parent[u] != v)
			{
				low[u] = min(low[u],disc[v]);
			}
		}
	}
}
