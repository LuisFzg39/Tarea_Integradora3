package model;

public abstract class Product implements ReadingSession{
    
    private String name; 
    private String id;
    private int pages;
    private String publishDate;
    private String url;
    private int pagesRead;
    private double price;
    

    
    public Product(String name, String id, int pages, String publishDate, String url, double price) {
        this.name = name;
        this.id = id;
        this.pages = pages;
        this.publishDate = publishDate;
        this.url = url;
        this.price = price;
        
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getPages() {
        return pages;
    }


    public void setPages(int pages) {
        this.pages = pages;
    }


    public String getPublishDate() {
        return publishDate;
    }


    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public int getPagesRead() {
        return pagesRead;
    }


    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    

}
