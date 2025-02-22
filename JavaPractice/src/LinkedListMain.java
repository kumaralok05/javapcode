
public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList myLinkedList = new LinkedList(4);
		myLinkedList.appendElement(2);
		myLinkedList.prepend(1);
		myLinkedList.printList();
		// myLinkedList.printAll();

	}
}

class LinkedList {
	Node head;
	Node tail;
	int length;

	public LinkedList(int value) {
		Node node = new Node(value);
		head = node;
		tail = node;
		length = 1;

	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void printAll() {
		if (length == 0) {
			System.out.println("Head: null");
			System.out.println("Tail: null");
		} else {
			System.out.println("Head: " + head.value);
			System.out.println("Tail: " + tail.value);
		}
		System.out.println("Length:" + length);
		System.out.println("\nLinked List:");
		if (length == 0) {
			System.out.println("empty");
		} else {
			printList();
		}
	}

	public void appendElement(int value) {
		Node node = new Node(value);
		if (length == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;

		}
		length++;
	}

	public void prepend(int value) {
		Node node = new Node(value);
		if (length == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
		length++;
	}

	public Node removeInLast() {
		Node temp = head;
		Node pre = head;
		if (length == 0)
			return null;
		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		pre = tail;
		tail.next = null;
		length--;
		if (length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}

	public Node removeInFirst() {
		if (length == 0)
			return null;
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if (length == 0)
			tail = null;
		return temp;
	}
}

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
	}

}
