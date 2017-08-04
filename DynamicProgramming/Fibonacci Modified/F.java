import java.io.*;
import java.math.*;

public class F{
	public static void main(String args[])throws IOException
	{
		//BigInteger b = new BigInteger("10");
		//BigInteger b2 = new BigInteger("20");
		//System.out.println(b.multiply(b2));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr[] = br.readLine().split("\\s");
		BigInteger bi[] = new BigInteger[Integer.parseInt(arr[2])];
		bi[0] = new BigInteger(arr[0]);
		bi[1] = new BigInteger(arr[1]);
		for(int i=2;i<Integer.parseInt(arr[2]);i++)
		{
			bi[i] = (bi[i-1].multiply(bi[i-1])).add(bi[i-2]);
		}
		System.out.println(bi[Integer.parseInt(arr[2])-1]);
	}
}
