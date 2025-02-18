package proj2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public abstract class BaseDesign {
    protected TextField empNo, fName, lName, DOB, designation, email, phoneNo, nation, street, city, country;

    protected ToggleGroup education;
    protected ComboBox<String> empType;
    protected Button backBtn, photoBtn, nextBtn, prevBtn;

    protected Image image;
    protected ImageView imageView;
    private Employee employee;
    protected Label salaryLbl;
    protected TextField t1, t2, salarytxt;
    protected HBox salaryBox;

    public GridPane left() {
        TextField arr[] = {empNo, fName, lName, DOB, designation, email, phoneNo, nation, street, city, country};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new TextField();
            arr[i].setPrefWidth(150);
            arr[i].setStyle("-fx-text-fill: black; -fx-background-color: white;");
        }

        empNo = arr[0];
        fName = arr[1];
        lName = arr[2];
        DOB = arr[3];
        designation = arr[4];
        email = arr[5];
        phoneNo = arr[6];
        nation = arr[7];
        street = arr[8];
        city = arr[9];
        country = arr[10];
        empNo.setEditable(false);
        empNo.setStyle("-fx-text-fill: #555555; -fx-border-color: gray; -fx-border-width: 1; -fx-background-color: white;");


        Label l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;

        l0 = new Label("Employee No :");
        l1 = new Label("First Name :");
        l2 = new Label("Last Name :");
        l3 = new Label("Date of Birth :");
        l4 = new Label("Designation :");
        l5 = new Label("Email:");
        l6 = new Label("Phone No:");
        l13 = new Label("Nationality:");
        l7 = new Label("Street:");
        l8 = new Label("City:");
        l9 = new Label("Country:");
        l10 = new Label("Address:");
        l11 = new Label("Education:");
        l12 = new Label("Employee Type:");

        Label arr2[] = {l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13};

        for (int i = 0; i < arr2.length; i++) {
            arr2[i].setStyle("-fx-text-fill: white;");
        }


        DatePicker datePicker = new DatePicker();
        datePicker.setVisible(false);

        Button dateButton = new Button();
        ImageView calendar = new ImageView(new Image("calendar.png"));
        dateButton.setGraphic(calendar);
        dateButton.setPrefSize(30, 30);
        dateButton.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-background-color: transparent;");
        dateButton.setOnAction(e -> datePicker.show());

        datePicker.setOnAction(e -> {
            if (datePicker.getValue() != null) {
                DOB.setText(datePicker.getValue().toString());
            }
        });

        HBox hBox = new HBox(20, l7, street, l8, city, l9, country);

        education = new ToggleGroup();
        RadioButton rb1, rb2, rb3, rb4, rb5;

        rb1 = new RadioButton("PhD");

        rb2 = new RadioButton("Mastre");

        rb3 = new RadioButton("B.A");

        rb4 = new RadioButton("Secondary School");

        rb5 = new RadioButton("Primary School");

        RadioButton arr3[] = {rb1, rb2, rb3, rb4, rb5};

        for (int i = 0; i < arr3.length; i++) {
            arr3[i].setStyle("-fx-text-fill: white;");
            arr3[i].setToggleGroup(education);
        }

        HBox educationBox = new HBox(20, rb1, rb2, rb3, rb4, rb5);

        empType = new ComboBox<>();
        empType.getItems().addAll("Hourly Employee", "Salaried Employee", "Employee Based Commission");
        empType.setValue("Hourly Employee");
        empType.setPrefWidth(200);
        empType.setStyle("-fx-text-fill: black; -fx-background-color: white;");

        GridPane left = new GridPane();
        left.setHgap(8);
        left.setVgap(20);
        left.setPadding(new Insets(20));

        left.add(l0, 0, 0);
        left.add(empNo, 1, 0);
        left.add(l1, 0, 1);
        left.add(fName, 1, 1);
        left.add(l2, 0, 2);
        left.add(lName, 1, 2);
        left.add(l3, 0, 3);
        left.add(DOB, 1, 3);
        left.add(datePicker, 2, 3);
        left.add(dateButton, 2, 3);
        left.add(l4, 0, 4);
        left.add(designation, 1, 4);
        left.add(l5, 0, 5);
        left.add(email, 1, 5);
        left.add(l6, 0, 6);
        left.add(phoneNo, 1, 6);
        left.add(l13, 0, 7);
        left.add(nation, 1, 7);
        left.add(l10, 0, 8);
        left.add(hBox, 1, 8);
        left.add(l11, 0, 9);
        left.add(educationBox, 1, 9);
        left.add(l12, 0, 10);
        left.add(empType, 1, 10);
        return left;
    }

    public VBox center(Stage stage) {
        image = new Image("majhoul.png");
        imageView = new ImageView(image);
        photoBtn = new Button();
        photoBtn.setPrefWidth(235);
        photoBtn.setPrefHeight(70);

        ImageView photoIcon = new ImageView(new Image("image.png"));
        photoIcon.setFitWidth(60);
        photoIcon.setFitHeight(60);
        photoBtn.setGraphic(photoIcon);
        photoBtn.setStyle("-fx-font-size: 20px; -fx-background-color: #E67526 ;");

        imageView.setFitWidth(300);
        imageView.setFitHeight(300);

        VBox picture = new VBox(15, imageView, photoBtn);
        picture.setAlignment(Pos.TOP_CENTER);
        picture.setPadding(new Insets(20));

        photoBtn.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("my pictures");
            fc.setInitialDirectory(new File("C:\\Users\\harit\\OneDrive\\Desktop\\JAVA\\demofx\\src"));
            File f = fc.showOpenDialog(stage);
            if (f != null && f.exists()) {
                image = new Image(f.toURI().toString());
                imageView.setImage(image);
            }
        });
        return picture;
    }

    public HBox empType(String number, boolean firstTime, String type) {
        salaryLbl = new Label("Salary: ");
        salaryLbl.setStyle("-fx-text-fill: white;");
        Label finalSalary = new Label("Salary: ");
        finalSalary.setStyle("-fx-text-fill: white;");
        Label salary1 = null, salary2 = null;

        t1 = new TextField();
        t2 = new TextField();
        salarytxt = new TextField();
        salaryBox = new HBox(20);

        if (firstTime) {
            Employee employee = Statics.getList().get(Integer.parseInt(number) - 1000);

            if (employee instanceof HourlyEmployee)
                type = "Hourly Employee";
            else if (employee instanceof SalariedEmployee)
                type = "Salaried Employee";
            else if (employee instanceof EmployeeBasedCommission)
                type = "Employee Based Commission";
        }

        if (type.equals("Hourly Employee")) {
            salaryBox.getChildren().clear();
            salary1 = new Label("Hours: ");
            salary2 = new Label("Rate: ");
            salary2.setStyle("-fx-text-fill: white;");
            salaryBox.getChildren().addAll(salary1, t1, salary2, t2, finalSalary, salarytxt);

        } else if (type.equals("Salaried Employee")) {
            salaryBox.getChildren().clear();
            salary1 = new Label("annualSalary: ");
            salaryBox.getChildren().addAll(salary1, t1, finalSalary, salarytxt);

        } else if (type.equals("Employee Based Commission")) {
            salaryBox.getChildren().clear();
            salary1 = new Label("sold per month: ");
            salary2 = new Label("Salary: ");
            salary2.setStyle("-fx-text-fill: white;");
            salaryBox.getChildren().addAll(salary1, t1, salary2, t2, finalSalary, salarytxt);
        }
        salary1.setStyle("-fx-text-fill: white;");
        return salaryBox;
    }

    public void fill(String number) {
        int listIndex = Integer.parseInt(number) - 1000;
        empNo.setText(number);
        fName.setText(Statics.getList().get(listIndex).getFirstName());
        lName.setText(Statics.getList().get(listIndex).getLastname());
        DOB.setText(Statics.getList().get(listIndex).getDateOfBirth());
        designation.setText(Statics.getList().get(listIndex).getDesignation());
        email.setText(Statics.getList().get(listIndex).getEmail());
        phoneNo.setText(Statics.getList().get(listIndex).getPhoneNo());
        nation.setText(Statics.getList().get(listIndex).getNationality());
        street.setText(Statics.getList().get(listIndex).getAddress().getStreet());
        city.setText(Statics.getList().get(listIndex).getAddress().getCity());
        country.setText(Statics.getList().get(listIndex).getAddress().getCountry());

        Employee obj = Statics.getList().get(listIndex);
        if (obj instanceof HourlyEmployee) {
            empType.setValue("Hourly Employee");
            t1.setText(String.valueOf(((HourlyEmployee) obj).getHours()));
            t2.setText(String.valueOf(((HourlyEmployee) obj).getRate()));
            salarytxt.setText(String.valueOf(obj.payment()));

        } else if (obj instanceof SalariedEmployee) {
            empType.setValue("Salaried Employee");
            t1.setText(String.valueOf(((SalariedEmployee) obj).getAnnualSalary()));
            salarytxt.setText(String.valueOf(obj.payment()));

        } else if (obj instanceof EmployeeBasedCommission) {
            empType.setValue("Employee Based Commission");
            t1.setText(String.valueOf(((EmployeeBasedCommission) obj).getSoldPerMonth()));
            t2.setText(String.valueOf(((EmployeeBasedCommission) obj).getSalary()));
            salarytxt.setText(String.valueOf(obj.payment()));
        }

        String employeeEducation = obj.getEducation();
        for (int i = 0; i < education.getToggles().size(); i++) {
            RadioButton rb = (RadioButton) education.getToggles().get(i);
            if (rb.getText().equals(employeeEducation)) {
                rb.setSelected(true);
                break;
            }
        }

        Image image1 = obj.getImage();
        imageView = new ImageView(image1);
    }

}
