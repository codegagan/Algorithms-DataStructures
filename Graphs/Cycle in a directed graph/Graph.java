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
	int globalVal;
	int flag1;
	int flag2;
	public Graph(int V)
	{
		globalVal = -1;
		flag1 = 0;
		flag2 = 0;
		ld = new LinkedList[V];
		
		for(int i=0;i<V;i++)
		{
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
	}
	
	public void cycleUtil(int V)
	{
		int visited[] = new int[V];
		LinkedList<Integer> result = new LinkedList<Integer>();
		int temp =0;
		for(int i=0;i<V;i++)
		{
			visited[i] = -1;
		}
		
		for(int i=0;i<V;i++)
		{
			if(visited[i] == -1)
			{
				obtainCycle(i,temp,visited,result);
				temp = temp + 1;
			}
			
		}
		
		Iterator<Integer> i = result.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}
	
	public void obtainCycle(int u,int temp,int visited[],LinkedList<Integer> result)
	{
		visited[u] = temp;
		
		LinkedList<Node> l = ld[u];
		
		Iterator<Node> itr = l.iterator();
		
		while(itr.hasNext() && flag1==0)
		{
			Node n = itr.next();
			int v = n.data;
			
			if(visited[v] == -1)
			{
				obtainCycle(v,temp,visited,result);
				
				if(flag2 == 0 )
				{
					result.add(v);
					if(globalVal == v)
						flag2 = 1;
				}
			}
			else if(visited[v] == temp)
			{
				flag1 = 1;
				globalVal = v;
				result.add(v);
			}
		}
	}
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input the maximum number of vertices");
		
		int V = Integer.parseInt(br.readLine());
		
		Graph obj = new Graph(V);
		
		System.out.println("Input an edge or type quit to exit");
		
		String str = br.readLine();
		
		while(!str.equals("quit"))
		{
			int a = Integer.parseInt(str);
			int b = Integer.parseInt(br.readLine());
			
			obj.addEdge(a,b);
			
			System.out.println("Input an edge or type quit to exit");
		
			str = br.readLine();
		}
		
		obj.cycleUtil(V);
	}
}
