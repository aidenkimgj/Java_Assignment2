package sait.bms.managers;
/**
 * import libraries and package. 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

/**
 * The program has five methods to connect to AppDriver class and Book class.
 * 
 * @author Hong and Kim
 * @version 1.0, Jun 7, 2020
 */
public class BookManagement {
   /**
    * Two private instance fields.
    */

   // Constants
   private static final String FILE_NAME = "res//books.txt";
   // Attributes
   private ArrayList<Book> books;
   private Scanner keyboard;
   private ChildrensBook child;
   private Cookbook cook;
   private Paperback paper;
   private Periodical period;
   /**
    * Constructor to call loadBook() method and define ArrayList and Scanner
    * @throws IOException - if the code inside main method doesn't work, it throws IOException.
    */
   public BookManagement() throws IOException {
      books = new ArrayList<Book>();
      keyboard = new Scanner(System.in);
      loadBook();
   }

   /**
    * The displayMenu method shows main program menu.
    * 
    * @throws IOException - if the code inside main method doesn't work, it throws IOException.
    */

   public void displayMenu() throws IOException {
      int option = -1;
      while (option != 5) {
         System.out.println("Welcome in ABC Book Company: How May We Assist You?");
         System.out.println("1\tCheckout Book");
         System.out.println("2\tFind Books by Title");
         System.out.println("3\tDisplay Books by Type");
         System.out.println("4\tProduce Random Book List");
         System.out.println("5\tSave & Exit");
         System.out.println();

         System.out.print("Enter an option: ");
         option = keyboard.nextInt();
         keyboard.nextLine();// Flush out the scanner obj
         switch (option) {
         case 1:
            checkOutBook();
            break;
         case 2:
            findBooksByTitle();
            break;
         case 3:
            displayBooksByType();
            break;
         case 4:
            produceRandomBookList();
            break;
         case 5:
            saveAndExit();
            break;
         default:
            System.out.println("Invalid input!");
            System.out.println();
         }

      }
   }

