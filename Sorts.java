package samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Sorts {

	public static int[] quickSort(int[] values)
	{
		if(values.length <= 1)
		{
			return values;
		}
		
		int pivot = values[0];
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for(int i = 1; i < values.length; i++)
		{
			if(values[i] <= pivot )
			{
				left.add(values[i]);
			}
			else
			{
				right.add(values[i]);
			}
		}
		
		int[] sortedLeft = quickSort(convertIntegers(left));
		int[] sortedRight = quickSort(convertIntegers(right));
		int[] result = new int[sortedLeft.length + sortedRight.length + 1];
		
		for(int i = 0; i < sortedLeft.length; i++)
		{
			result[i] = sortedLeft[i];
		}
		
		result[sortedLeft.length] = pivot;
		for(int i = 0; i < sortedRight.length; i++)
		{
			result[sortedLeft.length + 1 + i] = sortedRight[i];
		}		
		
		return result;
	}
	
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
	
	private static int partition(int[] values, int startIx, int finishIx)
	{
		int pivotIx = 0;
		int partitionIx = startIx;
		
		swap(values, pivotIx, finishIx);
		for(int  i = startIx; i < finishIx; i++)
		{
			if(values[i] < values[pivotIx])
			{
				swap(values, i, pivotIx);
				partitionIx++;
			}
		}
		
		swap(values, partitionIx, finishIx);
		
		return partitionIx;
	}
	
	private static void swap(int[] values, int x, int y)
	{
		int temp = values[x];
		values[x] = values[y];
		values[y] = temp;
	}
	
	
	
	public static int[] mergeSort(int[] values)
	{
		if(values.length <= 1)
		{
			return values;
		}
		
		int middle = values.length / 2;
		int[] left = new int[middle];
		int[] right = new int[values.length - middle];
		
		for(int i = 0; i < left.length; i++)
		{
			left[i] = values[i];
		}
		
		for(int i = 0; i < right.length; i++)
		{
			right[i] = values[i + middle];
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}
	
	public static int[] merge(int[] left, int[] right)
	{
		int leftIx = 0;
		int rightIx = 0;
		int mergeIx = 0;
		int[] merged = new int[left.length + right.length];
		
		while(leftIx < left.length && rightIx < right.length)
		{
			if(left[leftIx] <= right[rightIx])
			{
				merged[mergeIx++] = left[leftIx++];
			}else
			{
				merged[mergeIx++] = right[rightIx++];
			}
		}
		
		for(int i = leftIx; i < left.length; i++)
		{
			merged[mergeIx++] =left[i];
		}
		
		for(int i = rightIx; i < right.length; i++)
		{
			merged[mergeIx++] = right[i];
		}
		
		return merged;
	}
	
	
	public static void insertionSort(int[] values)
	{
		for(int i = 1; i < values.length; i++)
		{
			int j = i;
			int comp = values[i];
			while(j > 0 && values[j - 1 ] > comp)
			{
				values[j] = values[j - 1];
				j--;
			}
			
			values[j] = comp;
			System.out.println(Arrays.toString(values));	
		}
	}
	
	
	public static void bubbleSort(int[] values)
	{
		for(int i = values.length - 1; i >= 0; i--)
		{
			for(int j = 1; j <= i; j++)
			{
				if(values[j - 1] > values[j])
				{
					int temp = values[j - 1];
					values[j - 1] = values[j];
					values[j] = temp;
				}
				
			}
		}
	}
	
	public static void main(String[] args)
	{
		Random random = new Random();
		int[] values = new int[20];
		for(int i = 0; i < values.length; i++)
		{
			values[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.toString(Sorts.quickSort(values)));
	}
}
