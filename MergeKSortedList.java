import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// TC: O(n log k) n is the total number of nodes in the lists. and k is the
// sorting in priorityQueue
// SC: O(k) where k is the length of list for queue.

// All the lists are offered in a queue. based on the min priority list is
// polled and set to curr and polled next is offered in the queue.
public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode list1 = createList(new int[] { 1, 4, 5 });
        ListNode list2 = createList(new int[] { 1, 3, 4 });
        ListNode list3 = createList(new int[] { 2, 6 });

        ListNode[] lists = { list1, list2, list3 };
        ListNode result = mergeKLists(lists);
        print(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        for (ListNode node : lists) {
            if (node != null) {
                q.offer(node);
            }
        }
        ListNode curr = dummy;
        while (!q.isEmpty()) {
            ListNode min = q.poll();
            curr.next = min;
            if (min.next != null)
                q.offer(min.next);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void print(ListNode result) {
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
}
