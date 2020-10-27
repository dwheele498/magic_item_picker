package sample;

import Items.MagicItems;
import Items.Minor.MinorCommon;
import Items.Minor.MinorRare;
import Items.Minor.MinorUncommon;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.Random;

public class Controller {
    public TextField common;
        MinorCommon minComm = new MinorCommon();
       MinorUncommon minorUncommon = new MinorUncommon();
       MinorRare minorRare = new MinorRare();
    @FXML
    TreeView<MagicItems> itemTree;
    int minorItemIndex = 0;
    int majorItemIndex = 0;
    int[] minorIndex = new int[5];
    int[] majorIndex = new int[5];

    public Controller() {
    }



    public void ConfigureTreeMinor() {
        TreeItem<MagicItems> minorTier = new TreeItem<>(new MagicItems("Minor Items"));
        TreeItem<MagicItems> micommonItems = new TreeItem(new MagicItems("Common"));
        TreeItem<MagicItems> miUncommonItems = new TreeItem(new MagicItems("Uncommon"));
        TreeItem<MagicItems> minRareItems = new TreeItem(new MagicItems("Rare"));
        TreeItem<MagicItems> minVRareItems = new TreeItem(new MagicItems("Very Rare"));
        TreeItem<MagicItems> minLegendary = new TreeItem(new MagicItems("Legendary"));
        itemTree.getRoot().getChildren().add(minorTier);
        minorItemIndex = itemTree.getRoot().getChildren().indexOf(minorTier);
        var minorItem = itemTree.getRoot().getChildren().get(minorItemIndex);
        minorItem.getChildren().add(micommonItems);
        minorItem.getChildren().add(miUncommonItems);
        minorItem.getChildren().add(minRareItems);
        minorItem.getChildren().add(minVRareItems);
        minorItem.getChildren().add(minLegendary);
        minorIndex[0] = minorItem.getChildren().indexOf(micommonItems);
        minorIndex[1] = minorItem.getChildren().indexOf(miUncommonItems);
        minorIndex[2] = minorItem.getChildren().indexOf(minRareItems);
        minorIndex[3] = minorItem.getChildren().indexOf(minVRareItems);
        minorIndex[4] = minorItem.getChildren().indexOf(minLegendary);

    }

    public void ConfigureTreeMajor() {
        TreeItem<MagicItems> majorTier = new TreeItem<>(new MagicItems("Major Items"));
        TreeItem<MagicItems> micommonItems = new TreeItem(new MagicItems("Common"));
        TreeItem<MagicItems> miUncommonItems = new TreeItem(new MagicItems("Uncommon"));
        TreeItem<MagicItems> minRareItems = new TreeItem(new MagicItems("Rare"));
        TreeItem<MagicItems> minVRareItems = new TreeItem(new MagicItems("Very Rare"));
        TreeItem<MagicItems> minLegendary = new TreeItem(new MagicItems("Legendary"));
        itemTree.getRoot().getChildren().add(majorTier);
        majorItemIndex = itemTree.getRoot().getChildren().indexOf(majorTier);
        var majorItem = itemTree.getRoot().getChildren().get(majorItemIndex);
        majorItem.getChildren().add(micommonItems);
        majorItem.getChildren().add(miUncommonItems);
        majorItem.getChildren().add(minRareItems);
        majorItem.getChildren().add(minVRareItems);
        majorItem.getChildren().add(minLegendary);
        minorIndex[0] = majorItem.getChildren().indexOf(micommonItems);
        minorIndex[1] = majorItem.getChildren().indexOf(miUncommonItems);
        minorIndex[2] = majorItem.getChildren().indexOf(minRareItems);
        minorIndex[3] = majorItem.getChildren().indexOf(minVRareItems);
        minorIndex[4] = majorItem.getChildren().indexOf(minLegendary);

    }

    public void MinorCommonRoll(){
        minComm.Roll(itemTree,common.getText(),minorItemIndex);
    }

    public void Reset() {
        var minor = itemTree.getRoot().getChildren().get(0);
        itemTree.getRoot().getChildren().clear();
        ConfigureTreeMinor();
        minor.setExpanded(true);
    }





    public void initialize() {
        itemTree.setRoot(new TreeItem<MagicItems>(new MagicItems("Item List")));
        ConfigureTreeMinor();
        ConfigureTreeMajor();
//        SqlOps.ClearTable();
//        SqlOps.CreateTable();
//        minComm.GetTableItems("common", "minor");
//        minorUncommon.GetTableItems("uncommon","minor");
//        minComm.CreateTreeSection("minor_common.json","common","minor");
//        minorUncommon.CreateTreeSection("minor_uncommon.json","uncommon","minor");
//        minorRare.CreateTreeSection("minor_rare.json","rare","minor");
        minComm.GetTableItems("common","tier");
        
        itemTree.getRoot().setExpanded(true);
        itemTree.getRoot().getChildren().get(minorItemIndex).setExpanded(true);
        itemTree.getRoot().getChildren().get(majorItemIndex).setExpanded(true);

    }

}



