package _10SinglyLinkedList;

public class EmployeeLinkedList {
	
	private EmployeeNode head;
	private int size;
	
	public void addToFront(Employee emp) {
		EmployeeNode added = new EmployeeNode(emp);
		added.setNext(head);
		head=added;
		size++;
	}
	
	public EmployeeNode removeFromFront() {
		EmployeeNode removedNode=head;
		head=head.getNext();
		size--;
		return removedNode;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public void printList() {
		EmployeeNode current= head;
		System.out.print("Head -> ");
		while(current!=null) {
			System.out.print(current);
			System.out.print(" -> ");
			current=current.getNext();
		}
		System.out.println("null");
	}

}
