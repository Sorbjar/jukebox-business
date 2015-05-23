package be.lode.jukebox.business.model.comparators;

import java.util.Comparator;

/**
 * The Class IntegerComparator.
 */
public class IntegerComparator implements Comparator<Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		return (o1 < o2 ? -1 : (o1 == o2 ? 0 : 1));
	}

}
