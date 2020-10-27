package Items.Minor;

import Items.MagicItemcontainer;
import Items.MagicItems;
import javafx.scene.control.TreeView;

public class MinorVRare extends MagicItemcontainer {
    public MinorVRare(){
        super();
        GetTableItems("very rare","minor");
    }

    @Override
    public void Roll(TreeView<MagicItems> treeView, String selction, int index) {

    }
}
