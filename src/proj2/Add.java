package proj2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Add extends BaseDesign {

    private Stage stage;

    private Button addBtn , clearBtn;

    public Add(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public Button getAddBtn() {
        return addBtn;
    }

    public Button getClearBtn() {
        return clearBtn;
    }

    public HBox bottom() {

        Button btn[] = {addBtn, clearBtn, backBtn};

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new Button();
            btn[i].setPrefWidth(235);
            btn[i].setPrefHeight(70);
            btn[i].setStyle("-fx-font-size: 20px; -fx-background-color: #E67526 ;");
        }

        addBtn = btn[0];
        clearBtn = btn[1];
        backBtn = btn[2];

        ImageView add = new ImageView(new Image("proj/addd.png"));
        add.setFitWidth(60);
        add.setFitHeight(60);
        addBtn.setGraphic(add);
        addBtn.setOnAction(new AddHandler(this));

        ImageView clear = new ImageView(new Image("proj/clear.png"));
        clear.setFitWidth(60);
        clear.setFitHeight(60);
        clearBtn.setGraphic(clear);
        clearBtn.setOnAction(new AddHandler(this));

        ImageView back = new ImageView(new Image("proj/back.png"));
        back.setFitWidth(60);
        back.setFitHeight(60);
        backBtn.setGraphic(back);
        backBtn.setOnAction(new AddHandler(this));


        HBox btns = new HBox(100, backBtn, clearBtn, addBtn);
        btns.setAlignment(Pos.TOP_CENTER);
        return btns;
    }

    public BorderPane main() {
        GridPane left = left();
        VBox center = center(stage);
        HBox bottom = bottom();
        empNo.setText(String.valueOf(Statics.getList().size() + 1000));

        BorderPane main = new BorderPane();
        main.setLeft(left);
        main.setCenter(center);
        BorderPane.setAlignment(center, Pos.CENTER);
        main.setBottom(bottom);
        BorderPane.setAlignment(bottom, Pos.TOP_CENTER);
        BorderPane.setMargin(bottom, new Insets(0, 0, 100, 0));
        main.setStyle("-fx-background-color: linear-gradient(to bottom,#3B3B3B, #939393);");
        return main;
    }
}