   /**
    * This method load data from file to ArrayList called book.
    * 
    * @throws IOException - if the code inside main method doesn't work, it throws IOException.
    */
   private void loadBook() throws IOException {
      BufferedReader bReader = new BufferedReader(new FileReader(new File(FILE_NAME)));

      String lineStr;
      String[] line;

      while ((lineStr = bReader.readLine()) != null) {

         line = lineStr.split(";");
         if (line[0].substring(12).equals("0") || line[0].substring(12).equals("1")) {
            child = new ChildrensBook(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]),
                  line[4], line[5], line[6].charAt(0));
            books.add(child);

         } else if (line[0].substring(12).equals("2") || line[0].substring(12).equals("3")) {
            cook = new Cookbook(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4],
                  line[6].charAt(0), line[5]);
            books.add(cook);
         } else if (Integer.parseInt(line[0].substring(12)) >= 4 && Integer.parseInt(line[0].substring(12)) <= 7) {
            paper = new Paperback(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4],
                  line[5], Integer.parseInt(line[6]), line[7].charAt(0));
            books.add(paper);
         } else {
            period = new Periodical(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4],
                  line[5].charAt(0));
            books.add(period);
         }
      }
      bReader.close();


   }

   /**
    * This method execute finding a book to check out.
    */
   private void checkOutBook() {
      String isbn;

      System.out.print("Enter ISBN of book : ");
      /* input isbn */
      isbn = keyboard.nextLine();
      /* check if the isbn is vaild or not with using for loop */
      for (int i = 0; i < books.size(); i++) {
         int newAvailable = books.get(i).getAvailable();
         if (books.get(i).getIsbn().equals(isbn)) {
            if (books.get(i).getAvailable() == 0) {
               System.out.println("This book is not available");
               break;
            }
            /* remove a number of books checked out */
            newAvailable -= 1;
            books.get(i).setAvailable(newAvailable);
            System.out.println();
            System.out.printf("%s\"%s\"%s\n", "The book ", books.get(i).getTitle(), " has been checked out");
            System.out.printf("%s%s\n", "It can be located using a call number: ", books.get(i).getCallNumber());
            System.out.println();
            return;
         }
      }
      System.out.println("Wrong isbn try again\n");
      checkOutBook();
   }

   /**
    * This method execute finding a book by title.
    */
   private void findBooksByTitle() {
      /* define exist variable to for Validation. */
      boolean exist = false;

      System.out.print("Enter title to search for: ");
      /* input title name. */
      String titleInput = keyboard.next();
      System.out.println("Matching books:");
      /* find books by title using for loop */
      for (int i = 0; i < books.size(); i++) {
         if (books.get(i).getTitle().toLowerCase().contains(titleInput)) { // case sensitive
            System.out.println(books.get(i));
            exist = true;
         }
      }
      /*
       * if book didn't find from the Array, this code returns kind of error
       */ if (exist == false) {
          System.out.println("No matched books ...");
          System.out.println("No corresponding file was found. Try Again \n");
          /* call back to the findBooksByTitle() method */
          findBooksByTitle();
       }

   }

   /**
    * This method find books by books'type
    */
   private void displayBooksByType() {
      /*define variables*/
      int type = -1;
      char format;
      char diet;
      char genre;
      char frequency;
      boolean exist = false;
      while (!(type > 0 && type < 5)) {
         System.out.println("#\tType");
         System.out.println("1\tChildren's Books");
         System.out.println("2\tCookbooks");
         System.out.println("3\tPaperbacks");
         System.out.println("4\tPeriodicals");
         System.out.println();

         System.out.print("Enter type of book: ");
         type = keyboard.nextInt();
         keyboard.nextLine();
         /*find books by allocated type with using switch case statement */
         switch (type) {
         case 1:
            /*find Children's Book from ArrayList called books using while loop*/   
            while (!exist) {
               System.out.print("Enter a format (P for Picture book, E for Early Readers, C for Chapter book): ");
               format = keyboard.next().toUpperCase().charAt(0);

               System.out.println();
               System.out.println("Matching  books:");
               /*check if format type is equal to information of Children's Book*/      
               for (int i = 0; i < books.size(); i++) {
                  if (books.get(i).getFormatToSave() == format) {
                     System.out.println(books.get(i));
                     exist = true;
                  }
               }
               /*if there is no books matched, it returns to while loop again*/
               if (exist == false) {
                  System.out.println("No matched books ...");
                  System.out.println("Please type the correct format !!\n");
               }
            }
            break;
         case 2:
            /*find cookBook from ArrayList called books using while loop*/   
            while (!exist) {
               System.out.print(
                     "Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
               diet = keyboard.next().toUpperCase().charAt(0);
               System.out.println();
               System.out.println("Matching  books:");
               /*check if format type is equal to information of cookBook*/   
               for (int i = 0; i < books.size(); i++) {
                  if (books.get(i).getDietToSave() == diet) {
                     System.out.println(books.get(i));
                     exist = true;
                  }
               }
               /*if there is no books matched, it returns to while loop again*/
               if (exist == false) {
                  System.out.println("No matched books ...");
                  System.out.println("Please type the correct format !!\n");
               }
            }
            break;
         case 3:
            /*find paperbacks from ArrayList called books using while loop*/
            while (!exist) {
               System.out.print(
                     "Enter a genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
               genre = keyboard.next().toUpperCase().charAt(0);
               System.out.println();
               System.out.println("Matching  books:");
               /*check if format type is equal to information of paperback*/
               for (int i = 0; i < books.size(); i++) {
                  if (books.get(i).getGenreToSave() == genre) {
                     System.out.println(books.get(i));
                     exist = true;
                  }
               }
               /*if there is no books matched, it returns to while loop again*/
               if (exist == false) {
                  System.out.println("No matched books ...");
                  System.out.println("Please type the correct format !!\n");
               }
            }
            break;
         case 4:
            /*find periodcal from ArrayList called books using while loop*/
            while (!exist) {
               System.out.print(
                     "Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Bi-Monthly, or Q for Quarterly): ");
               frequency = keyboard.next().toUpperCase().charAt(0);
               System.out.println();
               System.out.println("Matching  books:");
               /*check if format type is equal to information of periodical*/
               for (int i = 0; i < books.size(); i++) {
                  if (books.get(i).getFrequencyToSave() == frequency) {
                     System.out.println(books.get(i));
                     exist = true;
                  }
               }
               /*if there is no books matched, it returns to while loop again*/
               if (exist == false) {
                  System.out.println("No matched books ...");
                  System.out.println("Please type the correct format !!\n");
               }
            }
            break;

         default:
            System.out.println("Invalid option!!");
         }

      }

   }
   /*
    *This method pick random booklist from the ArrayList by using shuffle method in Collections.
    */
   private void produceRandomBookList() {

      int numberOfBooks;

      System.out.print("Enter number of books: ");
      numberOfBooks = keyboard.nextInt();
      keyboard.nextLine();
      System.out.println();
      System.out.println("Random books:");
      //Call shuffle method from Collections class
      Collections.shuffle(books);

      // output random books 
      for (int i = 0; i < numberOfBooks; i++) {

         System.out.println(books.get(i));

      }
   }
   
   /**
    * This method save the date from ArrayList to the file. 
    * @throws IOException - if the code inside main method doesn't work, it throws IOException.
    */
   private void saveAndExit() throws IOException {
      //define new file name
      String new_file = "res//new_Book.txt";
      //Use PrintWiter to write date into the file from ArrayList.
      PrintWriter outputFile = new PrintWriter(new FileWriter(new File(new_file)));
      //use enhanced for loop to save data.
      for (Book bookStore : books) {
         outputFile.println(bookStore.formatToFile());
      }
      outputFile.close();
      System.out.println();
      System.out.println("Information is saving... Thank you!");
   }

}