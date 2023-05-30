package model;

import java.util.ArrayList;

public class PremiumU extends User {

    private ArrayList<Book> booksPremium;
    private ArrayList<Magazine> magazinePremium;


    public PremiumU(String id, String name, String signUpDate) {
        super(id, name, signUpDate);
        
        this.booksPremium = new ArrayList<Book>();
        this.magazinePremium = new ArrayList<Magazine>();

    }


    public boolean buyBookPremium(String name, String id, int pages, String publishDate, String url, double price, String review,
    BookGenre bookGenre) {
        
        booksPremium.add(new Book(name, id, pages, publishDate, url, price, review, bookGenre));

        return false;

    }


    public boolean buyMagazinePremium(String name, String id, int pages, String publishDate, String url, double price, 
    MagCategory magCategory, String emition) {
        
        magazinePremium.add(new Magazine(name, id, pages, publishDate, url, price, magCategory, emition));

        return false;

    }


    public String getUserPBook(){

        String msg = "";

        for (int i = 0; (i < booksPremium.size()); i++) {

            msg += booksPremium.get(i).getId() + " - " + booksPremium.get(i).getName();

		}

        return msg;

    }


    public String getUserPMag(){

        String msg = "";

        for (int i = 0; (i < magazinePremium.size()); i++) {

            msg += magazinePremium.get(i).getId() + " - " + magazinePremium.get(i).getName();

		}

        return msg;

    }


    public String getBookName(int optionProduct){

        String msg = "";

        msg += booksPremium.get(optionProduct).getName();

        return msg;

    }

    public String getMagName(int optionProduct){

        String msg = "";

        msg += magazinePremium.get(optionProduct).getName();

        return msg;

    }


    public String[][] fillMatrix() {

		String[][] matrix = new String[5][5];

		for (int b = 0; b < booksPremium.size(); b++){

			boolean stop = false;
			for (int i = 0; i < matrix.length && !stop; i++) {

				boolean stop1 = false;
				for (int j = 0; j < matrix[0].length && !stop1; j++) {

					if(matrix[i][j] == null){

						matrix[i][j]  = booksPremium.get(b).getId();
						stop = true;
						stop1 = true;
						

					}
				}
			}
		}
        
        for (int b = 0; b < magazinePremium.size(); b++){
			boolean stop = false;
			for (int i = 0; i < matrix.length && !stop; i++) {

				boolean stop1 = false;
				for (int j = 0; j < matrix[0].length && !stop1; j++) {

					if(matrix[i][j] == null){

						matrix[i][j]  = magazinePremium.get(b).getId();
						stop = true;
						stop1 = true;
						

					}
				}
			}
		}

		return matrix;

	}


    public ArrayList<Book> getBooksPremium() {
        return booksPremium;
    }


    public void setBooksPremium(ArrayList<Book> booksPremium) {
        this.booksPremium = booksPremium;
    }


    public ArrayList<Magazine> getMagazinePremium() {
        return magazinePremium;
    }


    public void setMagazinePremium(ArrayList<Magazine> magazinePremium) {
        this.magazinePremium = magazinePremium;
    }


    
}
