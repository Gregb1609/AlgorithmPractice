package _11DoublyLinkedList;

public class DoubleNode {
	private Employee employee;
	private DoubleNode next;
	private DoubleNode last;

	public DoubleNode(Employee employee) {
		this.employee = employee;
	}


	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public DoubleNode getNext() {
		return next;
	}



	public void setNext(DoubleNode next) {
		this.next = next;
	}



	public DoubleNode getLast() {
		return last;
	}



	public void setLast(DoubleNode last) {
		this.last = last;
	}



	@Override
	public String toString() {
		return employee.toString();
	}
	

}
