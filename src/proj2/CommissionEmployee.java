package proj2;

import javafx.scene.image.Image;

public class CommissionEmployee extends Employee {

    private double soldPerMonth;

    public CommissionEmployee() {
    }

    public CommissionEmployee(String empNo , String firstName, String lastname, String dateOfBirth, String designation, String email, String phoneNo, String nationality, Address address, String education, Image image, double soldPerMonth) {
        super(empNo , firstName, lastname, dateOfBirth, designation, email, phoneNo, nationality, address, education, image);
        setSoldPerMonth(soldPerMonth);
    }

    public double getSoldPerMonth() {
        return soldPerMonth;
    }

    public void setSoldPerMonth(double soldPerMonth) {
        if (soldPerMonth >= 0)
            this.soldPerMonth = soldPerMonth;
    }

    @Override
    public double payment() {
        double commissionRate;

        if (soldPerMonth > 3775) {
            commissionRate = 0.05;
        } else if (soldPerMonth < 2800 && soldPerMonth > 0) {
            commissionRate = 0.015;
        } else {
            commissionRate = 0.03;
        }

        return soldPerMonth * commissionRate;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" + super.toString() +
                "soldPerMonth=" + getSoldPerMonth() +
                '}';
    }
}
