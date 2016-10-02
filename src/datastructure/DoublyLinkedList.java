package datastructure;

/**
 * Implements a doubly linked list
 */
public class DoublyLinkedList<T> extends LinkedList<T> {

	// reference to the last node of the list
	private DoublyLinkedListNode<T> tail;

	/**
	 * Constructor creates an empty list
	 */
	public DoublyLinkedList() {
		super();
		tail = null;
	}

	/**
	 * Get the head node of the list.
	 * 
	 * @return node
	 */
	public DoublyLinkedListNode<T> getFirstNode() {
		return (DoublyLinkedListNode<T>) super.getFirstNode();
	}

	/**
	 * Get data stored in last node of list.
	 * 
	 * @return data of type T
	 */
	public T getLast() {

		// if list is not empty
		if (tail != null)
			return tail.getData();
		else
			return null;

	}

	/**
	 * Get the tail node of the list.
	 */
	public DoublyLinkedListNode<T> getLastNode() {

		// if list is not empty
		if (tail != null)
			return tail;
		else
			return null;
	}

	/**
	 * Insert a new node with data at the head of the list.
	 * 
	 * @param data
	 *            of type T
	 */
	public void insertFirst(T data) {

		// create a new node
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
		newNode.setData(data);
		newNode.setNext(head);

		// link to the previous node (new node)
		if (head != null) {
			getFirstNode().setPrevious(newNode);
		}

		// establish newNode as the head node
		head = newNode;

		// if this is only one node in the list then tail is head simultaneously
		if (tail == null) {
			tail = getFirstNode();
		}
	}

	/**
	 * Insert a new node with data at the end of the list.
	 * 
	 * @param data
	 *            of type T
	 */
	public void insertLast(T data) {
		// create a new node
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
		newNode.setData(data);
		newNode.setPrevious(tail);

		// link to the previous node (new node)
		if (tail != null) {
			tail.setNext(newNode);
		}

		// establish newNode as the tail node
		tail = newNode;

		// if this is only one node in the list then tail is head simultaneously
		if (head == null) {
			head = tail;
		}

	}

	/**
	 * Insert a new node with data after currentNode
	 * 
	 * @param the
	 *            current node, after which the new node is inserted, the stored
	 *            in the new node
	 */
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data) {

		DoublyLinkedListNode<T> insertedNode = new DoublyLinkedListNode<T>();
		insertedNode.setData(data);
		// link the node to node before currentNode
		insertedNode.setPrevious(currentNode);
		// if the current node was the last in the list then the inserted node
		// becomes the tail
		if (currentNode == tail) {
			tail = insertedNode;
		} else {
			// link the inserted node to the node after current one
			insertedNode.setNext(currentNode.getNext());
			// link the next node to the inserted node
			currentNode.getNext().setPrevious(insertedNode);
		}
		// set the new node as the next for current node
		currentNode.setNext(insertedNode);
	}

	/**
	 * Inserts a new node with data before currentNode
	 * 
	 * @param the current node, before which the new node is inserted, the
	 *            stored in the new node
	 */
	public void insertBefore(DoublyLinkedListNode<T> currentNode, T data) {

		DoublyLinkedListNode<T> insertedNode = new DoublyLinkedListNode<T>();
		insertedNode.setData(data);
		// link the node to the current node
		insertedNode.setNext(currentNode);
		// if the current node was the first in the list then the inserted node
		// becomes the head
		if (currentNode == head) {
			head = insertedNode;
		} else {
			// link the inserted node to the node before current one
			insertedNode.setPrevious(currentNode.getPrevious());
			// link the node before current node to the inserted one
			currentNode.getPrevious().setNext(insertedNode);
		}
		// set the new node as the next for current node
		currentNode.setPrevious(insertedNode);

	}

	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		super.deleteFirst();
		if (head != null) {
			// set previous of the head to null
			getFirstNode().setPrevious(null);
		}
	}

	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		if (head == tail) {
			head = null; // set the list empty
							// as tail links to head then it's null also
		} else {
			// move tail pointer to the node before the last node
			tail = tail.getPrevious();
			tail.setNext(null);
		}
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 * 
	 * @param node
	 *            after which the node has to be deleted
	 */
	public void deleteNext(DoublyLinkedListNode<T> currentNode) {
		// If list is empty or current node is a tail
		if (head == null || currentNode == tail) {
			System.out.println("List is either empty or the current node is tail");
		} else {
			if (currentNode.getNext() == tail) {
				tail = currentNode;
			}
			// set the current node as previous node for the next node
			currentNode.getNext().getNext().setPrevious(currentNode);
		}
		// call method from super class to set the node after the deleted node
		// as next for current node
		super.deleteNext(currentNode);
	}

	/**
	 * Removes node before currentNode If no node exists (i.e., currentNode is
	 * the head), do nothing
	 * 
	 * @param node
	 *            before which the node has to be deleted
	 */
	public void deletePrevious(DoublyLinkedListNode<T> currentNode) {

		// if list is empty or current node is a head
		if (head == null || currentNode == head) {
			System.out.println("List is either empty or the current node is head");
		} else {
			// set the node before the deleted node as previous for current node
			currentNode.setPrevious(currentNode.getPrevious().getPrevious());
			// set the current node as next note for the previous node
			currentNode.getPrevious().setNext(currentNode);
		}
	}

}
