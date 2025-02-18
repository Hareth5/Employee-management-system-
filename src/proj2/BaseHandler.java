package proj2;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;

public class BaseHandler {

    protected BaseDesign action;

    protected Employee employee;
    private Button button;
    protected boolean updated = false;
    private String type;
    protected String educationText;
    private String txt[];

    public BaseHandler(BaseDesign action) {
        this.action = action;
    }

    public void handler() {

            type = action.empType.getValue();

            educationText = (action.education.getSelectedToggle() != null) ? ((RadioButton) action.education.getSelectedToggle()).getText() : "";

            txt = new String[]{action.fName.getText().trim(), action.lName.getText().trim(), action.DOB.getText().trim(), action.designation.getText().trim(),
                    action.email.getText().trim(), action.phoneNo.getText().trim(), action.nation.getText().trim(), action.street.getText().trim(),
                    action.city.getText().trim(), action.country.getText().trim(), educationText.trim()};

            if (action instanceof Add)
                button = ((Add) action).getAddBtn();
            else if (action instanceof Update)
                button = ((Update) action).getUpdateBtn();

        int nullIndex = Statics.checkNull(txt);

        if (nullIndex == -1) {
            switch (type) {

                case "Hourly Employee":
                    employee = new HourlyEmployee(action.empNo.getText(), txt[0], txt[1], txt[2], txt[3], txt[4], txt[5], txt[6], new Address(txt[7], txt[8], txt[9]),
                            educationText, action.image, (short) 150, 3);
                    break;

                case "Salaried Employee":
                    employee = new SalariedEmployee(action.empNo.getText(), txt[0], txt[1], txt[2], txt[3], txt[4], txt[5], txt[6], new Address(txt[7], txt[8], txt[9]),
                            educationText, action.image, 12000);
                    break;

                case "Employee Based Commission":
                    employee = new EmployeeBasedCommission(action.empNo.getText(), txt[0], txt[1], txt[2], txt[3], txt[4], txt[5], txt[6], new Address(txt[7], txt[8], txt[9]),
                            educationText, action.image, 4000, 2000);
                    break;
            }

            String[] emp = new String[]{employee.getFirstName(), employee.getLastname(), employee.getDateOfBirth(), employee.getDesignation(),
                    employee.getEmail(), employee.getPhoneNo(), employee.getNationality(), employee.getAddress().getStreet(), employee.getAddress().getCity(),
                    employee.getAddress().getCountry()};

            int invalidIndex = Statics.checkValid(txt, emp);

            if (invalidIndex == -1) {
                source(txt[5] , type);

            } else {
                try {
                    throw new InvalidException(Statics.invalid[invalidIndex]);
                } catch (InvalidException e) {
                    Statics.alert(button, "error", e.getMessage(), Alert.AlertType.ERROR);
                }
            }
        } else {
            try {
                throw new NullException(Statics.Null[nullIndex]);
            } catch (NullException e) {
                Statics.alert(button, "error", e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    protected void source(String phoneNumber , String type) {
        if (action instanceof Add) {
            if (!addIsExist(phoneNumber)) {

                boolean result = Statics.alert(button, "confirmation", "are you sure you want to add this employee?", Alert.AlertType.CONFIRMATION);
                if (result) {
                    Statics.getList().add(employee);
                    System.out.println(Statics.getList());
                    Statics.alert(button, "information", "employee added successfully", Alert.AlertType.INFORMATION);
                    action.empNo.setText(String.valueOf(Statics.getList().size() + 1000));
                    clear();
                }

            } else {
                try {
                    throw new InvalidException("the employee is already exist");
                } catch (InvalidException e) {
                    Statics.alert(button, "error", e.getMessage(), Alert.AlertType.ERROR);
                }
            }

        } else if (action instanceof Update) {
            if (!updateIsExist(phoneNumber)) {

                try {
                    if (type.equals("Hourly Employee")) {
                        ((HourlyEmployee) employee).setHours(Short.parseShort(action.t1.getText()));
                        ((HourlyEmployee) employee).setRate(Float.parseFloat(action.t2.getText()));
                        action.salarytxt.setText(String.valueOf(employee.payment()));

                    } else if (type.equals("Salaried Employee")) {
                        ((SalariedEmployee) employee).setAnnualSalary(Double.parseDouble(action.t1.getText()));
                        action.salarytxt.setText(String.valueOf(employee.payment()));

                    } else if (type.equals("Employee Based Commission")) {
                        ((EmployeeBasedCommission) employee).setSalary(Double.parseDouble(action.t1.getText()));
                        ((EmployeeBasedCommission) employee).setSoldPerMonth(Double.parseDouble(action.t2.getText()));
                        action.salarytxt.setText(String.valueOf(employee.payment()));
                    }

                    boolean result = Statics.alert(button, "confirmation", "are you sure you want to update this employee?", Alert.AlertType.CONFIRMATION);
                    if (result) {
                        Statics.getList().set(Integer.parseInt(action.empNo.getText()) - 1000, employee);
                        System.out.println(Statics.getList());
                        Statics.alert(button, "information", "employee updated successfully", Alert.AlertType.INFORMATION);
                        updated = true;
                    }
                } catch (NumberFormatException ex) {
                    Statics.alert(((Update) action).getUpdateBtn(), "error", "invalid salary inputs, inter a numerical values", Alert.AlertType.ERROR);
                }

            } else {
                try {
                    throw new InvalidException("the employee is already exist");
                } catch (InvalidException e) {
                    Statics.alert(button, "error", e.getMessage(), Alert.AlertType.ERROR);
                }
            }
        }
    }

    protected static boolean addIsExist(String phoneNumber) {
        int length = Statics.getList().size();
        for (int i = 0; i < length; i++) {
            if (phoneNumber.equals(Statics.getList().get(i).getPhoneNo()))
                return true;
        }
        return false;
    }

    protected boolean updateIsExist(String phoneNumber) {
        int length = Statics.getList().size();
        for (int i = 0; i < length; i++) {
            if (i == (Integer.parseInt(action.empNo.getText()) - 1000))
                continue;

            if (phoneNumber.equals(Statics.getList().get(i).getPhoneNo()))
                return true;

        }
        return false;
    }

    protected void clear() {
        action.fName.setText("");
        action.lName.setText("");
        action.DOB.setText("");
        action.designation.setText("");
        action.email.setText("");
        action.phoneNo.setText("");
        action.nation.setText("");
        action.street.setText("");
        action.city.setText("");
        action.country.setText("");
        action.education.selectToggle(null);
        action.empType.setValue("Hourly Employee");
        action.imageView.setImage(new Image("proj/majhoul.png"));
    }
}
