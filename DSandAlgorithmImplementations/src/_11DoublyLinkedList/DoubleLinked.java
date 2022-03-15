package _11DoublyLinkedList;

public class DoubleLinked {
	DoubleNode head, tail;
	int length = 0;
	
	public void addToFront(Employee emp) {
		DoubleNode node = new DoubleNode(emp);
		node.setNext(head);
		if(head==null) {
			tail=node;
		}else {
			head.setLast(node);
		}
		head=node;
		length++;
	}
	
	public void addToEnd(Employee emp) {
		DoubleNode node = new DoubleNode(emp);
		node.setLast(tail);
		if(tail==null) {
			head=node;
		}else {
			tail.setNext(node);
			node.setLast(tail);
		}
		tail=node;
		length++;
	}
	
	public Employee removeFromFront() {
		if(isEmpty()){
			return null;
		}
		DoubleNode removedNode=head;
		if(head.getNext()==null) {
			tail=null;
		}else {
			head.getNext().setLast(null);
		}
		head=head.getNext();
		length--;
		
		removedNode.setNext(null);
		
		return removedNode.getEmployee();
	}
	
	public Employee removeFromEnd() {
		if(isEmpty()){
			return null;
		}
		DoubleNode removedNode=tail;
		
		if(tail.getLast()==null) {
			head=null;
		}else {
			tail.getLast().setNext(null);
		}
		tail=tail.getLast();
		length--;
		
		removedNode.setLast(null);
		
		return removedNode.getEmployee();
	}
	
	public boolean addBefore(Employee toEnter, Employee existing) {
		//returns true if the employee is added and false if the employee existing is not found
		DoubleNode current = head;
		if(current==null) {
			return false;
		}
		
		while(current.getEmployee()!=existing&&current.getNext()!=null) {
			current=current.getNext();
		}
		if(current.getEmployee()==existing) {
			DoubleNode entry = new DoubleNode(toEnter);
			entry.setNext(current);
			entry.setLast(current.getLast());
			current.setLast(entry);
			if(current==head) {
				head=entry;
			}else {
				entry.getLast().setNext(entry);
			}
			return true;
		}else {
			System.out.println("Employee not found");
			return false;
		}
	}
	
	public boolean isEmpty() {
		return (this.length==0)?true: false;
	}
	
	public void printList() {
		DoubleNode current=head;
		System.out.print("Head =>");
		while(current!=null) {
			System.out.print(current);
			System.out.print("<=>");
			current=current.getNext();
		}
		System.out.println("Null");
	}

	public DoubleNode getHead() {
		return head;
	}

	public void setHead(DoubleNode head) {
		this.head = head;
	}

	public DoubleNode getTail() {
		return tail;
	}

	public void setTail(DoubleNode tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}
