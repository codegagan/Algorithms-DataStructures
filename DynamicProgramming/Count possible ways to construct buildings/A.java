import java.io.*;

public class A{
	long dp[];
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input maximum number of sections");
		int sections = Integer.parseInt(br.readLine());
		
		A obj = new A();
		obj.dp = new long[sections];
		for(int i=0;i<sections;i++)
			obj.dp[i] = -1;
		
		System.out.println((long)(Math.pow(obj.maximum_buildings(sections),2)));
	}
	
	public long maximum_buildings(int sections)
	{
		if(sections < 1)
			return 1;
		
		if(dp[sections-1] != -1)
			return dp[sections-1];
		
		long max = maximum_buildings(sections - 1) + maximum_buildings(sections - 2);
		
		return dp[sections -1] = max;
	}
}
