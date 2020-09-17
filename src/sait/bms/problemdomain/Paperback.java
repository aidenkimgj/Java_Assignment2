package sait.bms.problemdomain;

/**
 * This class is the Subclass and inherits and uses the superclass.
 * 
 * 
 * @author Hong and Kim
 * @version 1.5, June 7, 2020
 *
 */
public class Paperback extends Book {
	/**
	 * This constructor takes parameters from where the Paperback object was created
	 * and passes them over to the super class.
	 * 
	 * @param isbn       - get isbn where the paperback object was created.
	 * @param callNumber - get callNumber where the paperback object was created.
	 * @param available  - get available where the paperback object was created.
	 * @param total      - get total where the paperback object was created.
	 * @param title      - get title where the paperback object was created.
	 * @param authors    - get authors where the paperback object was created.
	 * @param year       - get year where the paperback object was created.
	 * @param genre      - get genre where the paperback object was created.
	 */
	public Paperback(String isbn, String callNumber, int available, int total, String title, String authors, int year,
			char genre) {
		super(isbn, callNumber, available, total, title, authors, year, genre);

	}

	/**
	 * This toString method has been overridden for ease of use in this class. 
	 * Print Paperback info.
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
		str += String.format("%-18s%s\n", "Authors: ", super.getAuthors());
		str += String.format("%-18s%d\n", "Year: ", super.getYear());
		str += String.format("%-18s%s\n", "Genre: ", super.getGenre());

		return str;
	}

	/**
	 * This formatToFile method exists to store in a file according to format.
	 * 
	 * @return String.format()
	 */
	public String formatToFile() {
		return String.format("%s;%s;%d;%d;%s;%s;%d;%c", super.getIsbn(), super.getCallNumber(), super.getAvailable(),
				super.getTotal(), super.getTitle(), super.getAuthors(), super.getYear(), super.getGenreToSave());
	}
}