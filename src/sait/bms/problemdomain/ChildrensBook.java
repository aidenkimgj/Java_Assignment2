package sait.bms.problemdomain;


/**
 * This class is a children class which is inherited from Book class.
 * @author Hong and Kim
 *
 */
public class ChildrensBook extends Book {
/**
 *  This constructor takes parameters from where the ChildrensBook object was created 
 *  and passes them over to the super class.
 * 
 * @param isbn - get isbn where the childrensbook object was created.
 * @param callNumber - get callNumber where the childrensbook object was created.
 * @param available - get available where the childrensbook object was created.
 * @param total - get total where the childrensbook object was created.
 * @param title - get title where the childrensbook object was created.
 * @param authors - get authors where the childrensbook object was created.
 * @param format - get format where the childrensbook object was created.
 */
   public ChildrensBook(String isbn, String callNumber, int available, int total, String title, String authors,
         char format) {
      //these params are inherited from Book class's parameters
      super(isbn, callNumber, available, total, title, authors, format);

   }

    /**
     * This toString method has been overridden for ease of use in this class. 
	 * Print ChildrensBook info.
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
      str += String.format("%-18s%s\n", "Format: ", super.getFormat());

      return str;
   }
/**
 * Overrides this method from the parent method which is Books.
 * @return String.format()
 */
   public String formatToFile() {
      return String.format("%s;%s;%d;%d;%s;%s;%c", super.getIsbn(), super.getCallNumber(), super.getAvailable(),
            super.getTotal(), super.getTitle(), super.getAuthors(), super.getFormatToSave());
   }
}