import java.io.*;

public class A{
	
	int dp[][] = null;
	
		public A(int len1,int len2)
		{
			dp = new int[len1][len2];
		}
		public static void main(String args[])throws IOException	
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter First String");
			String str1 = br.readLine();
			
			System.out.println("Enter Second String");
			String str2 = br.readLine();
			
			char first[] = str1.toCharArray();
			char second[] = str2.toCharArray();
			
			int len1 = first.length;
			int len2 = second.length;
				
			//System.out.println(first.length);
			//System.out.println(second.length);
			
			A obj = new A(len1,len2);
			
			for (int i=0;i<len1;i++)
				for(int j=0;j<len2;j++)
					obj.dp[i][j] = -1;
				
				
			System.out.println(obj.conversion(first,second,len1-1,len2-1));
		}
		
		public int conversion(char first[], char second[],int len1,int len2)
		{
			/*if(len1 == 0 )
				return len2;
			if(len2 == 0)
				return len1;*/
			
			/*if(len1 < 0 || len2 < 0)
				return 0;*/

			if(len1 <= 0)
				return len2;

			if(len2 <= 0)
				return len1;
			
			if(dp[len1][len2] != -1)
				return dp[len1][len2];
			
			if(first[len1] == second[len2])
				return dp[len1][len2] = conversion(first, second, len1-1, len2-1);
			
			else
				return dp[len1][len2] = 1 + min( conversion(first, second, len1, len2-1), conversion(first, second, len1-1, len2-1), conversion(first, second, len1-1, len2));
		}
		
		public int min(int a,int b,int c)
		{
			if (a<b && a<c)
				return a;
			else if (b<a && b<c)
				return b;
			else
				return c;
		}
}
