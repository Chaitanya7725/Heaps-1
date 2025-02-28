import java.util.PriorityQueue;

// TC: O(n log k) as all the elements are traversed. and log k is for sorting in the priority queue
// SC: O(k) as the size of queue doesn't exceeds k 

// PriorityQueue is used retrieve the k-largest element maintaining the size of k using peek()
public class KthLargestElementinArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2)); // 5
        System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4)); // 4
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            if (q.size() > k)
                q.poll();
        }
        return q.peek();
    }
}