package model;

import java.sql.Date;

public class Transaction {
    private int id;
    private double amount;
    private String type;
    private String category;
    private String description;
    private Date date;

    public Transaction(){}
    public Transaction(double amount, String type, String category, String description, Date date)
    {
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public Transaction(int id, double amount, String type, String category, String description, Date date)
    {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId()
    {
        return id;
    }

    public void setAmount(double amt)
    {
        this.amount=amt;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setCategory(String cat)
    {
        this.category = cat;
    }

    public String getCategory()
    {
        return category;
    }

    public void setDescription(String desc)
    {
        this.description = desc;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }
    @Override
    public String toString() {
        return "Transaction [id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                ", category=" + category +
                ", description=" + description +
                ", date=" + date + "]";
    }
}
