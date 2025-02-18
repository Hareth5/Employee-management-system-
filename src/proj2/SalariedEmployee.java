package proj2;

import javafx.scene.image.Image;

public class SalariedEmployee extends Employee {

    private double annualSalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String empNo , String firstName, String lastname, String dateOfBirth, String designation, String email, String phoneNo, String nationality, Address address, String education, Image image, double annualSalary) {
        super(empNo , firstName, lastname, dateOfBirth, designation, email, phoneNo, nationality, address, education, image);
        setAnnualSalary(annualSalary);
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        if (annualSalary >= 4075 && annualSalary <= 25000)
            this.annualSalary = annualSalary;
    }

    public double payment() {
        return getAnnualSalary() / 12.0;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString() +
                "annualSalary=" + getAnnualSalary() +
                '}';
    }
}
