package movies.models.dto;

public class RentalDataDto {
    private String movie;
    private double charge;

    public RentalDataDto(String movie, double charge) {
        this.movie = movie;
        this.charge = charge;
    }

    public String getMovie() {
        return movie;
    }

    public double getCharge() {
        return charge;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
