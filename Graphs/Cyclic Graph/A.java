import java.io.*;
import java.util.*;
//import java.util.LinkedList.*;

public class A{
	int data;
	A pointer;
	int visited[];
	int st;
	public A()
	{}
	
	public A(int data)
	{
		this.data = data;
		pointer = null;
	}
	
	public static void main(String args[])throws IOException
	{
		System.out.println("Creating a cyclic graph");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input maximum number of Vertices in the graph");
		int vertices = Integer.parseInt(br.readLine());
		
		LinkedList<A> obj[] = new LinkedList[vertices];
		
		while(true)
		{
			System.out.println("Input an edge or type quit to terminate graph creation process");
			String str1 = br.readLine();
			if(str1.equalsIgnoreCase("quit"))
				break;
			else
			{
				int a = Integer.parseInt(str1);
				int b = Integer.parseInt(br.readLine());
				
				if(obj[a] == null)
				{
					obj[a] = new LinkedList<A>();
					obj[a].add(new A(b));
				}
				
				else{
					obj[a].add(new A(b));
				}
			}
		}
		
		A a = new A();
		//a.bfs(obj);
		System.out.println("Enter the node to start traversal with");
		a.st = Integer.parseInt(br.readLine());
		a.visited = new int[vertices];
		System.out.println(a.st);
		a.visited[a.st] = 1;
		a.dfs(a.st,obj);
		
		/*System.out.println("Traversing through the graph");
		
		for(int i=0;i<vertices;i++)
		{
			System.out.println("For Vertex " + i + " ");
			if(obj[i] != null)
			{
				Iterator<A> itr = obj[i].iterator();
				
				while(itr.hasNext())
				{
					A a = itr.next();
					System.out.print(a.data + " ");
				}
			}
		}*/
		
	}
	
	/*public void bfs(LinkedList<A> obj[])
	{
		int arr_size = obj.length;
		int visited[] = new int[arr_size];
		Queue<Integer> al = new LinkedList<Integer>();
		al.add(2); 																																	//Starting Node
		System.out.print(2 + " ");
		
		while(!al.isEmpty())
		{
			int temp = al.poll();
			Iterator<A> itr = obj[temp].iterator();
			visited[temp] = 1;
			while(itr.hasNext())
				{
					A a = itr.next();
					if(visited[a.data] == 0)
					{
						al.add(a.data);
						System.out.print(a.data + " ");
						visited[a.data] = 1;
					
					}
				}
		}
	}*/
	
	public void dfs(int temp,LinkedList<A> obj[])
	{
		if(obj[temp] != null)
		{
		Iterator<A> itr = obj[temp].iterator();
		
		while(itr.hasNext())
		{
			A a = itr.next();
			if(visited[a.data] != 1)
			{
				System.out.println(a.data);
				visited[a.data] = 1;
				dfs(a.data,obj);
			}
				
		}
	}
	}
}
