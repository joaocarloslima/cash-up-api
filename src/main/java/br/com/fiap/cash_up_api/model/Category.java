package br.com.fiap.cash_up_api.model;

public class Category {
    private Long id;
    private String name;
    private String icon;

    public Category(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    

    
}
