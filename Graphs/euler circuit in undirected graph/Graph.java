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
	boolean visited[][];
	LinkedList<Node> ld[];
	int source;
	LinkedList result;
	int flag;
	
	public Graph(int V)
	{
		visited = new boolean[V][V];
		ld = new LinkedList[V];
		result = new LinkedList();
		flag = 2;
		for(int i=0;i<V;i++)
		{
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
		ld[b].add(new Node(a));
	}
	
	public void printEulerTour(int s)
	{
		LinkedList<Node> l = ld[s];
		Iterator<Node> itr = l.iterator();
		
		while(itr.hasNext())
		{
			Node n = itr.next();
			if(visited[s][n.data] != true)
			{
				visited[s][n.data] = true;
				visited[n.data][s] = true;
				
				result.add(n.data);
				
				printEulerTour(n.data);
			}
		}
		
		if(flag == 2)
			if(s != source)
				flag = 1;
			else
				flag = 0;
	}
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the maximum number of vertices");
		int V = Integer.parseInt(br.readLine());
		Graph obj = new Graph(V);
		
		System.out.println("Input an edge or type quit to exit");
		
		String str = br.readLine();
		
		while(!str.equalsIgnoreCase("quit"))
		{
			int a = Integer.parseInt(str);
			int b = Integer.parseInt(br.readLine());
			
			obj.addEdge(a,b);
			
			System.out.println("Input an edge or type quit to exit");
			
			str = br.readLine();
		}
		
		System.out.println("Input the source node");
		obj.source = Integer.parseInt(br.readLine());
		(obj.result).add(obj.source);
		obj.printEulerTour(obj.source);
		
		if(obj.flag==0)
		{
			System.out.println("Euler tour exists");
			//System.out.println(obj.source);
			Iterator itr = obj.result.iterator();
			while(itr.hasNext())
			{
				System.out.print("->" + itr.next());
			}
		}
		else
			System.out.println("Euler Tour does not exist");
	}
	
	
}
