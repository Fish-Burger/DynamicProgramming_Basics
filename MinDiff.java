package eclipseIDE;

//Q) Partition a set into two subsets such that the difference of subset sums is minimum
//Note : you have to include all the elements i.e. no elements can be excluded in the 2 different subsets whose min diff is to be found out

public class MinDiff {
	public static int sack(int[]a,int n,int sum)
	{
		boolean[][] t=new boolean[n+1][sum+1];
		for(int i=0;i<sum+1;i++)
		{
			t[0][i]=false;
		}
		for(int i=0;i<n+1;i++)
		{
			t[i][0]=true;
		}
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(a[i-1]<=j)
				{
					t[i][j]=t[i-1][j-a[i-1]] || t[i-1][j];
				}
				else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		int mindiff=Integer.MAX_VALUE;
		for(int i=0;i<=(sum)/2;i++)
		{
			if(t[n][i]==true)
			{
				mindiff=Math.min(mindiff,sum-(2*i));
			}
		}
		return mindiff;
	}

	public static void main(String[] args) {
		int[]a= {1,6,11,5};
		int n=a.length;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
		}
		System.out.println(MinDiff.sack(a,n,sum));
		//Returns 1 because the min diff is occuring in the subsets <11,1> and <6,5>
		


	}

}
