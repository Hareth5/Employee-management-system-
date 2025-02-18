package proj2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class DeleteHandler implements EventHandler<ActionEvent> {

    private Delete delete;

    public DeleteHandler(Delete delete) {
        this.delete = delete;
    }

    public void handle(ActionEvent actionEvent) {

        int index = Integer.parseInt(delete.getNumber()) - 1000;

        if (actionEvent.getSource() == delete.getDeleteBtn()) {
            boolean result = Statics.alert(delete.getDeleteBtn(), "confirmation", "Are you sure you want to remove this employee?", Alert.AlertType.CONFIRMATION);
            if (result) {
                Statics.getList().remove(index);
                int length = Statics.getList().size();
                for (int i = index; i < length; i++) {
                    Statics.getList().get(i).setEmpNo(String.valueOf(1000 + i));
                }

                if (Statics.getList().isEmpty()) {
                    Main.setCenterContent(new View(delete.getStage()).main());

                } else if (index < Statics.getList().size()) {
                    Main.setCenterContent(new Delete(delete.getStage(), String.valueOf(1000 + index)).main());

                } else {
                    Main.setCenterContent(new Delete(delete.getStage(), String.valueOf(1000 + index - 1)).main());
                }
            }
        } else if (actionEvent.getSource() == delete.backBtn) {
            Main.setCenterContent(new View(delete.getStage()).main());

        } else if (actionEvent.getSource() == delete.nextBtn) {
            Main.setCenterContent(new Delete(delete.getStage(), (Integer.parseInt(delete.getNumber()) + 1) + "").main());

        } else if (actionEvent.getSource() == delete.prevBtn) {
            Main.setCenterContent(new Delete(delete.getStage(), (Integer.parseInt(delete.getNumber()) - 1) + "").main());
        }
    }
}
