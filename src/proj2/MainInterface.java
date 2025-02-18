package proj2;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MainInterface {

    private Stage stage;
    Button read, save;

    public MainInterface(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public BorderPane mainInterface() {

        Image image = new Image("employee.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);

        Button add = new Button();
        add.setPrefWidth(235);
        add.setPrefHeight(70);
        ImageView addiv = new ImageView(new Image("add.png"));
        addiv.setFitWidth(60);
        addiv.setFitHeight(60);
        add.setGraphic(addiv);
        add.setStyle("-fx-background-color: #E67526 ;");
        add.setOnAction(e -> Main.setCenterContent(new Add(getStage()).main()));

        Button view = new Button();
        view.setPrefWidth(235);
        view.setPrefHeight(70);
        ImageView viewiv = new ImageView(new Image("view.png"));
        viewiv.setFitWidth(60);
        viewiv.setFitHeight(60);
        view.setGraphic(viewiv);
        view.setStyle("-fx-background-color: #E67526 ;");
        view.setOnAction(e -> Main.setCenterContent(new View(getStage()).main()));

        read = new Button();
        read.setPrefWidth(235);
        read.setPrefHeight(70);
        ImageView readiv = new ImageView(new Image("read.png"));
        readiv.setFitWidth(60);
        readiv.setFitHeight(60);
        read.setGraphic(readiv);
        read.setStyle("-fx-background-color: #E67526 ;");
        read.setOnAction(e -> {
            Employee employee = null;
            boolean result = Statics.alert(read, "confirmation", "are you sure you want to add thees employees?", Alert.AlertType.CONFIRMATION);
            if (result) {
                File file = new File("C:\\Users\\harit\\OneDrive\\Desktop\\JAVA\\demofx\\src\\employees.txt");
                try (Scanner scanner = new Scanner(file);) {
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        String arr[] = line.split(", ");
                        for (int i = 0; i < arr.length; i++) {
                            arr[i] = arr[i].trim();
                        }
                        int nullIndex = Statics.checkNull(arr);
                        String type = arr[12];
                        String index = String.valueOf(Statics.getList().size() + 1000);

                        if (nullIndex == -1) {
                            switch (type) {

                                case "Hourly Employee":
                                    employee = new HourlyEmployee(index, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], new Address(arr[7], arr[8], arr[9]),
                                            arr[10], new Image(arr[11]), (short) 150, 3);
                                    break;


                                case "Salaried Employee":
                                    employee = new SalariedEmployee(index, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], new Address(arr[7], arr[8], arr[9]),
                                            arr[10], new Image(arr[11]), 12000);
                                    break;

                                case "Employee Based Commission":
                                    employee = new EmployeeBasedCommission(index, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], new Address(arr[7], arr[8], arr[9]),
                                            arr[10], new Image(arr[11]), 4000, 2000);
                                    break;
                            }

                            String[] emp = new String[]{employee.getFirstName(), employee.getLastname(), employee.getDateOfBirth(), employee.getDesignation(),
                                    employee.getEmail(), employee.getPhoneNo(), employee.getNationality(), employee.getAddress().getStreet(), employee.getAddress().getCity(),
                                    employee.getAddress().getCountry()};

                            int invalidIndex = Statics.checkValid(arr, emp);

                            if (invalidIndex == -1) {
                                if (!BaseHandler.addIsExist(arr[5])) {

                                    Statics.getList().add(employee);

                                } else {
                                    try {
                                        throw new InvalidException("the employee is already exist");
                                    } catch (InvalidException ex) {
                                        Statics.alert(read, "error", ex.getMessage(), Alert.AlertType.ERROR);
                                    }
                                }

                            } else {
                                try {
                                    throw new InvalidException(Statics.invalid[invalidIndex]);
                                } catch (InvalidException ex) {
                                    Statics.alert(read, "error", ex.getMessage(), Alert.AlertType.ERROR);
                                }
                            }
                        } else {
                            try {
                                throw new NullException(Statics.Null[nullIndex]);
                            } catch (NullException ex) {
                                Statics.alert(read, "error", ex.getMessage(), Alert.AlertType.ERROR);
                            }
                        }
                    }

                } catch (FileNotFoundException ex) {
                    Statics.alert(read, "Error", "File not found: " + ex.getMessage(), Alert.AlertType.ERROR);
                }

            }
        });

        save = new Button();
        save.setPrefWidth(235);
        save.setPrefHeight(70);
        ImageView saveiv = new ImageView(new Image("save.png"));
        saveiv.setFitWidth(60);
        saveiv.setFitHeight(60);
        save.setGraphic(saveiv);
        save.setStyle("-fx-background-color: #E67526 ;");
        save.setOnAction(e -> {
            boolean result = Statics.alert(read, "confirmation", "are you sure you want to save thees employees?", Alert.AlertType.CONFIRMATION);
            if (result) {
                String filePath = "C:\\Users\\harit\\OneDrive\\Desktop\\JAVA\\demofx\\src\\employees.txt";

                try (PrintWriter pr = new PrintWriter(new FileWriter(filePath, true))) {
                    int length = Statics.getList().size();
                    for (int i = 0; i < length; i++) {
                        Employee employee1 = Statics.getList().get(i);

                        pr.print(employee1.getFirstName() + ", ");
                        pr.print(employee1.getLastname() + ", ");
                        pr.print(employee1.getDateOfBirth() + ", ");
                        pr.print(employee1.getDesignation() + ", ");
                        pr.print(employee1.getEmail() + ", ");
                        pr.print(employee1.getPhoneNo() + ", ");
                        pr.print(employee1.getNationality() + ", ");
                        pr.print(employee1.getAddress().getStreet() + ", ");
                        pr.print(employee1.getAddress().getCity() + ", ");
                        pr.print(employee1.getAddress().getCountry() + ", ");
                        pr.print(employee1.getEducation() + ", ");
                        pr.print(new File(employee1.getImage().getUrl()).getName() + ", ");

                        if (employee1 instanceof HourlyEmployee)
                            pr.println("Hourly Employee");
                        else if (employee1 instanceof SalariedEmployee)
                            pr.println("Salaried Employee");
                        else if (employee1 instanceof EmployeeBasedCommission)
                            pr.println("Employee Based Commission");
                    }
                    System.out.println("done");

                } catch (IOException ex) {
                    Statics.alert(save, "Error", "File not found: " + ex.getMessage(), Alert.AlertType.ERROR);
                }
            }
        });


        HBox hBox1 = new HBox(30, add, save);
        hBox1.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox(30, view, read);
        hBox2.setAlignment(Pos.CENTER);

        VBox center = new VBox(20, imageView, hBox1, hBox2);
        center.setAlignment(Pos.CENTER);

        BorderPane main = new BorderPane();
        main.setCenter(center);
        main.setStyle("-fx-background-color: linear-gradient(to bottom,#3B3B3B, #939393);");
        return main;
    }
}