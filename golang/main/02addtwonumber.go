package main

type ListNode struct {
	Val int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head :=new(ListNode)
	tmp := head
	last := 0
	for l1 !=nil || l2 != nil || last !=0 {
		// 使用sum计数
		if l1 != nil {
			last += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			last += l2.Val
			l2 = l2.Next
		}
		tmp.Next = new(ListNode)
		tmp = tmp.Next
		tmp.Val = last%10
		last = last /10
	}
	return head.Next
}
