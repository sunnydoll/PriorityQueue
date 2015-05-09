package pkgPriorityQueue;
/*
Student: Zhichao Cao
Email: zc77@drexel.edu
Class: CS 576 - Dependable Software System
Project: Stable Priority Queue 
*/

import java.util.ArrayList;


public class PriorityQueue{
	
	private int length;	//The length of queue
	
	private ArrayList<QueueElement> qList;  //Priority queue
    
    protected int indexCount = 0;  //For counting the time stamp of inserted elements
    
    //The order of this priority queue is descending
    
    public PriorityQueue() {    	
    	//Constructor of Priority Queue,
    	//the bigger number stand for higher priority in my priority queue.
        qList = new ArrayList<QueueElement>();
        length = 0;
    }
    
	public boolean insert(int p) {
		//Insert an element with the binary search for its position, whose running time is logn
		//And the priority number should be integer and at least  0
		if(p >= 0) {
			int mid = 0;
			int start = 0;
			int end = qList.size();  //The pair of start and end are the two delimiters for binary search
			QueueElement le = new QueueElement(p);
			if(qList.size() == 0) {			
				qList.add(le);
			}
			else if(qList.size() == 1) {
				if(p == qList.get(0).prio) {
					qList.get(0).equivList.add(0, le);
				}
				else if(p > qList.get(0).prio) {
					qList.add(le);
				}
				else {
					qList.add(0, le);
				}
			}
			else {
				if(p < qList.get(0).prio) {
					qList.add(0, le);
				}
				else if(p > qList.get(qList.size() - 1).prio) {
					qList.add(le);
				}
				else if(p == qList.get(0).prio) {
					qList.get(0).equivList.add(le);
				}
				else if(p == qList.get(qList.size() - 1).prio) {
					qList.get(qList.size() - 1).equivList.add(le);
				}
				else {
					while(true) {
						mid = (start + end) / 2;
						if(p > qList.get(mid).prio) {
							start = mid;
						}
						else if(p < qList.get(mid).prio) {
							end = mid;
						}
						else {
							qList.get(mid).equivList.add(le);
							break;
						}
						
						if(start == end - 1) {
							qList.add(end, le);
							break;
						}
					}
				}
				
			}
			length++;
			return true;
		}
		else {
			System.out.println("Please use positive number to represent priority, thanks.");
			return false;
		}
	}
	
	public int extractMax() {
		//Remove and return the largest key from the queue
		int max = -1;
		if(qList.size() > 0) {
			max = qList.get(qList.size() - 1).prio;
			if(qList.get(qList.size() - 1).equivList.size() > 0) {
				qList.get(qList.size() - 1).timeStamp = qList.get(qList.size() - 1).equivList.get(0).timeStamp;
				qList.get(qList.size() - 1).equivList.remove(0);
			}
			else {
				qList.remove(qList.size() - 1);
			}
			length--;
			return max;
		}
		else {			
			return max;
		}		
	}
	
	public int extractMin() {
		//Remove and return the the smallest key from the queue
		int min = -1;
		if(qList.size() > 0) {
			min = qList.get(0).prio;
			if(qList.get(0).equivList.size() > 0) {
				qList.get(0).timeStamp = qList.get(0).equivList.get(0).timeStamp;
				qList.get(0).equivList.remove(0);
			}
			else {
				qList.remove(0);
			}
			length--;
			return min;
		}
		else {			
			return min;
		}		
	}
	
	public int returnMin() {
		//Remove and return the the smallest key from the queue
		int min = -1;
		if(qList.size() > 0) {
			min = qList.get(0).prio;
			return min;
		}
		else {			
			return min;
		}		
	}
	
	public int returnMax() {
		//Remove and return the largest key from the queue
		int max = -1;
		if(qList.size() > 0) {
			max = qList.get(qList.size() - 1).prio;			
			return max;
		}
		else {			
			return max;
		}		
	}
	
	public int size() {
		//Return the length of the queue
		return length;
	}
	
	//Class for queue element, the element has an other arraylist for the elements has equivalent key
	public class QueueElement {
        
        int prio;	//The bigger number stands for higher priority
        int timeStamp;  //The index represents the time when this element was inserted into the queue 
        ArrayList<QueueElement> equivList;  //Saving the equal element in order to make queue stable
        
        public QueueElement(int p) {
        	//Element in the queue
        	equivList = new ArrayList<QueueElement>();
            prio = p;
            indexCount++;
            timeStamp = indexCount;
        }
    }
    
}
