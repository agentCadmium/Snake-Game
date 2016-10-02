package datastructure;
/**
 * Class represents one node in a doubly linked list
 * Node holds objects of type T
 */
public class DoublyLinkedListNode<T> extends LinkedListNode<T>{
	
	//reference to previous link
	private DoublyLinkedListNode<T> previous;
	
	/**
	 * Constructor
	 * Create an empty node
	 */
	public DoublyLinkedListNode() {
		super();
		previous = null;
	}	

	/**
	 * Get (pointer to) next node.
	 */
	@Override
	public DoublyLinkedListNode<T> getNext(){
		return (DoublyLinkedListNode<T>) super.getNext();
	}


	/**
	 * Set the previous pointer to passed node.
	 */
	public void setPrevious(DoublyLinkedListNode<T> node) {
		previous = node;
	}

	/**
	 * Get (pointer to) previous node.
	 */
	public DoublyLinkedListNode<T> getPrevious() {
		return previous;
	}
}
