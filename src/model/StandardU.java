package model;


public class StandardU extends User{

    private Book[] booksStandard;
    private Magazine[] magazineStandard;

    public StandardU(String id, String name, String signUpDate) {
        super(id, name, signUpDate);
        
        booksStandard = new Book[5];
        magazineStandard = new Magazine[2];

    }

     
    public boolean buyBookStandard(String name, String id, int pages, String publishDate, String url, double price, String review,
    BookGenre bookGenre) {

        for (int i = 0; i < booksStandard.length; i++) {

			if (booksStandard[i] == null) {

                booksStandard[i] = new Book(name, id, pages, publishDate, url, price, review, bookGenre);
                return true;

			}

		}

        return false;

    }


    public boolean buyMagazineStandard(String name, String id, int pages, String publishDate, String url, double price,
    MagCategory magCategory, String emition) {

        for (int i = 0; (i < magazineStandard.length); i++) {

			if (magazineStandard[i] == null) {

                magazineStandard[i] = new Magazine(name, id, pages, publishDate, url, price, magCategory, emition);
                return true;
			}

		}

        return false;

    }
    

    public String getUserSProduct(){

        String msg = "";

        msg += "Productos registrados:"+ "\n";

        for(int i = 0; i < booksStandard.length; i++){

            if(booksStandard[i]!=null){

                msg += (i+1) + "." + booksStandard[i].getId() + " - " + booksStandard[i].getName() + "\n";

            }

        }

        for(int i = 0; i < magazineStandard.length; i++){

            if(magazineStandard[i]!=null){

                msg += (i+1) + "." + magazineStandard[i].getId() + " - " + magazineStandard[i].getName() + "\n";

            }

        }
        
        return msg;

    }


    public String getUserSBook(){

        String msg = "";

        for(int i = 0; i < booksStandard.length; i++){

            if(booksStandard[i]!=null){

                msg += (i+1) + ". " + booksStandard[i].getId() + " - " + booksStandard[i].getName() + "\n";

            }

        }
        
        return msg;

    }

    public String getBookName(int optionProduct){

        String msg = "";

        msg += booksStandard[optionProduct].getName();

        return msg;

    }

    public String getMagName(int optionProduct){

        String msg = "";

        msg += magazineStandard[optionProduct].getName();

        return msg;

    }


    public String getUserSMag(){

        String msg = "";

        for (int i = 0; (i < magazineStandard.length); i++) {

            if(magazineStandard[i] != null){

            msg += (i+1) + ". " + magazineStandard[i].getId() + " - " + magazineStandard[i].getName() + "\n";

            }

		}

        return msg;

    }


    public String[][] fillMatrix() {

		String[][] matrix = new String[5][5];

		for (int b = 0; b < booksStandard.length; b++){

			boolean stop = false;
			for (int i = 0; i < matrix.length && !stop; i++) {

				boolean stop1 = false;
				for (int j = 0; j < matrix[0].length && !stop1; j++) {

					if(matrix[i][j] == null){

						matrix[i][j]  = booksStandard[b].getId();	
						stop = true;
						stop1 = true;
						

					}
				}
			}
		}
        

        for (int b = 0; b < magazineStandard.length; b++){

			boolean stop = false;
			for (int i = 0; i < matrix.length && !stop; i++) {

				boolean stop1 = false;
				for (int j = 0; j < matrix[0].length && !stop1; j++) {

					if(matrix[i][j] == null){

						matrix[i][j]  = magazineStandard[b].getId();
						stop = true;
						stop1 = true;
						

					}
				}
			}
		}

		return matrix;

	}

    public Book[] getBooksStandard() {
        return booksStandard;
    }

    public void setBooksStandard(Book[] booksStandard) {
        this.booksStandard = booksStandard;
    }

    public Magazine[] getMagazineStandard() {
        return magazineStandard;
    }

    public void setMagazineStandard(Magazine[] magazineStandard) {
        this.magazineStandard = magazineStandard;
    }



   
    
}
