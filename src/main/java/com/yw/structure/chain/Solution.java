package com.yw.structure.chain;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        this.val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
    }

}

class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        // 使用虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
