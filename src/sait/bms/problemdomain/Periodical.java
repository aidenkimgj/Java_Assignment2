package sait.bms.problemdomain;

/**
 * This class is the Subclass and inherits and uses the superclass.
 * 
 * 
 * @author Hong and Kim
 * @version 1.5, June 7, 2020
 *
 */
public class Periodical extends Book {

	/**
	 * This constructor takes parameters from where the Periodical object was
	 * created and passes them over to the super class.
	 * 
	 * @param isbn       -get isbn where the periodical object was created.
	 * @param callNumber -get callNumber where the periodical object was created.
	 * @param available  -get available where the periodical object was created.
	 * @param total      -get total where the periodical object was created.
	 * @param title      -get title where the periodical object was created.
	 * @param frequency  -get frequency where the periodical object was created.
	 */
	public Periodical(String isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title, frequency);
	}

	/**
	 * This toString method has been overridden for ease of use in this class. 
	 * Print Periodical info.
	 * 
	 * @return str
	 */
	public String toString() {

		String str = "";
		str += String.format("%-18s%s\n", "ISBN: ", super.getIsbn());
		str += String.format("%-18s%s\n", "Call Number: ", super.getCallNumber());
		str += String.format("%-18s%d\n", "Available: ", super.getAvailable());
		str += String.format("%-18s%d\n", "Total: ", super.getTotal());
		str += String.format("%-18s%s\n", "Title: ", super.getTitle());
		str += String.format("%-18s%s\n", "Frequency: ", super.getFrequency());

		return str;
	}

	/**
	 * This formatToFile method exists to store in a file according to format.
	 * 
	 * @return String.format()
	 */
	public String formatToFile() {
		return String.format("%s;%s;%d;%d;%s;%c", super.getIsbn(), super.getCallNumber(), super.getAvailable(),
				super.getTotal(), super.getTitle(), super.getFrequencyToSave());
	}
}