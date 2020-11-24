import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;
public class RUNNINGMEDIAN {
	
	static long seed;
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		
		for(int i = 0; i < C; i++)
		{
			seed = 1983;
			
			int N = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			System.out.println(median(minHeap, maxHeap, N, a, b));
		}
		
		sc.close();
	}
	
	public static int median(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int N, int a, int b)
	{
		int A = 1983;
		int result = 0;
		
		for(int i = 0; i < N; i++)
		{
			if(minHeap.size() == maxHeap.size())
			{
				maxHeap.add(A);
			}
			else minHeap.add(A);
			
			if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek())
			{
				int tmp1 = maxHeap.poll();
				int tmp2 = minHeap.poll();
				
				minHeap.add(tmp1);
				maxHeap.add(tmp2);
			}
			
			result = ( result + maxHeap.peek() ) % 20090711;
		
			A = RNG(a,b);
		}
		
		return result;
	}
	
	public static int RNG(int a, int b)
	{
		long tmp = ( seed * a + b );
		
		seed = tmp % 20090711;
		
		return (int)seed;
	}
}
