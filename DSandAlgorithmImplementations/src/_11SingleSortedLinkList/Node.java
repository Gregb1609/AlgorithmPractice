package _11SingleSortedLinkList;

public class Node {
	
	private int value;
	private Node next;
	
	public Node() {
		
	}
	
	public Node(int val) {
		this.value=val;
	}
	
	public Node insertSorted(int inVal) {
		Node insert= new Node(inVal);
		Node head=next;
		if(head==null) {
			System.out.println("insert");
			head=insert;
			next=head;
			return head;
		}
		if(head.value>=inVal) {
			System.out.println("greater");
			insert.next=head;
			next=insert;
			return head;
		}
		while(head.next!=null) {
			if(head.next.value>=insert.value) {
				insert.next=head.next;
				head.next=insert;
				return head;
			}
			head=head.next;
		}
		head.next=insert;
		return head;
	}
	
	public void printList() {
		Node head=next;
		System.out.print("head =>");
		while (head!=null) {
			System.out.print(head.value+"=>");
			head=head.next;
		}
		System.out.println("tail");
	}
	
	

}
