package model;

public class Book extends Product {

    private String review;
    private BookGenre bookGenre; 
    private int booksSelled; 

    public Book(String name, String id, int pages, String publishDate, String url, double price, String review, BookGenre bookGenre) {

        super(name, id, pages, publishDate, url, price);
        this.review = review;
        this.bookGenre = bookGenre; 
        this.booksSelled = 0;
        
       
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getBooksSelled() {
        return booksSelled;
    }

    public void setBooksSelled(int booksSelled) {
        this.booksSelled = booksSelled;
    }

    @Override
    public String ProductReading() {
       
        String msg = "";
		
		msg += "Sesion de Lectura en progreso: ";

		msg += "\nLeyendo: " + name;

		msg += "\nPagina " + pageCount + " de " + pages;

		msg += "\nDigite 1 para ir a la siguiente página";
		msg += "\nDigite 2 para ir a la anterior página";
		msg += "\nDigite 3 para volver a la Biblioteca";


		return msg;

    }
    

}
