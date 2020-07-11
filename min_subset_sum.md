_**Q) Partition a set into two subsets such that the difference of subset sums is minimum.
Note : you have to include all the elements i.e. no elements can be excluded in the 2 different subsets whose min diff is to be found out**_
```java
public class MinDiff {
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
```
Note that the value of sum - this time is the value of the sum of the elements of the given array.


<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_subset_sum02.jpeg" width="800">

```java
    
    	public static int sack(int[]a,int n,int sum)
	{
		boolean[][] t=new boolean[n+1][sum+1];
```
<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_subset_sum04.jpeg" width="600">

<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_subset_sum01.jpeg" width="550" height="400">

```java
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
```
<img src="https://github.com/Its-Ankush/DynamicProgrammingBasics/blob/master/images/min_subset_sum03.jpeg" width="600" height="400">

```java
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
    
```



