package proj2;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public abstract class BaseTableView {

    protected TableView<Employee> tableView = new TableView<>();

    protected TableColumn<Employee, String> empNo = new TableColumn<>("Employee number");
    protected TableColumn<Employee, String> fName = new TableColumn<>("First name");
    protected TableColumn<Employee, String> lname = new TableColumn<>("Last name");
    protected TableColumn<Employee, String> DOB = new TableColumn<>("Date of birth");
    protected TableColumn<Employee, String> dest = new TableColumn<>("Designation");
    protected TableColumn<Employee, String> email = new TableColumn<>("Email");
    protected TableColumn<Employee, String> phoneNo = new TableColumn<>("Phone number");
    protected TableColumn<Employee, String> nation = new TableColumn<>("Nationality");
    protected TableColumn<Employee, String> address = new TableColumn<>("Address");

    protected TableColumn<Employee, String> education = new TableColumn<>("Education");
    protected TableColumn<Employee, String> empTyoe = new TableColumn<>("Employee type");
    protected TableColumn<Employee, String> salary = new TableColumn<>("Salary");

    public void setTableView() {
        empNo.setCellValueFactory(new PropertyValueFactory<>("empNo"));
        fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        DOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        dest.setCellValueFactory(new PropertyValueFactory<>("designation"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        nation.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        education.setCellValueFactory(new PropertyValueFactory<>("education"));
        empTyoe.setCellValueFactory(type -> new SimpleStringProperty(type.getValue().getClass().getSimpleName()));
        salary.setCellValueFactory(salary -> new SimpleStringProperty(String.valueOf(salary.getValue().payment())));

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        empNo.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        fName.prefWidthProperty().bind(tableView.widthProperty().multiply(0.07));
        lname.prefWidthProperty().bind(tableView.widthProperty().multiply(0.07));
        DOB.prefWidthProperty().bind(tableView.widthProperty().multiply(0.07));
        dest.prefWidthProperty().bind(tableView.widthProperty().multiply(0.07));
        email.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        phoneNo.prefWidthProperty().bind(tableView.widthProperty().multiply(0.08));
        nation.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1));
        address.prefWidthProperty().bind(tableView.widthProperty().multiply(0.18));
        education.prefWidthProperty().bind(tableView.widthProperty().multiply(0.08));
        empTyoe.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        salary.prefWidthProperty().bind(tableView.widthProperty().multiply(0.05));

        tableView.getColumns().addAll(empNo, fName, lname, DOB, dest, email, phoneNo, nation, address, education, empTyoe, salary);
    }
}
