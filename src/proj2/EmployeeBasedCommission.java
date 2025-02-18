package proj2;

import javafx.scene.image.Image;

public class EmployeeBasedCommission extends CommissionEmployee {

    private double salary;

    public EmployeeBasedCommission() {
    }

    public EmployeeBasedCommission(String empNo , String firstName, String lastname, String dateOfBirth, String designation, String email, String phoneNo, String nationality, Address address, String education, Image image, double soldPerMonth, double salary) {
        super(empNo , firstName, lastname, dateOfBirth, designation, email, phoneNo, nationality, address, education, image, soldPerMonth);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0)
            this.salary = salary;
    }

    @Override
    public double payment() {
        return getSalary() + super.payment();
    }

    @Override
    public String toString() {
        return "EmployeeBasedCommission{" + super.toString() +
                "salary=" + getSalary() +
                '}';
    }
}
