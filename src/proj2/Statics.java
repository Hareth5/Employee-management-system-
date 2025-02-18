package proj2;

import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Optional;

public class Statics {

    Add add;

    private static ArrayList<Employee> list = new ArrayList<>(20);

    public static ArrayList<Employee> getList() {
        return list;
    }

    public static void setList(Employee employee) {
        list.add(employee);
    }

    public static String[] Null = {"first name cannot be null", "Last Name cannot be null", "Date of Birth cannot be null", "Designation cannot be null",
            "Email cannot be null", "Phone No cannot be null", "Nationality cannot be null", "Street cannot be null", "City cannot be null",
            "Country cannot be null", "Education cannot be null"};

    public static String[] invalid = {"first name must contain only alphabets", "last name must contain only alphabets",
            "date of birth must follow the format YYYY-MM-DD and indicates age less than 16", "designation must contain only alphabets and spaces",
            "email must be in a valid format (example@server.domain)", "phone number must start with 059 or 056 and have exactly 10 digits",
            "nationality must contain only alphabets and spaces", "street must contain only alphabets and spaces",
            "city must contain only alphabets and spaces", "country must contain only alphabets and spaces"};

    public static int checkNull(String txt[]) {
        for (int i = 0; i < txt.length; i++) {
            if (txt[i] == null || txt[i].trim().isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    public static int checkValid(String txt[], String emp[]) {
        for (int i = 0; i < emp.length; i++) {
            if (!txt[i].equals(emp[i]))
                return i;
        }
        return -1;
    }

    public static boolean alert(Button btn, String head, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(head);
        alert.setContentText(message);
        alert.initOwner(btn.getScene().getWindow());
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

}
