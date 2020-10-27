package Items.Minor;

import Items.MagicItemcontainer;
import Items.MagicItems;
import javafx.scene.control.TreeView;

public class MinorRare extends MagicItemcontainer {
    public MinorRare(){
        super();
        GetTableItems("rare","minor");
    }

    @Override
    public void Roll(TreeView<MagicItems> treeView, String selction, int index) {

    }
}
