package movies.models;

import movies.models.pricing.Price;

public class Movie {
    private String title;
    private Price price;

    public Movie(final String title, final Price price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int dayRented) {
        return price.getFrequentRenterPoints(dayRented);
    }
}
