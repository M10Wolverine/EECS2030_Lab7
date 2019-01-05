import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods
{
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */

	public int[] fibArray(int n)
	{
		/* Your Task. */

		// base case 1
		if (n == 1)
		{
			int[] seq =
			{ 1 };
			return seq;
		}

		// base case 2
		if (n == 2)
		{
			int[] seq =
			{ 1, 1 };
			return seq;
		}

		else
		{
			int[] seq = new int[n];
			seq[0] = 1;
			seq[1] = 1;
			fibArrayHelper(2, n, seq);
			return seq;
		}
	}

	private void fibArrayHelper(int i, int n, int[] seq)
	{
		// recursively fills in seq starting at index i
		if (i < n)
		{
			seq[i] = seq[i - 1] + seq[i - 2];
			fibArrayHelper(i + 1, n, seq);
		}
	}

	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> fibList(int n)
	{
		/* Your Task. */
		ArrayList<Integer> fibArrList = new ArrayList<Integer>();

		// base case 1
		if (n == 1)
		{
			fibArrList.add(1);
			return fibArrList;
		}

		else
		{
			fibArrList.add(1);
			fibArrList.add(1);
			if (n != 2)
			{
				fibListHelper(2, n, fibArrList);
			}
			return fibArrList;
		}
		// return null;
	}

	private void fibListHelper(int i, int n, ArrayList<Integer> l)
	{
		if (i < n)
		{
			l.add(l.get(i - 1) + l.get(i - 2));
			fibListHelper(i + 1, n, l);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibArray({1, 2}) returns false and
	 * isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input array a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibArray(int[] a)
	{
		/* Your Task. */

		if (a[0] == 1 && a.length == 1)
		{
			return true;
		}

		if (a[0] == 1 && a[1] == 1)
		{
			if (a.length == 2)
			{
				return true;
			}
			if (a.length > 2 && isFibArrayHelper(2, a.length, a) == true)
			{
				return true;
			}
		}
		return false;
	}

	private boolean isFibArrayHelper(int i, int n, int[] a)
	{
		if (i < n)
		{
			if (a[i] == a[i - 1] + a[i - 2])
			{
				return isFibArrayHelper(i + 1, n, a);
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibList({1, 2}) returns false and
	 * isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input list a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibList(List<Integer> list)
	{
		/* Your Task. */
		if (list.size() == 1 && list.get(0) == 1)
		{
			return true;
		}
		if (list.get(0) == 1 && list.get(1) == 1)
		{
			if (list.size() == 2)
			{
				return true;
			}
			if (list.size() > 2 && isFibListHelper(2, list.size(), list))
			{
				return true;
			}
		}
		return false;
	}

	private boolean isFibListHelper(int i, int n, List<Integer> list)
	{
		if (i < n)
		{
			if (list.get(i) == list.get(i - 1) + list.get(i - 2))
			{
				return isFibListHelper(i + 1, n, list);
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a
	 *            an array that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i)
	{
		/* Your Task. */
		int[] newArr = new int[a.length + 1];

		if (a.length == 0)
		{
			newArr[0] = i;
			return newArr;
		}

		if (a.length == 1)
		{
			if (a[0] < i)
			{
				newArr[0] = a[0];
				newArr[1] = i;
			}
			else
			{
				newArr[0] = i;
				newArr[1] = a[0];
			}
			return newArr;
		}

		int index = indexFinder(a, i, 0);
		// System.out.println(index);

		arrayCopier(a, newArr, i, 0, 0, index);

		return newArr;
	}

	private int indexFinder(int[] a, int i, int c)
	{
		if (c < a.length)
		{
			if (c == 0)
			{
				if (i <= a[c])
				{
					return c;
				}
			}
			if (c != 0 && i >= a[c - 1] && i <= a[c])
			{
				return c;
			}
			else
			{
				return indexFinder(a, i, c + 1);
			}
		}
		return c;
	}

	private void arrayCopier(int[] a, int[] newArr, int i, int c1, int c2, int index)
	{
		if (c2 < newArr.length)
		{
			if (c2 == index)
			{
				newArr[c2] = i;
				c2++;
			}
			else
			{
				newArr[c2] = a[c1];
				c2++;
				c1++;
			}
			arrayCopier(a, newArr, i, c1, c2, index);
		}
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list
	 *            a list that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i)
	{
		/* Your Task. */

		ArrayList<Integer> newList = new ArrayList<Integer>();

		if (list.isEmpty())
		{
			newList.add(i);
			return newList;
		}

		if (list.size() == 1)
		{
			if (list.get(0) < i)
			{
				newList.add(i);
				newList.add(list.get(0));
			}
			else
			{
				newList.add(list.get(0));
				newList.add(i);
			}
			return newList;
		}

		int index = indexFinder(list, i, 0);

		newList.addAll(list.subList(0, index));
		newList.add(index, i);
		newList.addAll(list.subList(index, list.size()));

		return newList;
	}

	private int indexFinder(List<Integer> list, int i, int c)
	{
		if (c < list.size())
		{
			if (c == 0)
			{
				if (i <= list.get(c))
				{
					return c;
				}
			}
			if (c != 0 && i >= list.get(c - 1) && i <= list.get(c))
			{
				return c;
			}
			else
			{
				return indexFinder(list, i, c + 1);
			}
		}
		return c;
	}

	/**
	 * Given two sorted arrays left and right, return a sorted array of size
	 * left.length + right.length, consisting of all elements of arrays left and
	 * right.
	 * 
	 * @param left
	 *            a sorted array
	 * @param right
	 *            a sorted array
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArrays({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedLists method below to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right)
	{
		/* Your Task. */
		int[] merged;

		if ((left.length == 0) && (right.length == 0))
		{
			merged = new int[0];
			return merged;
		}
		else if (left.length == 0)
		{
			return right;
		}
		else if (right.length == 0)
		{
			return left;
		}

		merged = new int[left.length + right.length];

		mergeSortedArraysHelper(left, right, merged, 0, 0);
		return merged;
	}

	private void mergeSortedArraysHelper(int[] left, int[] right, int[] merged, int i, int j)
	{
		if (i < left.length || j < right.length)
		{
			if (i >= left.length)
			{
				merged[i + j] = right[j];
				j++;
			}
			else if (j >= right.length)
			{
				merged[i + j] = left[i];
				i++;
			}
			else if (left[i] < right[j])
			{
				merged[i + j] = left[i];
				i++;
			}
			else if (right[j] < left[i])
			{
				merged[i + j] = right[j];
				j++;
			}
			mergeSortedArraysHelper(left, right, merged, i, j);
		}
	}

	/**
	 * Given two sorted lists left and right, return a sorted list of size
	 * left.size() + right.size(), consisting of all elements of lists left and
	 * right.
	 * 
	 * @param left
	 *            a sorted list
	 * @param right
	 *            a sorted list
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedLists({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedArrays method above to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right)
	{
		ArrayList<Integer> merged = new ArrayList<Integer>();

		if (left.isEmpty() && right.isEmpty())
		{
			return merged;
		}

		mergeListHelper(left, right, merged);
		return merged;
	}

	private void mergeListHelper(List<Integer> left, List<Integer> right, List<Integer> merged)
	{
		if (left.isEmpty())
		{
			merged.addAll(right);
		}
		else if (right.isEmpty())
		{
			merged.addAll(left);
		}
		else if (!right.isEmpty() && !left.isEmpty())
		{
			if (left.get(0) > right.get(0))
			{
				merged.add(right.get(0));
				right.remove(0);
			}
			else if (left.get(0) < right.get(0))
			{
				merged.add(left.get(0));
				left.remove(0);
			}
			mergeListHelper(left, right, merged);
		}
	}

}
