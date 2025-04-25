import java.util.*;

class LibraryCollection {
    private Map<String, List<Book>> genreMap;

    public LibraryCollection() {
        genreMap = new HashMap<>();
    }

    // TODO: Add books to genreMap
    public void addBook(Book book) {
        String genre = book.getGenre();
        
        if (!genreMap.containsKey(genre)) {
            genreMap.put(genre, new ArrayList<>());
        }
        genreMap.get(genre).add(book);       
    }
    
    // TODO: Return custom iterator for available books in that genre
    public Iterator<Book> getGenreIterator(String genre) {
        // Ignores case for userInput in genre search.
        for (String key : genreMap.keySet()) {
          if (key.equalsIgnoreCase(genre)) {
                genre = key; 
             break;
             }
        }             
        
        // If a genre does not match.
        if (!genreMap.containsKey(genre)) {
            System.out.println("Error: '" + genre + "' not found. \n");
            return Collections.emptyIterator(); 
        }
        
        //Creates the list of available books from a specific genre. 
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : genreMap.get(genre)) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        //Message if a genre doesn't have any available books.
        if (availableBooks.isEmpty()){
            System.out.println("All books of this genere are currently not avalable. \n");
        }    
        return availableBooks.iterator(); 
    }


    // TODO: Add methods to search and return books
    public Book findBook(String title) throws BookNotFoundException {
        for (List<Book> books : genreMap.values()) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
        }
        throw new BookNotFoundException("Error: \"" + title + "\", is not in our system. \n");
    }    
}