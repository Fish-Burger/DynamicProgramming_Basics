package eclipseIDE; 
public class Knapsack01 {
	public static int knapsack(int[]w,int[]v,int n,int W)
	{
		// creation of matrix
		int[][]t=new int[n+1][W+1];
		//initialization of first row
		

 //this step is called the initialization step.If you think carefully the first row will have a size of matrix =0 which means it can have a maximum profit of 0. Its obvious that if there are no items/cost in the array then the maximum profit will be 0 

		for(int j=0;j<W+1;j++)
		{
			t[0][j]=0;
		}
//initialization of first column
		
//If you think carefully the first column will have a Max Capacity W of Knapsack =0 which means it can have a maximum profit of 0. Its obvious that if there is max capacity of the bag is 0 then ofc the maximum profit will be 0 


		for(int i=0;i<n+1;i++)
		{
			t[i][0]=0;
		}

//Main Logic Part

//So I is analogous to n and j is analogous to W. Ok so the as soon as you encounter a value weight that is <= W is w[i-1]<=j i.e. w[n-1]<=W we will now make a choice to either include the element in our bag or discard it. So if we include then we will take it out v[i-1], add it with the previously stored value, decrease the element count t[i-1] and subtract the max capacity by the weight we just added i.e. t[i-1][j-w[i-1]]. Now if we don’t wish to include that then we will decrease the element count, t[i-1] but not subtract the Max capacity since we are not including the item in our sack i.e. t[i-1][j-0]
		
for(int i=1;i<n+1;i++)
		{
		   for(int j=1;j<W+1;j++)
		{
			 if(w[i-1]<=j)
			      {
			     t[i][j]=Math.max(v[i-1]+t[i-1][j-w[i-1]], 0+t[i-1][j-0]);
					
				}
//ofc if the weight is > W then we cant add it hence the else part

			else {
				t[i][j]=t[i-1][j-0];
			      }
			}
		}

//the final answer will be stored in the last cell in the matrix coz in the last cell i=n,j= W i.e. all the elements have been processed

		return t[n][W];
	}

	public static void main(String[] args) {
		int[]w= {1,2,3,30,0,12};
		int[]v= {10,20,30,30,12,54};
		int n=w.length;
		int W=10;
		System.out.println(knapsack(w,v,n,W));
//Output 72


	}

}
