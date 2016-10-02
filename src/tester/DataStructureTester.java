package tester;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.DoublyLinkedList;
import datastructure.DoublyLinkedListNode;


public class DataStructureTester {

	
	//lists that hold nodes with data
	private DoublyLinkedList<String> list, list2, list3;
	//empty list
	private DoublyLinkedList<String> emptyList;

	/**
	 * Constructor
	 */
	public DataStructureTester(){
		list = new DoublyLinkedList<String>();
		list2 = new DoublyLinkedList<String>();
		list3 = new DoublyLinkedList<String>();
		emptyList = new DoublyLinkedList<String>();
				
	  }

	/**
	 * Create a filled linked list
	 */
	@Before 
	public void setUpList(){
		
		//add nodes with data to the list
		list.insertFirst("a");
		list.insertFirst("b");
		list.insertFirst("c");		
		
		list2.insertFirst("k");
		list2.insertFirst("l");
		
		list3.insertFirst("m");
	}
	
	@Test
	/**
	 * Tests setPrevious & getPrevious methods of DoublyLinkedListNode class
	 */
	public void testPrevious() {
		DoublyLinkedListNode<String> node = new DoublyLinkedListNode<String>();
		DoublyLinkedListNode<String> previous = new DoublyLinkedListNode<String>();
		node.setPrevious(previous);
		assertEquals("test setPrevious & getPrevious methods", node.getPrevious(), previous );
	}
	
	@Test
	/**
	 * Tests setNext & getNext methods of DoublyLinkedListNode class
	 */
	public void testNext() {
		DoublyLinkedListNode<String> node = new DoublyLinkedListNode<String>();
		DoublyLinkedListNode<String> next = new DoublyLinkedListNode<String>();
		node.setNext(next);
		assertEquals("test setNext & getNext methods", node.getNext(), next );
	}
	
	/**
	 * Tests method that gets data stored in head node of list
	 */
	@Test
	public void testGetFirst(){
	    assertEquals("Getting data from first node should output 'c'", 
	    		"c",
	    		list.getFirst());
	    assertEquals("Getting first node of empty list should output null", 
	    		null,
	    		emptyList.getFirst());
	  }
	
	/**
	 * Tests method that gets head node of list
	 */
	@Test
	public void testGetFirstNode(){
	    assertEquals("Getting first node should return a node that contains 'c' as data", 
	    		"c",
	    		list.getFirstNode().getData());
	    assertEquals("Getting first node of empty list should output null", 
	    		null,
	    		emptyList.getFirstNode());
	  }
	
	
	/**
	 * Tests method that gets data stored in last node of list
	 */
	@Test
	public void testGetLast(){
		assertEquals("Getting last node should output 'a'", 
				"a", 
				list.getLast());
		assertEquals("Getting last node of empty list should output null", 
	    		null,
	    		emptyList.getLast());	
	}
	
	/**
	 * Tests method that gets last node of list
	 */
	@Test
	public void testGetLastNode(){
	    assertEquals("Getting last node should output data in node3 - 'a'", 
	    		"a",
	    		list.getLastNode().getData());
	    assertEquals("Getting last node of empty list should output null", 
	    		null,
	    		emptyList.getLastNode());
	  }
	
	/**
	 * Tests method that inserts a new node with data at the head of the list
	 */
	@Test
	public void testInsertFirst() {
		list.insertFirst("d");
		list.insertFirst("e");
		list.insertFirst("f");
		emptyList.insertFirst("f");
		
		String message = "Testing insert first, calling three times";
		assertEquals(message, "f-> e-> d-> c-> b-> a", list.toString());
		
		assertEquals("Inserting first node into an emptry list", "f", emptyList.toString());
		
	}	
	
	/**
	 * Tests method that inserts a new node with data after the last node
	 */
	@Test
	public void testInsertLast() {
		list.insertLast("d");
		list.insertLast("e");
		list.insertLast("f");
		emptyList.insertLast("f");
		
		String message = "Testing insert last, calling three times";
		assertEquals(message, "c-> b-> a-> d-> e-> f", list.toString());
		
		assertEquals("When list is empty, insert as first node", "f", emptyList.toString());
	}
	
	/**
	 * Tests method that inserts a new node with data after given node
	 */
	@Test
	public void testInsertAfter() {
		list.insertAfter(list.getFirstNode(), "z");
		String message = "Testing insert after, inserting after head node";
		assertEquals(message, "c-> z-> b-> a", list.toString());
		
		list.insertAfter(list.getLastNode(), "x");
		message = "Testing insert after, inserting after tail node";
		assertEquals(message, "c-> z-> b-> a-> x", list.toString());
						
	}

	/**
	 * Tests method that inserts a new node with data before given node
	 */
	@Test
	public void testInsertBefore() {
		list.insertBefore((DoublyLinkedListNode<String>) list.getFirstNode(), "z");
		String message = "Testing insert before, inserting before head node";
		assertEquals(message, "z-> c-> b-> a", list.toString());
			
		list.insertBefore(list.getLastNode(), "x");
		message = "Testing insert before, inserting before tail node";
		assertEquals(message, "z-> c-> b-> x-> a", list.toString());
						
	}
	
