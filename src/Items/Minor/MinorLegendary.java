package Items.Minor;

import Items.MagicItemcontainer;
import Items.MagicItems;
import javafx.scene.control.TreeView;

public class MinorLegendary extends MagicItemcontainer {
    public MinorLegendary(){
        super();
        GetTableItems("legendary","minor");
    }

    @Override
    public void Roll(TreeView<MagicItems> treeView, String selction, int index) {

    }
}
