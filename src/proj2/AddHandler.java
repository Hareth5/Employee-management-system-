package proj2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AddHandler extends BaseHandler implements EventHandler<ActionEvent> {

    private Add add;

    public AddHandler(Add add) {
        super(add);
        this.add = add;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() == add.getAddBtn()) {
            handler();
        } else if (actionEvent.getSource() == add.getClearBtn()) {
            clear();
        } else if (actionEvent.getSource() == add.backBtn) {
            Main.setCenterContent(new MainInterface(add.getStage()).mainInterface());
        }
    }
}
