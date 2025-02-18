package proj2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Update extends BaseDesign {

    private Stage stage;

    private String number;

    private Button updateBtn;

    private HBox bottomLeft;

    public Update(Stage stage, String number) {
        this.stage = stage;
        this.number = number;
    }

    public Stage getStage() {
        return stage;
    }

    public Button getUpdateBtn() {
        return updateBtn;
    }

    public String getNumber() {
        return number;
    }

    public void setBottomLeft(HBox bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public HBox bottom() {
        Button btn[] = {nextBtn, prevBtn, updateBtn, backBtn};

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button();
            btn[i].setPrefWidth(235);
            btn[i].setPrefHeight(70);
            btn[i].setStyle("-fx-font-size: 20px; -fx-background-color: #E67526 ;");
        }

        nextBtn = btn[0];
        prevBtn = btn[1];
        updateBtn = btn[2];
        backBtn = btn[3];

        ImageView next = new ImageView(new Image("right.png"));
        next.setFitWidth(60);
        next.setFitHeight(60);
        nextBtn.setGraphic(next);
        nextBtn.setOnAction(new UpdateHandler(this));

        ImageView prev = new ImageView(new Image("prev.png"));
        prev.setFitWidth(60);
        prev.setFitHeight(60);
        prevBtn.setGraphic(prev);
        prevBtn.setOnAction(new UpdateHandler(this));

        ImageView back = new ImageView(new Image("back.png"));
        back.setFitWidth(60);
        back.setFitHeight(60);
        backBtn.setGraphic(back);
        backBtn.setOnAction(new UpdateHandler(this));

        ImageView update = new ImageView(new Image("true.png"));
        update.setFitWidth(60);
        update.setFitHeight(60);
        updateBtn.setGraphic(update);
        updateBtn.setOnAction(new UpdateHandler(this));

        HBox bottom = new HBox(100, backBtn, prevBtn, nextBtn, updateBtn);
        bottom.setAlignment(Pos.CENTER);

        return bottom;
    }

    public BorderPane main() {
        GridPane left = left();
        bottomLeft = empType(number, true, "Hourly Employee");
        left.add(salaryLbl, 0, 11);
        left.add(bottomLeft, 1, 11);
        fill(number);

        HBox bottom = bottom();
        VBox center = center(stage);

        if (Integer.parseInt(empNo.getText().trim()) == 1000) {
            prevBtn.setDisable(true);
        }
        if (Integer.parseInt(empNo.getText().trim()) == 999 + Statics.getList().size()) {
            nextBtn.setDisable(true);
        }

        empType.setOnAction(e -> {
            left.getChildren().remove(bottomLeft);
            bottomLeft = empType(number, false, empType.getValue());
            left.add(bottomLeft, 1, 11);
        });


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
