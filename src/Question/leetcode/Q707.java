package Question.leetcode;

/**
 * Created by gump on 2021/3/2.
 */
public class Q707 {

    ListNode head = null;
    Integer size = null;

    /** Initialize your data structure here. */
    public Q707() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index > size) return -1;

        int i = 0;
        ListNode tar = head;
        while (i < index) {
            tar = tar.next;
            i++;
        }
        return tar.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index<0 || index > size) return;

        size++;
        ListNode tar = head;
        ListNode pre = null;
        while (index > 0) {
            pre = tar;
            tar = tar.next;
            index --;
        }

        if (tar == head) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }else {
            ListNode newNode = new ListNode(val);
            pre.next = newNode;
            newNode.next = tar;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<0 || index > size) return;

        size--;
        ListNode tar = head;
        ListNode pre = null;
        while (index > 0) {
            pre = tar;
            tar = tar.next;
            index --;
        }

        if (tar == head) {
            head = head.next;
        }else {
            pre.next = tar.next;
        }
    }
}
