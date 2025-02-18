package proj2;

import javafx.scene.image.Image;

public class HourlyEmployee extends Employee {
    private short hours;
    private float rate;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String empNo, String firstName, String lastname, String dateOfBirth, String designation, String email, String phoneNo, String nationality, Address address, String education, Image image, short hours, float rate) {
        super(empNo, firstName, lastname, dateOfBirth, designation, email, phoneNo, nationality, address, education, image);
        setHours(hours);
        setRate(rate);
    }

    public short getHours() {
        return hours;
    }

    public void setHours(short hours) {
        if (hours >= 1 && hours <= 288)
            this.hours = hours;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        if (rate >= 2.5f && rate <= 6.0f)
            this.rate = rate;
    }

    public double payment() {
        short hours = getHours();
        double rate = getRate();
        if (hours > 140)
            return (hours * rate) + ((hours - 140) * (70.0 / 100.0 * rate));
        return rate * hours;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" + super.toString() + '\'' +
                "hours='" + getHours() + '\'' +
                ", rate='" + getRate() + '\'' +
                '}';
    }
}
