package sait.bms.problemdomain;

/**
 * This class is the Superclass. Takes arguments from subclasses and save them
 * and performs the functions of various methods.
 * 
 * @author Hong and Kim
 * @version 1.5, June 7, 2020
 *
 */
public class Book {

	/**
	 * This is private instance field.
	 */

	private String isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;
	private String authors;
	private String publisher;
	private int year;
	private char format;
	private char diet;
	private char genre;
	private char frequency;

	/**
	 * This is a Book constructor for ChildrensBook class.
	 * 
	 * @param isbn      - Get isbn parameter from ChildrensBook class.
	 * @param callNumber - Get callNumber parameter from ChildrensBook class.
	 * @param available - Get available parameter from ChildrensBook class.
	 * @param total     - Get total parameter from ChildrensBook class.
	 * @param title     - Get title parameter from ChildrensBook class.
	 * @param authors   - Get authors parameter from ChildrensBook class.
	 * @param format    - Get format parameter from ChildrensBook class.
	 */
	public Book(String isbn, String callNumber, int available, int total, String title, String authors, char format) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
		this.authors = authors;
		this.format = format;
	}

	/**
	 * This is a Book constructor for CookBook class.
	 * 
	 * @param isbn       - Get isbn parameter from CookBook class.
	 * @param callNumber - Get callNumber parameter from CookBook class.
	 * @param available  - Get available parameter from CookBook class.
	 * @param total      - Get total parameter from CookBook class.
	 * @param title      - Get title parameter from CookBook class.
	 * @param diet       - Get diet parameter from CookBook class.
	 * @param publisher  - Get publisher parameter from CookBook class.
	 */
	public Book(String isbn, String callNumber, int available, int total, String title, char diet, String publisher) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
		this.publisher = publisher;
		this.diet = diet;
	}

	/**
	 * This is a Book constructor for Paperback class.
	 * 
	 * 
	 * @param isbn       - Get isbn parameter from Paperback class.
	 * @param callNumber - Get callNumber parameter from Paperback class.
	 * @param available  -Get available parameter from Paperback class.
	 * @param total      - Get total parameter from Paperback class.
	 * @param title      - Get title parameter from Paperback class.
	 * @param authors    - Get authors parameter from Paperback class.
	 * @param year       - Get year parameter from Paperback class.
	 * @param genre      - Get genre parameter from Paperback class.
	 */
	public Book(String isbn, String callNumber, int available, int total, String title, String authors, int year,
			char genre) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * This is a Book constructor for Periodical class.
	 * 
	 * @param isbn       - Get isbn parameter from Periodical class.
	 * @param callNumber - Get callNumber parameter from Periodical class.
	 * @param available  - Get available parameter from Periodical class.
	 * @param total      - Get total parameter from Periodical class.
	 * @param title      - Get title parameter from Periodical class.
	 * @param frequency  - Get frequency parameter from Periodical class.
	 */
	public Book(String isbn, String callNumber, int available, int total, String title, char frequency) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
		this.frequency = frequency;
	}

	/******************* Accessor Methods *****************/

	/**
	 * This getIsbn method returns a Book class's isbn.
	 * 
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * This getCallNumber method returns a Book class's callNumber.
	 * 
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * This getCallNumber method returns a Book class's callNumber.
	 * 
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * This setAvailable method get parameter available from where this method was
	 * invoked and store it this class.
	 * 
	 * @param the available
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * This getTotal method returns a Book class's total.
	 * 
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * This getTitle method returns a Book class's title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This getAuthors method returns a Book class's authors.
	 * 
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * This getPublisher method returns a Book class's publisher.
	 * 
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * This getYear method returns a Book class's year.
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This getFormatToSave method returns a Book class's format.
	 * 
	 * @return the format
	 */
	public char getFormatToSave() {
		return format;
	}

	/**
	 * This getFormat method converts a format to a word.
	 * 
	 * @return the result
	 */
	public String getFormat() {
		String result = "";
		switch (format) {

		case 'P':
			result = "Picture book";
			break;
		case 'E':
			result = "Early Readers";
			break;
		case 'C':
			result = "Chapter book";
			break;
		default:
			result = "Invalid Option!";

		}
		return result;

	}

	/**
	 * This getDietToSave method returns a Book class's diet.
	 * 
	 * @return the diet
	 */
	public char getDietToSave() {
		return diet;
	}

	/**
	 * This getDiet method converts a diet to a word.
	 * 
	 * @return the result
	 */
	public String getDiet() {
		String result = "";

		switch (diet) {

		case 'D':
			result = "Diabetic";
			break;
		case 'V':
			result = "Vegetarian";
			break;
		case 'G':
			result = "Gluten-free";
			break;
		case 'I':
			result = "International";
			break;
		case 'N':
			result = "None";
			break;
		default:
			result = "Invalid Option!";

		}
		return result;
	}

	/**
	 * This getGenreToSave method returns a Book class's genre.
	 * 
	 * @return the genre
	 */
	public char getGenreToSave() {
		return genre;
	}

	/**
	 * This getGenre method converts a genre to a word.
	 * 
	 * @return the result
	 */
	public String getGenre() {
		String result = "";

		switch (genre) {

		case 'A':
			result = "Adventure";
			break;
		case 'D':
			result = "Drama";
			break;
		case 'E':
			result = "Education";
			break;
		case 'C':
			result = "Classic";
			break;
		case 'F':
			result = "Fantasy";
			break;
		case 'S':
			result = "Science Fiction";
			break;
		default:
			result = "Invalid Option!";

		}
		return result;
	}

	/**
	 * This getFrequencyToSave method returns a Book class's frequency.
	 * 
	 * @return the frequency
	 */
	public char getFrequencyToSave() {
		return frequency;
	}

	/**
	 * This getFrequency method converts a frequency to a word.
	 * 
	 * @return the result
	 */
	public String getFrequency() {
		String result = "";

		switch (frequency) {

		case 'D':
			result = "Daily";
			break;
		case 'W':
			result = "Weekly";
			break;
		case 'M':
			result = "Monthly";
			break;
		case 'B':
			result = "Bi-monthly";
			break;
		case 'Q':
			result = "Quarterly";
			break;
		default:
			result = "Invalid Option!";

		}
		return result;
	}

	/**
	 * This formatToFile method is to override at subclasses.
	 * 
	 * @return default value
	 */
	public String formatToFile() {
		return "";
	}
}