package cl.irivera.rest;

public class Product {
    private long id;
    private String name;
    private long category;

    public Product () {
    }    

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public long getCategory() {
        return category;
    }
    public void setCategory(long category) {
        this.category = category;
    }

}