	/**
	 * Tests method that removes the first node
	 */
	@Test
	public void testDeleteFirst() {
	
		list.deleteFirst();
		emptyList.deleteFirst();
		list3.deleteFirst();
		
		assertEquals("Testing delete first", "b-> a", list.toString());
		assertEquals("Testing delete first on empty list", null, emptyList.toString());
		assertEquals("Testing delete only one node in the list", null, list3.toString());
	}
	
	/**
	 * Tests method that removes the last node
	 */
	@Test
	public void testDeleteLast() {
	
		list.deleteLast();
		emptyList.deleteLast();
		list3.deleteLast();
		
		assertEquals("Testing delete last", "c-> b", list.toString());
		assertEquals("Testing delete last on empty list", null, emptyList.toString());
		assertEquals("Testing delete only one node in the list", null, list3.toString());
	}
	
	/**
	 * Tests method that removes the node after the specified node
	 */
	@Test
	public void testDeleteNext() {
	
		list.deleteNext(list.getFirstNode());
		list2.deleteNext(list2.getLastNode());
		list3.deleteNext(list3.getFirstNode());
		emptyList.deleteNext(emptyList.getFirstNode());
	
		assertEquals("Testing delete next, deleting after head node", "c-> a", list.toString());
		assertEquals("Testing delete if last node is passed", "l-> k", list2.toString());
		assertEquals("Testing delete the only node in the list", "m", list3.toString());
		assertEquals("Testing delete next on empty list", null, emptyList.toString());
	}
	
	/**
	 * Tests method that removes the node before the specified node
	 */
	@Test
	public void testDeletePrevious() {
	
		list.deletePrevious(list.getLastNode());
		list2.deletePrevious(list2.getFirstNode());
		list3.deletePrevious(list3.getFirstNode());
		emptyList.deletePrevious(emptyList.getFirstNode());
	
		assertEquals("Testing delete previous, deleting previuos tail node", "c-> a", list.toString());
		assertEquals("Testing delete if privious node is passed", "l-> k", list2.toString());
		assertEquals("Testing delete the only node in the list", "m", list3.toString());
		assertEquals("Testing delete next on empty list", null, emptyList.toString());
	}

	/**
	 * Tests method that determines the size of the list
	 */
	@Test
	public void testSize() {

		assertEquals("Testing determine the size of list contains 3 nodes", 3, list.size());
		assertEquals("Testing determine the size of list contains 2 nodes", 2, list2.size());
		assertEquals("Testing determine the size of list contains 1 node", 1, list3.size());
		assertEquals("Testing determine the size of empty list", 0, emptyList.size());
	}
	
	/**
	 * Tests method that determines if list is empty
	 */
	@Test
	public void testIsEmpty() {
	
		assertEquals("Testing not empty list if it is empty", false, list.isEmpty());
		assertEquals("Testing empty list if it is empty", true, emptyList.isEmpty());
	}
	
	/**
	 * Tests method that converts the list into a string
	 */
	@Test
	public void testToString() {
	
		assertEquals("Testing a method that converts the list into a string", "c-> b-> a", list.toString());
		assertEquals("Testing a method that converts the empty list into a string", null, emptyList.toString());
	}
	
	/**
	 * Tests multiple methods
	 */
	@Test
	public void additionalTest() {
		
		DoublyLinkedList<String> list4 = new DoublyLinkedList<String>();
		list4.insertFirst("a");
		assertEquals("Insert a", "a", list4.toString());
		
		list4.insertFirst("v");
		assertEquals("Insert c", "v-> a", list4.toString());
		
		list4.insertFirst("a");
		assertEquals("Insert a", "a-> v-> a", list4.toString());
		
		list4.insertFirst("l");
		assertEquals("Insert a", "l-> a-> v-> a", list4.toString());
		
		list4.insertFirst("o");
		assertEquals("Insert a", "o-> l-> a-> v-> a", list4.toString());
		
		list4.insertFirst("i");
		assertEquals("Insert a", "i-> o-> l-> a-> v-> a", list4.toString());
		
		list4.insertAfter(list4.getFirstNode().getNext(), "j");
		assertEquals("Insert a", "i-> o-> j-> l-> a-> v-> a", list4.toString());
		
		list4.insertAfter(list4.getFirstNode().getNext(), "e");
		assertEquals("Insert a", "i-> o-> e-> j-> l-> a-> v-> a", list4.toString());
		
		list4.insertAfter(list4.getFirstNode().getNext(), "v");
		assertEquals("Insert a", "i-> o-> v-> e-> j-> l-> a-> v-> a", list4.toString());
		
		list4.insertAfter(list4.getFirstNode(), "l");
		assertEquals("Insert a", "i-> l-> o-> v-> e-> j-> l-> a-> v-> a", list4.toString());
		
		list.deleteNext(list4.getFirstNode().getNext().getNext().getNext().getNext());
		assertEquals("Insert a", "i-> l-> o-> v-> e-> l-> a-> v-> a", list4.toString());
			
	}
}
