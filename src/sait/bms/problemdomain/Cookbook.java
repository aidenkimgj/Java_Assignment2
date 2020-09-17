package sait.bms.problemdomain;

/**
 * This class is a Cookbook class which is inherited from Book class.
 * 
 * @author Hong and Kim
 *
 */
public class Cookbook extends Book {

	/**
	 * This constructor takes parameters from where the Cookbook object was created
	 * and passes them over to the super class.
	 * 
	 * @param isbn - get isbn where the cookbook object was created.
	 * @param callNumber - get callNumber where the cookbook object was created.
	 * @param available - get available where the cookbook object was created.
	 * @param total - get total where the cookbook object was created.
	 * @param title - get title where the cookbook object was created.
	 * @param diet - get diet where the cookbook object was created.
	 * @param publisher - get publisher where the cookbook object was created.
	 */
	public Cookbook(String isbn, String callNumber, int available, int total, String title, char diet,
			String publisher) {
		// these params are inherited from Book class's parameters
		super(isbn, callNumber, available, total, title, diet, publisher);

	}

	/**
	 * This toString method has been overridden for ease of use in this class. Print
	 * Cookbook info.
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
		str += String.format("%-18s%s\n", "Publisher: ", super.getPublisher());
		str += String.format("%-18s%s\n", "Diet: ", super.getDiet());

		return str;
	}

	/**
	 * Overrides this method from the parent method which is Books.
	 * 
	 * @return String.format()
	 */
	public String formatToFile() {
		return String.format("%s;%s;%d;%d;%s;%s;%c", super.getIsbn(), super.getCallNumber(), super.getAvailable(),
				super.getTotal(), super.getTitle(), super.getPublisher(), super.getDietToSave());
	}
}