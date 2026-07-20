class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        int pfsum = 0;

        HashMap<Integer , ListNode> mp = new HashMap<>();

        while(right != null) {
            pfsum += right.val;

            if(pfsum == 0) {
                head = right.next;
                right = head;
                mp.clear();
                continue;
            }

            if(mp.containsKey(pfsum)) {
                ListNode actual = mp.get(pfsum);
                ListNode temp = actual;
                int tSum = pfsum;

                while(temp.next != right) {
                    tSum += temp.next.val;
                    temp = temp.next;

                    mp.remove(tSum);
                }

                actual.next = right.next;
                right = right.next;
            } else {
                mp.put(pfsum , right);
                right = right.next;
            }
        }

        return head;
    }
}