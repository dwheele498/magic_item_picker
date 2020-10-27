package Items.Minor;

import Items.MagicItemcontainer;
import Items.MagicItems;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Random;

public class MinorUncommon extends MagicItemcontainer {
    public MinorUncommon(){
        super();
        GetTableItems("uncommon","minor");
    }

    @Override
    public void Roll(TreeView<MagicItems> treeView, String selction, int index) {
        Random random = new Random();
        int times = Integer.parseInt(selction);
        if (times < 1 || times > 100) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Roll Value Error");
            alert.setContentText("You must enter a value between 1 and 100");
            alert.showAndWait();
        } else {
            for (int i = 0; i < times; i++) {
                int result = random.nextInt(100);
                System.out.println(result);
                var minorItemSelection = treeView.getRoot().getChildren().get(index);
                var selector = minorItemSelection.getChildren().get(0);

                if (result <= 50) {
                    result = 50;
                    selector.getChildren().add(new TreeItem<MagicItems>(this.getItem(result)));
                } else if (result > 50 && result <= 60) {
                    result = 60;
                    selector.getChildren().add(new TreeItem<>(this.getItem(result)));
                } else if (result > 60 && result <= 70) {
                    result = 70;
                    selector.getChildren().add(new TreeItem<>(this.getItem(result)));
                } else if (result > 70 && result <= 90) {
                    result = 90;
                    selector.getChildren().add(new TreeItem<>(this.getItem(result)));
                } else if (result > 90 && result <= 94) {
                    result = 94;
                    selector.getChildren().add(new TreeItem<>(this.getItem(result)));
                } else if (result > 94 && result <= 98) {
                    result = 98;
                    selector.getChildren().add(new TreeItem<>(this.getItem(result)));
                } else if (result == 99) {
                    selector.getChildren().add(new TreeItem<>(this.getItem(result)));

                } else {
                    selector.getChildren().add(new TreeItem<>(this.getItem(result)));

                }
                selector.setExpanded(true);


            }
        }
    }
    }


