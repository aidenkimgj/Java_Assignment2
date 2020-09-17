package sait.bms.application;

import java.io.IOException;

import sait.bms.managers.BookManagement; 

/**
 * This program is call bookmanagement class's method called displyMenu()
 * This class have main method to generate this program.
 * @author Hong and Kim
 *
 */
public class AppDriver {
   /**
    * This is main method.
    * @param the args
    * @throws IOException - if the code inside main method doesn't work, it throws IOException.
    */
   public static void main(String[] args) throws IOException {
      BookManagement bookmanagement = new BookManagement();
      bookmanagement.displayMenu();
   }

}