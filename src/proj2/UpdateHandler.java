package proj2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UpdateHandler extends BaseHandler implements EventHandler<ActionEvent> {

    private Update update;
    private Delete delete;

    public UpdateHandler(Update update) {
        super(update);
        this.update = update;
    }

    public void handle(ActionEvent actionEvent) {

        int index = Integer.parseInt(update.getNumber()) - 1000;

        Employee employee = Statics.getList().get(index);

        if (actionEvent.getSource() == update.getUpdateBtn()) {
            handler();

        } else if (actionEvent.getSource() == update.backBtn) {
            if (updated)
                Main.setCenterContent(new View(update.getStage()).main());
            else {
                Statics.getList().set(index, employee);
                Main.setCenterContent(new View(update.getStage()).main());
            }
        }
        else if (actionEvent.getSource() == update.nextBtn) {
            Main.setCenterContent(new Update(update.getStage() , (Integer.parseInt(update.getNumber()) + 1) + "").main());
        }
        else if (actionEvent.getSource() == update.prevBtn) {
            Main.setCenterContent(new Update(update.getStage() , (Integer.parseInt(update.getNumber()) - 1) + "").main());
        }
    }
}
