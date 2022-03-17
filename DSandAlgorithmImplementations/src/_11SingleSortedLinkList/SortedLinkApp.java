package _11SingleSortedLinkList;

public class SortedLinkApp {

	public static void main(String[] args) {
		Node testNode= new Node();
		testNode.insertSorted(4);
		testNode.insertSorted(2);
		testNode.insertSorted(1);
		testNode.insertSorted(5);
		
		
		testNode.printList();
	}

}
