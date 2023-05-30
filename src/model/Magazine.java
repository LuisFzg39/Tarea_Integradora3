package model;

public class Magazine extends Product {

    private MagCategory magazineCategory;
    private String emition;
    private int subsActive; 

    public Magazine(String name, String id, int pages, String publishDate, String url, double price, MagCategory magazineCategory,
    String emition) {
        super(name, id, pages, publishDate, url, price);
        this.magazineCategory = magazineCategory;
        this.emition = emition;
        this.subsActive = 0;
        
        
    }

    public MagCategory getMagazineCategory() {
        return magazineCategory;
    }

    public void setMagazineCategory(MagCategory magazineCategory) {
        this.magazineCategory = magazineCategory;
    }

    public String getEmition() {
        return emition;
    }

    public void setEmition(String emition) {
        this.emition = emition;
    }

    public int getSubsActive() {
        return subsActive;
    }

    public void setSubsActive(int subsActive) {
        this.subsActive = subsActive;
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
