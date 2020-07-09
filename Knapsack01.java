package eclipseIDE;
/*Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 *  Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
 *  You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * 
 */
/*
 * 
 */


public class Knapsack01 {
	public static int knapsack(int[]w,int[]v,int n,int W)
	{
		// creation of matrix
		int[][]t=new int[n+1][W+1];
		//initialization of first row
		
		/*
		 * this step is called the initialization step.
		 *  
		 */
		for(int j=0;j<W+1;j++)
		{
			t[0][j]=0;
		}
		for(int i=0;i<n+1;i++)
		{
			t[i][0]=0;
		}
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<W+1;j++)
			{
				if(w[i-1]<=j)
				{
					t[i][j]=Math.max(v[i-1]+t[i-1][j-w[i-1]], 0+t[i-1][j-0]);
					
				}
				else {
					t[i][j]=t[i-1][j-0];
				}
			}
		}
		
		return t[n][W];
	}

	public static void main(String[] args) {
		int[]w= {1,2,3,30,0,12};
		int[]v= {10,20,30,30,12,54};
		int n=w.length;
		int W=10;
		System.out.println(knapsack(w,v,n,W));

	}

}
