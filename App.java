import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class App {

	public static void main(String[] args) {
		// (head) <- ooooooooooooooooooooooooo <-tail
		// FIFO (first in, first out)
		// add to the tail, remove from the head

		// LinkedList implements Queue. LinkedList is unbounded
		final int MAX_SIZE = 3;
		Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(MAX_SIZE);

		// Throws NoSuchElementException -- no elements in the queue yet
		// System.out.println("Head of queue is: " + q1.element());

		// Adding more elements to a fixed-length queue than MAX_SIZE permits
		// will result in an IllegalStateException, which is an unchecked
		// runtime exception
		q1.add(10);
		q1.add(20);
		q1.add(30);

		// .element returns the head of the queue without removing it
		System.out.println("Head of queue is: " + q1.element());

		try {
			q1.add(40);
		} catch (IllegalStateException e) {
			System.out.println("Tried to add too many items to the queue");
		}

		for (Integer value : q1) {
			System.out.println("Queue value: " + value);
		}

		// Removes the head of the queue and then returns it
		System.out.println("Removed from queue: " + q1.remove());
		System.out.println("Removed from queue: " + q1.remove());
		System.out.println("Removed from queue: " + q1.remove());
		try {
			System.out.println("Removed from queue: " + q1.remove());
		} catch (NoSuchElementException e) {
			System.out.println("No more elements!");
		}

		// ///////////////////////////////////////////////////////

		Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(2);

		// peek works just like element, but it will return null if the queue is
		// empty
		System.out.println("Queue 2 peek: " + q2.peek());

		// Offer differs from add. Offer will return false if it was not able to
		// add another element to a queue instead of throwing an exception
		boolean vacancyFlag = true;
		int num = 10;
		while (vacancyFlag) {
			vacancyFlag = q2.offer(num);
			num += 10;
		}

		System.out.println("No more space in Queue 2");

		System.out.println("Queue 2 peek: " + q2.peek());

		for (Integer value : q2) {
			System.out.println("Queue 2 value: " + value);
		}

		// poll is just like remove, but it will return null if the queue is
		// empty
		System.out.println("Queue 2 poll: " + q2.poll());
		System.out.println("Queue 2 poll: " + q2.poll());
		System.out.println("Queue 2 poll: " + q2.poll());

		/*
		 * The subinterface BlockingQueue gives even more options to add,
		 * remove, and view elements with waiting. This can be useful for
		 * multithreading
		 */

	}

}
