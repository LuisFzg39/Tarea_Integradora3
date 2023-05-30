package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Controller {

	private ArrayList<User> users;
	private ArrayList<Product> products;

	public Controller() {

		this.users = new ArrayList<User>();
		this.products = new ArrayList<Product>(); 
		testCases();
		productTestCases();

	}

	public void testCases() {

		users.add(new StandardU("1234", "Cantinflas", "29/10/2020"));
		users.add(new PremiumU("5678", "Elon Musk", "14/07/2017"));
	}

	public void productTestCases(){

		products.add(new Book("La Biblia", "A00B", 500, "24/12/1207", "bible.png", 150.00,
		"Clasico de la literatura conocido a nivel mundial", BookGenre.NOVELA_HISTORICA));

		products.add(new Magazine("Pazzione", "C36A", 30, "6/09/2000", "buccellatiTeam.jpg",
		80.00, MagCategory.DISEÑO, "Cada 15 dias"));

	}

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {

			
			msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
			
		}

		return msg;

	}

	public boolean registerUser(String id, String name, int accountChoice) {

		Date actualDate = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String actualD = dateFormat.format(actualDate);

		if (accountChoice == 1) {

			users.add(new StandardU(id, name, actualD));
			return true;

		}else if(accountChoice == 2){

			users.add(new PremiumU(id, name, actualD));
			return true;

		}

		return false;
		
	}


	public int getUserType(int userOption){

		int userTypeN = 0;

			if(users.get(userOption) instanceof StandardU){

				userTypeN = 1;

			}else if(users.get(userOption) instanceof PremiumU){

				userTypeN = 2; 

			}

		return userTypeN;

	}


	//Products




	public boolean registerProduct(String name, String id, int pages, String publishDate, String url, double price, String review,
	int bookGenre, int magazineCategory, String emition, int option) {


		BookGenre bookG = BookGenre.CIENCIA_FICCION;

		switch(bookGenre){

			case 1:
				bookG = BookGenre.CIENCIA_FICCION;
				break;

			case 2:
				bookG = BookGenre.FANTASIA;
				break;

			case 3:
				bookG = BookGenre.NOVELA_HISTORICA;
				break; 

		}



		MagCategory magCat = MagCategory.VARIEDADES;

		switch(magazineCategory){

			case 1:
				magCat = MagCategory.VARIEDADES;
				break;

			case 2:
				magCat = MagCategory.DISEÑO;
				break;

			case 3:
				magCat = MagCategory.CIENTIFICA;
				break; 

		}
	
			if (option == 1) {

				products.add(new Book(name, id, pages, publishDate, url, price, review, bookG));
				return true;

			}else if(option == 2){

				products.add(new Magazine(name, id, pages, publishDate, url, price, magCat, emition));
				return true;

			} 
					

		return false;
		
	}


	public String getProductList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			msg += "\n" + (i + 1) + ". " + products.get(i).getId() + " - " + products.get(i).getName();
		
		}

		return msg;

	}



	public String getBookList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Book){

				msg += "\n" + (i + 1) + ". " + products.get(i).getId() + " - " + products.get(i).getName();

			}
			
		}

		return msg;

	}


	public String getMagazineList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Magazine){

				msg += "\n" + (i + 1) + ". " + products.get(i).getId() + " - " + products.get(i).getName();

			}

			
		}

		return msg;

	}



	public boolean modifyProduct(int optionEdit, int optionMod, String modification) {

        switch(optionMod){
        
        case 1:
            products.get(optionEdit).setName(modification);
            return true;

		case 2:
			products.get(optionEdit).setId(modification);
			return true;
           
    	case 3:
		 	int pageNum = Integer.parseInt(modification);
            products.get(optionEdit).setPages(pageNum);
            return true;

        case 4:
			products.get(optionEdit).setPublishDate(modification);
            return true; 

        case 5:
			products.get(optionEdit).setUrl(modification);
            return true;
            
        case 6:
			Double productPrice = Double.parseDouble(modification);

			products.get(optionEdit).setPrice(productPrice);
			return true;
		
			

        case 7:
			if(products.get(optionEdit) instanceof Book){
				((Book)(products.get(optionEdit))).setReview(modification);
				return true;

			}else if(products.get(optionEdit) instanceof Magazine){
				((Magazine)(products.get(optionEdit))).setEmition(modification);
				return true;
				
			}

        case 8:
            
			if(products.get(optionEdit) instanceof Book){
			
				int genreChoice = Integer.parseInt(modification);

				BookGenre genreB = null;

				switch(genreChoice){
					case 1:
						genreB = BookGenre.CIENCIA_FICCION;
						break;
					case 2:
						genreB = BookGenre.FANTASIA;
						break;
					case 3:
						genreB = BookGenre.NOVELA_HISTORICA;
						break;
					
				}

				((Book)(products.get(optionEdit))).setBookGenre(genreB);
				return true;

			}else if(products.get(optionEdit) instanceof Magazine){

				int categoryChoice = Integer.parseInt(modification);

				MagCategory categoryM = null;

				switch(categoryChoice){
					case 1:
						categoryM = MagCategory.VARIEDADES;
						break;
					case 2:
						categoryM = MagCategory.DISEÑO;
						break;
					case 3:
						categoryM = MagCategory.CIENTIFICA;
						break;
					
				}	

				((Magazine)(products.get(optionEdit))).setMagazineCategory(categoryM);
				return true;
				
			}
        
		}

		return false;

    }

	public boolean deleteProduct(int optionErase) {

		products.remove(optionErase);

		return true; 

	}


	public int getProductType(int optionEdit){

		int productType = 0;

			if(products.get(optionEdit) instanceof Book){

				productType = 1;

			}else if(products.get(optionEdit) instanceof Magazine){

				productType = 2; 

			}

		return productType;

	}

	public String buyABook(int userOption, int bookOption){

		String msg = "";

		Calendar buyDateB = new GregorianCalendar();

		int booksSold = ((Book)(products.get(bookOption))).getBooksSelled() + 1;

		((Book)(products.get(bookOption))).setBooksSelled(booksSold);

		String name = ((Book)(products.get(bookOption))).getName();
		String id = ((Book)(products.get(bookOption))).getId();
		int pages = ((Book)(products.get(bookOption))).getPages();
		String publishDate = ((Book)(products.get(bookOption))).getPublishDate();
		String url = ((Book)(products.get(bookOption))).getUrl();
		double price = ((Book)(products.get(bookOption))).getPrice();
		String review = ((Book)(products.get(bookOption))).getReview();
		BookGenre bookGenre = ((Book)(products.get(bookOption))).getBookGenre();

		
		if(users.get(userOption) instanceof StandardU){

			((StandardU)(users.get(userOption))).buyBookStandard(name, id, pages, publishDate, url, price, review, bookGenre);

		}else if(users.get(userOption) instanceof PremiumU){

			((PremiumU)(users.get(userOption))).buyBookPremium(name, id, pages, publishDate, url, price, review, bookGenre);

		}

		msg += "\nRecibo" + "\nCompro el libro " + name + "\nFecha de compra: " + buyDateB + "\nPrecio de la compra: " + price;
		
		return msg;

	}

	public String buyAMagazine(int userOption, int magOption){

		String msg = "";

		Calendar buyDateM = new GregorianCalendar();

		int subsActive = ((Magazine)(products.get(magOption))).getSubsActive() + 1;

		((Magazine)(products.get(magOption))).setSubsActive(subsActive);

		String name = ((Magazine)(products.get(magOption))).getName();
		String id = ((Magazine)(products.get(magOption))).getId();
		int pages = ((Magazine)(products.get(magOption))).getPages();
		String publishDate = ((Magazine)(products.get(magOption))).getPublishDate();
		String url = ((Magazine)(products.get(magOption))).getUrl();
		double price = ((Magazine)(products.get(magOption))).getPrice();
		MagCategory magCategory = ((Magazine)(products.get(magOption))).getMagazineCategory();
		String emition = ((Magazine)(products.get(magOption))).getEmition();
		

		
		if(users.get(userOption) instanceof StandardU){

			((StandardU)(users.get(userOption))).buyMagazineStandard(name, id, pages, publishDate, url, price, magCategory, emition);

		}else if(users.get(userOption) instanceof PremiumU){

			((PremiumU)(users.get(userOption))).buyMagazinePremium(name, id, pages, publishDate, url, price, magCategory, emition);

		}

		msg += "\nRecibo" + "\nSe suscribio a la revista " + name + "\nFecha de compra: " + buyDateM + "\nPrecio de la compra: " + price;
		
		return msg;

	}


	public String getBookChoice() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Book){

				msg += "\n" + (i + 1) + ". " + products.get(i).getId() + " - " + products.get(i).getName();

			}
			
		}

		return msg;

	}


	public String getBooks(int userOption){

		String msg = "";

		if(users.get(userOption) instanceof StandardU){

			msg += ((StandardU)(users.get(userOption))).getUserSBook();

		}else if(users.get(userOption) instanceof PremiumU){

			msg += ((PremiumU)(users.get(userOption))).getUserPBook();

		}

		return msg;
	}


	public String getMagazines(int userOption){

		String msg = "";

		if(users.get(userOption) instanceof StandardU){

			msg += ((StandardU)(users.get(userOption))).getUserSMag();

		}else if(users.get(userOption) instanceof PremiumU){

			msg += ((PremiumU)(users.get(userOption))).getUserPMag();

		}

		return msg;
	}


	public String getProductName(int userOption, int optionProduct, int optionRead){

		String msg = "";
		int option = 0;

		if(users.get(userOption) instanceof StandardU){
			option = 1;
		}

		if(users.get(userOption) instanceof PremiumU){
			option = 2;
		}

		if(optionProduct == 1){

			if(option == 1){

				msg += ((StandardU)(users.get(userOption))).getBookName(optionRead);

			}else if(option == 2){
				
				msg += ((PremiumU)(users.get(userOption))).getBookName(optionRead);

			}

		}else if(optionProduct == 2){

			if(option == 1){

				msg += ((StandardU)(users.get(userOption))).getMagName(optionRead);

			}else if(option == 2){

				msg += ((PremiumU)(users.get(userOption))).getMagName(optionRead);
				
			}

		}

		return msg;
	}


	public String readingSession(int userOption){

		String msg = "";

		


		return msg; 

	}


	public String[][] fillMatrix(int userOption){

		String[][] matrix = new String[5][5];

		if(users.get(userOption) instanceof PremiumU){

			matrix = ((PremiumU)(users.get(userOption))).fillMatrix();

		}
		if(users.get(userOption) instanceof StandardU){

			matrix = ((StandardU)(users.get(userOption))).fillMatrix();

		}

		return matrix;

	}


	public String showMatrix(int userOption) {

		String[][] matrix = fillMatrix(userOption);

		String print = "\n";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == null) {
							 
					print += "____" + " | ";
				} else {
					print += matrix[i][j] + " | ";
				}

			}
			print += "\n";
		}

		return print;
	}


}


