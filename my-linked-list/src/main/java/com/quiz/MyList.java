package com.quiz;

public interface MyList {
	
	/**
	 * add an item to the end of the list
	 * @param value
	 */
	public void add(int value);

	/**
	 * Remove the last item of the list
	 */
	public void removeLast();
	
	/**
	 * Remove all items that greater than a target value
	 * @param value
	 */
	public void removeGreater(int value);
}
