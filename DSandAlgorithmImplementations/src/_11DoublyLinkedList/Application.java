package _11DoublyLinkedList;

public class Application {

	public static void main(String[] args) {
		
		Employee janeJones= new Employee("Jane","Jones",123);
		Employee johnDoe= new Employee("John","Doe",4567);
		Employee marySmith= new Employee("Mary","Smith",22);
		Employee mikeWilson= new Employee("Mike","Wilson",3245);
		Employee addTest= new Employee("Jimmy","Testy",2133);
		
		DoubleLinked list = new DoubleLinked();
		
		System.out.println(list.isEmpty());
		
		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(mikeWilson);
		
		
		Employee billEnd = new Employee("Bill","Brown",8763);
		
		list.addToEnd(billEnd);
		
		list.printList();
		
		list.addBefore(addTest, marySmith);
		
		list.printList();
		
		list.removeFromEnd();
		
		list.printList();


	}

}
