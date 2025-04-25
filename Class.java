class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

// Prevents the return of a book that had not been checked out already.
class BookNotCheckedOutException extends Exception {
    public BookNotCheckedOutException (String message) {
        super(message);
    }
}

// =============================
// Book Class
// =============================
class Book {
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // TODO: Throw exception if book is not available
    public void checkout() throws BookNotAvailableException {
        if(!isAvailable){
            throw new BookNotAvailableException("\"" + title + "\" is currently unavailable. \n");
        }
        else {
            isAvailable = false;
        }
    }
    
    // TODO: Mark book as available
    public void returnBook() throws BookNotCheckedOutException {
        if (isAvailable) {
            throw new BookNotCheckedOutException("Error: \"" + title + "\" was not checked out. \n");
        }
        else {
            isAvailable = true;
        }
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title + " by " + author + " (" + genre + ")";
    }
}
