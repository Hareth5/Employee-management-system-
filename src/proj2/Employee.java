package proj2;

import javafx.scene.image.Image;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Employee {
    private String empNo, firstName, lastname, dateOfBirth, designation, email, phoneNo, nationality;

    private Address address;

    private String education;

    private Image image;

    public Employee() {
    }

    public Employee(String empNo , String firstName, String lastname, String dateOfBirth, String designation, String email, String phoneNo, String nationality, Address address, String education, Image image) {
        setEmpNo(empNo);
        setFirstName(firstName);
        setLastname(lastname);
        setDateOfBirth(dateOfBirth);
        setDesignation(designation);
        setEmail(email);
        setPhoneNo(phoneNo);
        setNationality(nationality);
        setAddress(address);
        setEducation(education);
        setImage(image);
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if (firstName != null && firstName.matches("[a-zA-Z ]+"))
            this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        lastname = lastname.trim();
        if (lastname != null && lastname.matches("[a-zA-Z ]+"))
            this.lastname = lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        dateOfBirth = dateOfBirth.trim();
        if (dateOfBirth != null && dateOfBirth.matches("\\d{4}-\\d{2}-\\d{2}")) {
            String arr[] = dateOfBirth.split("-");
            int year = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]) - 1;
            int day = Integer.parseInt(arr[2]);

            Calendar calendar = new GregorianCalendar();
            long compare = calendar.getTimeInMillis() - new GregorianCalendar(year, month, day).getTimeInMillis();
            compare /= 31536000000L;
            if (compare >= 16)
                this.dateOfBirth = dateOfBirth;
        }
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        phoneNo = phoneNo.trim();
        if (phoneNo.matches("^(059|056)\\d{7}$") && phoneNo != null) {
            this.phoneNo = phoneNo;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();
        if (email.matches("^[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z]+\\.[a-zA-Z]+$") && email != null)
            this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        nationality = nationality.trim();
        if (nationality != null && nationality.matches("[a-zA-Z ]+"))
            this.nationality = nationality;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        designation = designation.trim();
        if (designation.matches("[a-zA-Z ]+") && designation != null)
            this.designation = designation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        education = education.trim();
        if (education.matches("[a-zA-Z. ]+"))
            this.education = education;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address != null)
            this.address = address;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        if (image != null)
            this.image = image;
    }


    public abstract double payment();

    @Override
    public String toString() {
        return "Employee Number=" + getEmpNo() + '\'' +
                "first Name='" + getFirstName() + '\'' +
                ", last Name='" + getLastname() + '\'' +
                ", date Of Birth='" + getDateOfBirth() + '\'' +
                ", phone Number='" + getPhoneNo() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", nationality='" + getNationality() + '\'' +
                ", designation='" + getDesignation() + '\'' +
                ", education='" + getEducation() + '\'' +
                ", address: " + getAddress().toString() + '\'';
    }
}
