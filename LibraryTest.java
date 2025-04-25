import java.util.*;


public class LibraryTest {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        LibraryCollection library = new LibraryCollection();

        // TODO: Add sample books to library
        library.addBook(new Book("The Hunger Games", "Suzanne Collins", "Fiction"));
        library.addBook(new Book("The Giver", "Lois Lowry", "Fiction"));
        library.addBook(new Book("Amazon", "Jeff Bezos", "Nonfiction"));
        library.addBook(new Book("Sleep", "Insom Nia", "Science"));

        //Runs Library System
        boolean run = true;

        while (run) {
            //Displays choices
            System.out.println("\nWelcome to the Library");
            System.out.println("1. Search Available Books by Genre");
            System.out.println("2. Check Out a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            
            System.out.print("\nEnter a choice: ");

            int choice = 0; 
            
            while (choice < 1 || choice > 4)
            { 
                try {
                    choice = userInput.nextInt(); 
                    userInput.nextLine();

                    //Checks for values below 1 or above 4 and prompts for a valid menu choice.
                    if ( choice < 1 || choice > 4 ) { 
                        System.out.println("Error: Enter a valid number between 1-4.");
                        System.out.print("Enter a choice: ");
                    }
                }
                // Checks for a string value and prompts for a number. 
                catch ( InputMismatchException StringInput){
                    userInput.nextLine();
                    System.out.println("Error: Please enter an number."); 
                    System.out.print("Enter a choice: ");
                }
            }

            switch (choice) {
                // TODO: Prompt user for genre, list available books using iterator                
                case 1:     
                System.out.println("\n1. Search Available Books by Genre");            
                System.out.println ("Available Genres: ");
                System.out.println("   - Fiction");
                System.out.println("   - Nonfiction");
                System.out.println("   - Science");

                System.out.print("\nChoose a genre: ");
                String Genre = userInput.nextLine();

                //Gets available books from the speficied genre and prints a list. 
                Iterator<Book> Available = library.getGenreIterator(Genre);

                // If a genre is not found.
                if (!Available.hasNext()){
                }

                else { //If a genre is found.
                    System.out.println("\nAvailable " + Genre + ":");
            
                    while (Available.hasNext())
                    {
                        System.out.println("     - " + Available.next());
                    }
                }
            
                break;

                // TODO: Allow checkout and return, handling exceptions
                case 2:
                System.out.println("\n2. Check Out a Book");
                System.out.print ("Choose a book to checkout: ");
                String TitleCheckout = userInput.nextLine();
                
                // Search for the book for check out, prevent nonexistant book check outs, and notify of unavailability.
                try {
                    Book bookToCheckout = library.findBook(TitleCheckout);
                    bookToCheckout.checkout();
                    System.out.println("Checked out \"" + bookToCheckout.getTitle() + "\".");
                } catch (BookNotFoundException | BookNotAvailableException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 3:  
                System.out.println("\n3. Return a Book");
                System.out.print ("Choose a book to return: ");
                String TitleReturn = userInput.nextLine();
                
                // Search for the book for return, prevent nonexistant book returns, and notify of nonchecked out books.
                try {
                    Book bookToReturn = library.findBook(TitleReturn);
                    bookToReturn.returnBook();
                    System.out.println("Returned \"" + bookToReturn.getTitle() + "\".");
                } catch (BookNotFoundException | BookNotCheckedOutException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 4:      
                System.out.println("\n4. Exit Program");
                System.out.println("You've now exited the program.");
                run = false; 
                break;
            }
        }
    }
}