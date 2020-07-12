<h1> Coin change problem: Minimum number of coins</h1>
So basically we are given an array of coins and another integer that represents the sum.Our task is to minimise the number of coins that will make up the sum. 
Note that there is an infinite supply of every coin in the coin array [unbounded].

```
Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25  and one of 5.
Therefore O/P is 2
```

**Solution**

_Explanation :_

```java

public class MinCoin {

	public static void main(String[] args) {
		int[]a= {25,10,5};
		int sum=30;
		int n=a.length;
		int x=MinCoin.mincoin(a, n, sum);
```
<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_coin5.jpeg" width="600" height="200">

```java

		if(x==Integer.MAX_VALUE-1 || x==Integer.MAX_VALUE)
		{
			System.out.println("Not possible to achieve sum");
			System.exit(0);
		}
		else {
			
			System.out.println(x);
		}
	}
  
  	public static int mincoin(int[]a,int n,int sum)
	{
```
<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_coin1.jpeg" width="600">

```java

		int[][]t=new int[n+1][sum+1];
		for(int i=0;i<sum+1;i++)
		{
			t[0][i]=Integer.MAX_VALUE-1;
		}
```
<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_coin2.jpeg" width="600">
<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_coin3.jpeg" width="600">

```java
		for(int i=0;i<n+1;i++)
		{
			t[i][0]=0;
		}
			
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(a[i-1]<=j)
				{
					t[i][j]=Math.min(t[i][j-a[i-1]]+1,t[i-1][j]+0);
				}
				else {
					t[i][j]=t[i-1][j];
				}
			}
						
		}
```
<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_coin4.jpeg" width="600">

```java

		return t[n][sum];
	}

}
```

```
For sum = 30 the output is 2
For sum = 31 the output is "Not possible to achieve sum"
```
