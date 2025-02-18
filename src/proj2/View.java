package proj2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View extends BaseTableView {
    private Stage stage;
    private Button backBtn, searchBtn, deleteBtn, updateBtn;
    private ObservableList<Employee> observableList = FXCollections.observableArrayList(Statics.getList());

    public Stage getStage() {
        return stage;
    }

    public View(Stage stage) {
        this.stage = stage;
    }

    public VBox top() {
        Label empNoLabel = new Label("Employee No :");
        empNoLabel.setFont(new Font(20));
        empNoLabel.setStyle("-fx-text-fill: white;");
        TextField empNoField = new TextField();

        HBox empNoBox = new HBox(10, empNoLabel, empNoField);
        empNoBox.setAlignment(Pos.CENTER);
        empNoBox.setPadding(new Insets(20));

        Button btn[] = {backBtn, searchBtn, updateBtn, deleteBtn};
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button();
            btn[i].setPrefWidth(235);
            btn[i].setPrefHeight(70);
            btn[i].setStyle("-fx-font-size: 20px; -fx-background-color: #E67526 ;");
        }

        backBtn = btn[0];
        searchBtn = btn[1];
        updateBtn = btn[2];
        deleteBtn = btn[3];
        updateBtn.setDisable(true);
        deleteBtn.setDisable(true);

        backBtn.setOnAction(e -> Main.setCenterContent(new MainInterface(getStage()).mainInterface()));

        searchBtn.setOnAction(e -> {
            String empNo = empNoField.getText();
            if (!empNo.isEmpty()) {
                int length = Statics.getList().size(), index = -1;

                for (int i = 0; i < length; i++) {
                    if (empNo.equals(Statics.getList().get(i).getEmpNo())) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    updateBtn.setDisable(false);
                    deleteBtn.setDisable(false);
                    observableList.clear();
                    observableList.add(Statics.getList().get(index));
                    tableView.setItems(observableList);
                } else {

                    try {
                        throw new InvalidException("inter a valid employee number");
                    } catch (InvalidException ex) {
                        Statics.alert(searchBtn, "error", ex.getMessage(), Alert.AlertType.ERROR);
                    }
                }
            } else {

                try {
                    throw new NullException("you must enter an employee number");
                } catch (NullException ex) {
                    Statics.alert(searchBtn, "error", ex.getMessage(), Alert.AlertType.ERROR);
                }
            }
        });

        updateBtn.setOnAction(e -> Main.setCenterContent(new Update(getStage(), empNoField.getText().trim()).main()));
        deleteBtn.setOnAction(e -> Main.setCenterContent(new Delete(getStage(), empNoField.getText().trim()).main()));

        ImageView back = new ImageView(new Image("back.png"));
        back.setFitWidth(60);
        back.setFitHeight(60);
        backBtn.setGraphic(back);

        ImageView search = new ImageView(new Image("search.png"));
        search.setFitWidth(60);
        search.setFitHeight(60);
        searchBtn.setGraphic(search);

        ImageView update = new ImageView(new Image("update.png"));
        update.setFitWidth(60);
        update.setFitHeight(60);
        updateBtn.setGraphic(update);

        ImageView delete = new ImageView(new Image("remove.png"));
        delete.setFitWidth(60);
        delete.setFitHeight(60);
        deleteBtn.setGraphic(delete);

        HBox buttons = new HBox(100, backBtn, searchBtn, updateBtn, deleteBtn);
        buttons.setAlignment(Pos.CENTER);

        VBox top = new VBox(10, empNoBox, buttons);
        top.setAlignment(Pos.TOP_CENTER);
        top.setPadding(new Insets(20));
        return top;
    }

    public TableView center() {
        setTableView();
        tableView.setItems(observableList);
        return tableView;
    }

    public BorderPane main() {
        BorderPane main = new BorderPane();
        VBox top = top();
        TableView<Employee> center = center();

        main.setTop(top);
        main.setCenter(center);

        main.setStyle("-fx-background-color: linear-gradient(to bottom,#3B3B3B, #939393);");
        return main;
    }
}
