package com.example.myapplication.new_types;

public class Item_debts {

    private String name_company;
    private boolean checkbox;
    private String adress_company;
    private String price_debts;

    public Item_debts(String name_company, boolean checkbox, String adress_company, String price_debts) {
        this.name_company = name_company;
        this.checkbox = checkbox;
        this.adress_company = adress_company;
        this.price_debts = price_debts;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public String getAdress_company() {
        return adress_company;
    }

    public void setAdress_company(String adress_company) {
        this.adress_company = adress_company;
    }

    public String getPrice_debts() {
        return price_debts;
    }

    public void setPrice_debts(String price_debts) {
        this.price_debts = price_debts;
    }
}
