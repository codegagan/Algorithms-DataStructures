import java.io.*;

public class A{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input maximum number of sections");
		int sections = Integer.parseInt(br.readLine());
		
		A obj = new A();
		System.out.println((int)(Math.pow(obj.maximum_buildings(sections),2)));
	}
	
	public int maximum_buildings(int sections)
	{
		if(sections < 1)
			return 1;
		int max = maximum_buildings(sections - 1) + maximum_buildings(sections - 2);
		
		return max;
	}
}
