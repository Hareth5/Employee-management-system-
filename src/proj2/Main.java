package proj2;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private static BorderPane borderPane = new BorderPane();
    private MainInterface mainInterface;

    public static void setCenterContent(Node node) {
        borderPane.setCenter(node);
    }

    @Override
    public void start(Stage stage) {
        mainInterface = new MainInterface(stage);

        Menu emp = new Menu("Employee");

        MenuItem addMenuItem = new MenuItem("Add");
        addMenuItem.setOnAction(e -> setCenterContent(new Add(stage).main()));
        addMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));

        MenuItem viewMenuItem = new MenuItem("View");
        viewMenuItem.setOnAction(e -> setCenterContent(new View(stage).main()));
        viewMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));

        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setOnAction(e -> mainInterface.save.fire());
        saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        MenuItem readMenuItem = new MenuItem("Read");
        readMenuItem.setOnAction(e -> mainInterface.read.fire());
        readMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));

        emp.getItems().addAll(addMenuItem, viewMenuItem, saveMenuItem, readMenuItem);

        Menu stat = new Menu("Statical Report");

        Menu close = new Menu("Close");
        MenuItem closeMenuItem = new MenuItem("Exit");

        closeMenuItem.setOnAction(e -> stage.close());
        closeMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        close.getItems().add(closeMenuItem);

        MenuBar bar = new MenuBar();
        bar.getMenus().addAll(emp, stat, close);

        TabPane tab = new TabPane();

        Tab empTab = new Tab("Employee Record");
        empTab.setOnSelectionChanged(e -> {
            setCenterContent(mainInterface.mainInterface());
        });

        Tab statTab = new Tab("Statical Report");

        tab.getTabs().addAll(empTab, statTab);

        VBox top = new VBox();
        top.getChildren().addAll(bar, tab);

        borderPane.setTop(top);
        borderPane.setCenter(mainInterface.mainInterface());

        Scene scene = new Scene(borderPane, 900, 720);
        stage.setMaximized(true);
        stage.setTitle("Employee Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
