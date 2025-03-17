package movies.models.dto;

import java.util.List;

public class ReportDataDto {
    private String customer;
    private double totalAmount;
    private List<RentalDataDto> rentalList;
    private int frequentRenterPoints;

    public ReportDataDto(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<RentalDataDto> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<RentalDataDto> rentalList) {
        this.rentalList = rentalList;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }
}
