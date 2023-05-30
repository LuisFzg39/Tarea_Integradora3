package ui;

import java.util.Scanner;
import model.Controller;


public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	private void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar usuario");
			System.out.println("2. Gestionar productos bibliograficos (Registrar, Modificar y Borrar Libros y Revistas)");
			System.out.println("3. Comprar un libro");
			System.out.println("4. Suscribirse a una revista");
			System.out.println("5. Simular una sesion de lectura");
			System.out.println("6. Biblioteca de productos bibliograficos");
			System.out.println("0. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;

			case 2:
				registerProduct();
				break;

			case 3:
				bookPurchase();
				break;

			case 4:
				magazineSub();
				break;

			case 5:
				readingSesion();
				break;

			case 6:
				productLibrary();
				break;

			case 0:
				flag = true;
				break;

			default:
				System.out.println("Opcion invalida");
				break;

			}

		}

	}

	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		System.out.println("Escoja el tipo de cuenta(1: Regular / 2: Premium)");
		int accountChoice = reader.nextInt();

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		if(accountChoice == 1){

		if (rXSystem.registerUser(id, name, accountChoice)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}

		}else if(accountChoice == 2){

			System.out.println("");
			rXSystem.registerUser(id, name, accountChoice);
		}
		
		
	}

	


	private void registerProduct() {

		System.out.println("1: Registrar un producto \n2: Modificar un producto \n3: Borrar un producto");
		int productAction = reader.nextInt();

			String name = ""; 
			String id = "";
			int pages = 0;
			String publishDate = "";
			String url = "";
			double price = 0;
			String review = "";
		 	int bookGenre = 0; 
			int magazineCategory = 0;
     		String emition = "";

		switch(productAction){

			case 1: 

				//Registrar Producto

				System.out.println("Desea registrar (1: Libro / 2: Revista)");
				int option = reader.nextInt(); 

				reader.nextLine();
				System.out.println("Ingrese el nombre del producto:");
				name = reader.nextLine();
				
				System.out.println("Ingrese el id del producto:");
				id = reader.nextLine();

				System.out.println("Ingrese la cantidad de paginas:");
				pages = reader.nextInt();

				reader.nextLine();
				System.out.println("Ingrese la fecha de publicación:");
				publishDate = reader.nextLine();

				System.out.println("Ingrese el URL de la portada:");
				url = reader.nextLine();

				System.out.println("Ingrese el precio del producto:");
				price = reader.nextDouble();

				if(option == 1){

					System.out.println("Ingrese una reseña corta del libro:");
					review = reader.nextLine();

					System.out.println("Ingrese el genero del libro: \n1: Ciencia Ficción, 2: Fantasia o 3: Novela Historica");
					bookGenre = reader.nextInt();

					

				} else if(option == 2){

					System.out.println("Ingrese la categoria de la revista: \n1: Variedades, 2: Diseño o 3: Cientifica");
					magazineCategory = reader.nextInt();

					reader.nextLine();
					System.out.println("Ingrese la periodicidad/frecuencia mensual de la emisión de la revista");
					emition = reader.nextLine();

				}


				if(rXSystem.registerProduct(name, id, pages, publishDate, url, price, review, bookGenre, magazineCategory, emition, option)){

					System.out.println("El producto fue registrado exitosamente");

				}else {

					System.out.println("Hubo un error, no se ha podido registrar el producto");

				}

				break;

			case 2: 

				//Editar Producto

				String query = rXSystem.getProductList();

				if (query.equals("")) {

					System.out.println("No hay productos registrados");
						
				} else {

					System.out.println("\nEste es el listado de productos registrados en el sistema:");
					System.out.println(query);

					System.out.println("\nSeleccione el producto a editar");
					int optionEdit = reader.nextInt();

					System.out.println("¿Qué atributo desea modificar?");
					System.out.println("1. Nombre ");
					System.out.println("2. Id ");
					System.out.println("3. Numero de paginas");
					System.out.println("4. Fecha de publicación");
					System.out.println("5. URL de la portada");
					System.out.println("6. Precio ");

					if(rXSystem.getProductType(optionEdit-1) == 1){
	
					System.out.println("7. Reseña ");
					System.out.println("8. Genero del libro (1: Ciencia Ficción, 2: Fantasia o 3: Novela Historica)");
				

					} else if(rXSystem.getProductType(optionEdit-1) == 2){

					System.out.println("7. Periodicidad de la revista");
					System.out.println("8. Categoria de la revista (1: Variedades, 2: Diseño o 3: Cientifica)");
					
					
					}

					int optionMod = reader.nextInt();

					reader.nextLine();
					System.out.println("Digite el nuevo valor");
					String modification = reader.nextLine();

					rXSystem.modifyProduct(optionEdit-1, optionMod, modification) ;

					}


				break;

			case 3:

			//Borrar Producto

			String query1 = rXSystem.getProductList();

			if (query1.equals("")) {

				System.out.println("No hay productos registrados");
					
			} else {

				System.out.println("\nEste es el listado de productos registrados en el sistema:");
				System.out.println(query1);

				System.out.println("\nSeleccione el producto que desee borrar");
				int optionErase = reader.nextInt();

				if(rXSystem.deleteProduct(optionErase-1)){

					System.out.println("El producto fue borrado exitosamente");


				}else {

					System.out.println("Hubo un error, no se ha podido borrar el producto");

				}


			}

			break;
		}
			
		
	}


	private void bookPurchase(){

		String query = rXSystem.getUserList();
		String query1 = rXSystem.getBookList();

		if(query.equals("")){

			System.out.println("No hay usuarios registrados"); 

		}else {

			System.out.println("Esta es la lista de usuarios registrados:"); 
			System.out.println(query);

			System.out.println("\nPor favor escoja su usuario");
			int userOption = reader.nextInt();

			if(query1.equals("")){

				System.out.println("No hay libros registrados:");

			}else {

				System.out.println("Esta es la lista de libros registrados:");
				System.out.println(query1);

				System.out.println("\nEscoja el libro que desea comprar");
				int bookOption = reader.nextInt();

				System.out.println(rXSystem.buyABook(userOption-1, bookOption-1));


			}		
			
		}

	}


	private void magazineSub(){


		String query = rXSystem.getUserList();
		String query1 = rXSystem.getMagazineList();

		if(query.equals("")){

			System.out.println("No hay usuarios registrados"); 

		}else {

			System.out.println("Esta es la lista de usuarios registrados:"); 
			System.out.println(query);

			System.out.println("\nPor favor escoja su usuario");
			int userOption1 = reader.nextInt();

			if(query1.equals("")){

				System.out.println("No hay revistas registrados:");

			}else {

				System.out.println("Esta es la lista de revistas registradas:");
				System.out.println(query1);

				System.out.println("\nEscoja la revista que desea comprar");
				int magOption = reader.nextInt();

				System.out.println(rXSystem.buyAMagazine(userOption1-1, magOption-1));

			}

		}

	}


	private void readingSesion(){

		String query = rXSystem.getUserList();

		if(query.equals("")){

			System.out.println("No hay usuarios registrados"); 

		}else {

			System.out.println("Esta es la lista de usuarios registrados:"); 
			System.out.println(query);

			System.out.println("\nPor favor escoja su usuario");
			int userOption = reader.nextInt();

			int userType = rXSystem.getUserType(userOption-1);

			System.out.println("\nDesea leer (1: Libros o 2: Revistas)");
			int optionProduct = reader.nextInt();

			String query1 = "";

			if(optionProduct == 1){

				query1 = rXSystem.getBooks(userOption-1);

			}else if(optionProduct == 2){

				query1 = rXSystem.getMagazines(userOption-1);

			}

			System.out.println(query1);

			System.out.println("Escoja el producto que desea leer");
			int optionRead = reader.nextInt(); 
			
			String productName = rXSystem.getProductName(userOption, optionProduct, optionRead);

		}

	}

	private void productLibrary(){

		String query = rXSystem.getUserList();

		if(query.equals("")){

			System.out.println("No hay usuarios registrados"); 

		}else {

			System.out.println("Esta es la lista de usuarios registrados:"); 
			System.out.println(query);

			System.out.println("\nPor favor escoja su usuario");
			int userOption = reader.nextInt();

			rXSystem.fillMatrix(userOption-1);

			System.out.println(rXSystem.showMatrix(userOption-1));


		}

	}

}




