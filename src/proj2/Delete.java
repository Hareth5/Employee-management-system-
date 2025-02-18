package proj2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Delete extends BaseDesign {

    private Stage stage;

    private String number;

    private Button deleteBtn;

    private HBox bottomLeft;

    public Delete(Stage stage, String number) {
        this.stage = stage;
        this.number = number;
    }

    public Stage getStage() {
        return stage;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public String getNumber() {
        return number;
    }

    public void setBottomLeft(HBox bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public HBox bottom() {
        Button btn[] = {nextBtn, prevBtn, deleteBtn, backBtn};

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button();
            btn[i].setPrefWidth(235);
            btn[i].setPrefHeight(70);
            btn[i].setStyle("-fx-font-size: 20px; -fx-background-color: #E67526 ;");
        }

        nextBtn = btn[0];
        prevBtn = btn[1];
        deleteBtn = btn[2];
        backBtn = btn[3];

        ImageView next = new ImageView(new Image("proj/right.png"));
        next.setFitWidth(60);
        next.setFitHeight(60);
        nextBtn.setGraphic(next);
        nextBtn.setOnAction(new DeleteHandler(this));

        ImageView prev = new ImageView(new Image("proj/prev.png"));
        prev.setFitWidth(60);
        prev.setFitHeight(60);
        prevBtn.setGraphic(prev);
        prevBtn.setOnAction(new DeleteHandler(this));

        ImageView back = new ImageView(new Image("proj/back.png"));
        back.setFitWidth(60);
        back.setFitHeight(60);
        backBtn.setGraphic(back);
        backBtn.setOnAction(new DeleteHandler(this));

        ImageView delete = new ImageView(new Image("proj/removee.png"));
        delete.setFitWidth(60);
        delete.setFitHeight(60);
        deleteBtn.setGraphic(delete);
        deleteBtn.setOnAction(new DeleteHandler(this));

        HBox bottom = new HBox(100, backBtn, prevBtn, nextBtn, deleteBtn);
        bottom.setAlignment(Pos.CENTER);

        return bottom;
    }

    public BorderPane main() {
        GridPane left = left();
        bottomLeft = empType(number, true, "Hourly Employee");

        left.add(salaryLbl, 0, 11);
        left.add(bottomLeft, 1, 11);
        fill(number);

        TextField arr[] = {fName, lName, DOB, designation, email, phoneNo, nation, street, city, country};
        for (int i = 0; i < arr.length; i++) {
            arr[i].setEditable(false);
            arr[i].setStyle("-fx-text-fill: #555555; -fx-border-color: gray; -fx-border-width: 1; -fx-background-color: white;");

        }

        fName = arr[0];
        lName = arr[1];
        DOB = arr[2];
        designation = arr[3];
        email = arr[4];
        phoneNo = arr[5];
        nation = arr[6];
        street = arr[7];
        city = arr[8];
        country = arr[9];

        int size = education.getToggles().size();
        for (int i = 0; i < size; i++) {
            RadioButton rb = (RadioButton) education.getToggles().get(i);
            rb.setDisable(true);
        }
        empType.setDisable(true);

        HBox bottom = bottom();
        VBox center = center(stage);

        if (Integer.parseInt(empNo.getText().trim()) == 1000) {
            prevBtn.setDisable(true);
        }
        if (Integer.parseInt(empNo.getText().trim()) == 999 + Statics.getList().size()) {
            nextBtn.setDisable(true);
        }

        BorderPane main = new BorderPane();
        main.setLeft(left);
        main.setCenter(center);
        BorderPane.setAlignment(center, Pos.CENTER);
        main.setBottom(bottom);
        BorderPane.setAlignment(bottom, Pos.CENTER);
        BorderPane.setMargin(bottom, new Insets(0, 0, 50, 0));
        main.setStyle("-fx-background-color: linear-gradient(to bottom,#3B3B3B, #939393);");
        return main;
    }
}

