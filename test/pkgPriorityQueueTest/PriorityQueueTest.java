package pkgPriorityQueueTest;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pkgPriorityQueue.PriorityQueue;


public class PriorityQueueTest {
	
	private PriorityQueue prioQueue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		prioQueue = new PriorityQueue();
		prioQueue.insert(57);
		prioQueue.insert(42);
		prioQueue.insert(88);
		prioQueue.insert(42);
		prioQueue.insert(49);
		prioQueue.insert(102);
		prioQueue.insert(102);
		prioQueue.insert(103);
		prioQueue.insert(55);
		prioQueue.insert(55);
		prioQueue.insert(78);
		prioQueue.insert(78);
		prioQueue.insert(89);
		prioQueue.insert(109);
		prioQueue.insert(109);
		prioQueue.insert(102);
		prioQueue.insert(162);
		prioQueue.insert(105);
		prioQueue.insert(31);
		prioQueue.insert(65);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPriorityQueue() {
		PriorityQueue prioEmptyQueue = new PriorityQueue();
		int emptyLength = prioEmptyQueue.size();
		assertEquals(0, emptyLength);
	}

	@Test
	public void testExtractMax() {
		int max = prioQueue.extractMax();
		int length = prioQueue.size();
		assertEquals(162, max);
		assertEquals(19, length);
		max = prioQueue.extractMax();
		length = prioQueue.size();
		assertEquals(109, max);
		assertEquals(18, length);
		PriorityQueue prioEmptyQueue = new PriorityQueue();
		int emptyLength = prioEmptyQueue.size();
		max = prioEmptyQueue.extractMax();
		assertEquals(-1, max);
		assertEquals(0, emptyLength);
	}
	
	@Test
	public void testExtractMin() {
		int min = prioQueue.extractMin();
		int length = prioQueue.size();
		assertEquals(31, min);
		assertEquals(19, length);
		min = prioQueue.extractMin();
		length = prioQueue.size();
		assertEquals(42, min);
		assertEquals(18, length);
		PriorityQueue prioEmptyQueue = new PriorityQueue();
		int emptyLength = prioEmptyQueue.size();
		min = prioEmptyQueue.extractMin();
		assertEquals(-1, min);
		assertEquals(0, emptyLength);
	}
	
	@Test
	public void testReturnMax() {
		int max = prioQueue.returnMax();
		int length = prioQueue.size();
		assertEquals(162, max);
		assertEquals(20, length);
		PriorityQueue prioEmptyQueue = new PriorityQueue();
		int emptyLength = prioEmptyQueue.size();
		max = prioEmptyQueue.returnMax();
		assertEquals(-1, max);
		assertEquals(0, emptyLength);
	}
	
	@Test
	public void testReturnMin() {
		int min = prioQueue.returnMin();
		int length = prioQueue.size();
		assertEquals(31, min);
		assertEquals(20, length);
		PriorityQueue prioEmptyQueue = new PriorityQueue();
		int emptyLength = prioEmptyQueue.size();
		min = prioEmptyQueue.returnMin();
		assertEquals(-1, min);
		assertEquals(0, emptyLength);
	}

	@Test
	public void testInsert() {
		boolean resInsert = prioQueue.insert(188);
		int length = prioQueue.size();
		assertEquals(21, length);
		assertTrue(resInsert);
		resInsert = prioQueue.insert(-188);
		length = prioQueue.size();
		assertEquals(21, length);
		assertFalse(resInsert);
		int max = prioQueue.extractMax();
		assertEquals(188, max);
		PriorityQueue prioQueue1 = new PriorityQueue();
		prioQueue1.insert(2);
		prioQueue1.insert(2);
		length = prioQueue1.size();
		assertEquals(2, length);
		PriorityQueue prioQueue2 = new PriorityQueue();
		prioQueue2.insert(1);
		prioQueue2.insert(2);
		length = prioQueue2.size();
		assertEquals(2, length);
	}

	@Test
	public void testSize() {
		int resLength = prioQueue.size();
		assertEquals(20, resLength);
		int min = prioQueue.extractMin();
		assertEquals(31, min);
		resLength = prioQueue.size();
		assertEquals(19, resLength);
		PriorityQueue prioEmptyQueue = new PriorityQueue();
		int emptyLength = prioEmptyQueue.size();
		assertEquals(0, emptyLength);
	}

}
