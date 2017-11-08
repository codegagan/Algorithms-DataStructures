import java.io.*;

public class MSP
{
public static void main(String args[])throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the size of the array");
	int n = Integer.parseInt(br.readLine());
	int arr[] = new int[n];
	int a[] = new int[3];
	System.out.println("enter the elements");
	for(int i=0;i<n;i++)
		{
		arr[i] = Integer.parseInt(br.readLine());
		}
MSP obj = new MSP();
a=obj.max_sum(arr,0,n-1);	
System.out.println(a[0]+ " " + a[1] + " " + a[2]);
	}

public int[] max_sum(int arr[],int l,int h)
	{
	int a[] = new int[3];
	int b[] = new int[3];
	int c[] = new int[3];
	int d[] = new int[3];
	int mid = 0 ;
	
	if(l==h)
		{
		d[0]=l;
		d[1]=h;
		d[2]=arr[l];
		//System.out.println(d[0]+ " " + d[1] + " " + d[2] + "H");
		return d;	
		}
	else
		{
		mid = (h + l)/2;
		mid = (int)Math.floor(mid);
		//System.out.println(h);
		}
 
	a = max_sum(arr,l,mid);
	b = max_sum(arr,mid+1,h);
	c = mid_sum(arr,l,mid,h);
	//System.out.println(c[0]+ " " + c[1] + " " + c[2] + "d");

	if(a[2] >= b[2] && a[2]>=c[2] )
		{
		d[0]=a[0];
		d[1]=a[1];
		d[2]=a[2];
		//System.out.println(d[0]+ " " + d[1] + " " + d[2] + "a");
		}

	else if(b[2] >= a[2] && b[2]>=c[2] )
		{
		d[0]=b[0];
		d[1]=b[1];
		d[2]=b[2];
		//System.out.println(d[0]+ " " + d[1] + " " + d[2] + "b");
		}

	else 	
		{
		d[0]=c[0];
		d[1]=c[1];
		d[2]=c[2];
		//System.out.println(d[0]+ " " + d[1] + " " + d[2] + "c");
		}
	

	return d;
	}

public int[] mid_sum(int arr[],int l,int mid,int h)
	{
	int left = 0;
	int sum_left=-1000;
	int sum =0;
	int a[] = new int[3];

	for(int i=mid;i>=l;i--)
		{
		//System.out.println(i);
		sum = sum + arr[i];
		if(sum > sum_left)
			{
			sum_left = sum;
			left =i;
			}
		}

	int right = 0;
	int sum_right = -1000;	
	sum =0;
	
	for(int i=mid+1;i<=h;i++)
		{
		
		sum = sum + arr[i];
		//System.out.println(sum);
		if(sum > sum_right)
			{
			
			sum_right = sum;
			right =i;
			}
		}
	
	a[0]=left;
	a[1]=right;
	a[2]=sum_left + sum_right;
	
	return a;	
	}
}
