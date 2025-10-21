package packages;
import java.util.Set;
import java.util.HashSet;

//Methods implemented so far
//addGenre, hasGenre, getInfo, getTitle, getAuthor, getPublicationYear, getRatings, getGenres

public class Book {
    // Enum is a type that represents a fixed set of constants.
    // Enum variables ka value un constants me se hi ho sakta hai.
    enum Genre {
        FANTASY,
        ROMANCE,
        SCIENCE_FICTION,
        ADVENTURE,
        ACTION
    }
    // My Book properties
    //
    private String title;
    private String author;
    private int publicationYear;
    private float ratings;
    private Set<Genre> genres = new HashSet<>();
    public void addGenre(Genre g) { genres.add(g); }
    public boolean hasGenre(Genre g) { return genres.contains(g); }
    
    
//SOME CONSTRUCTORS 
    // public Book(String title, String author) {
    //     this.title = title;
    //     this.author = author;
    //     this.publicationYear = 0;
    //     this.ratings = 0.0f;

    // }
    //removing 
    // public Book(String title, String author, int publicationYear) {
    //     this.title = title;
    //     this.author = author;
    //     this.publicationYear = publicationYear;
    //     this.ratings = 0.0f;
        
    // }

    
    public Book(String title, String author, int publicationYear, float ratings, Genre... g) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.ratings = ratings;
        for (Genre genre : g) {
            this.addGenre(genre);
        }
    }

    //Basic Getters
    public String getInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear +
               ", Ratings: " + ratings + ", Genres: " + genres.toString();
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;}       
    public float getRatings() {
        return ratings;}
    public Set<Genre> getGenres() {
        return genres;
    }

}