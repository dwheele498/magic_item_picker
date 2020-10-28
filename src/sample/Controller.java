package sample;

import Items.MagicItems;
import Items.Major.MajorLegendary;
import Items.Major.MajorRare;
import Items.Major.MajorUncommon;
import Items.Major.MajorVRare;
import Items.Minor.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Controller {
    public TextField common;
    public TextField uncommon;
    public TextField vrare;
    public TextField rare;
    public TextField legend;
    public TextField muncommon;
    public TextField mvrare;
    public TextField mrare;
    public TextField mlegend;
    MinorCommon minComm = new MinorCommon();
    MinorUncommon minorUncommon = new MinorUncommon();
    MinorRare minorRare = new MinorRare();
    MinorVRare minorVRare = new MinorVRare();
    MinorLegendary minorLegendary = new MinorLegendary();
    MajorUncommon majorUncommon = new MajorUncommon();
    MajorRare majorRare = new MajorRare();
    MajorVRare majorVRare = new MajorVRare();
    MajorLegendary majorLegendary = new MajorLegendary();
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
        TreeItem<MagicItems> miUncommonItems = new TreeItem(new MagicItems("Uncommon"));
        TreeItem<MagicItems> minRareItems = new TreeItem(new MagicItems("Rare"));
        TreeItem<MagicItems> minVRareItems = new TreeItem(new MagicItems("Very Rare"));
        TreeItem<MagicItems> minLegendary = new TreeItem(new MagicItems("Legendary"));
        itemTree.getRoot().getChildren().add(majorTier);
        majorItemIndex = itemTree.getRoot().getChildren().indexOf(majorTier);
        var majorItem = itemTree.getRoot().getChildren().get(majorItemIndex);
        majorItem.getChildren().add(miUncommonItems);
        majorItem.getChildren().add(minRareItems);
        majorItem.getChildren().add(minVRareItems);
        majorItem.getChildren().add(minLegendary);
        majorIndex[0] = majorItem.getChildren().indexOf(miUncommonItems);
        majorIndex[1] = majorItem.getChildren().indexOf(minRareItems);
        majorIndex[2] = majorItem.getChildren().indexOf(minVRareItems);
        majorIndex[3] = majorItem.getChildren().indexOf(minLegendary);

    }

    public void MinorCommonRoll() {
        minComm.Roll(itemTree, common.getText(), minorItemIndex, 0);
    }

    public void MinorUncommonRoll() {
        minorUncommon.Roll(itemTree, uncommon.getText(), minorItemIndex, 1);
    }

    public void MinorRareRoll() {
        minorRare.Roll(itemTree, rare.getText(), minorItemIndex, 2);
    }

    public void MinorVRareRoll() {
        minorVRare.Roll(itemTree, vrare.getText(), minorItemIndex, 3);
    }

    public void MinorLegendary() {
        minorLegendary.Roll(itemTree, legend.getText(), minorItemIndex, 4);
    }


    public void MajorUncommonRoll() {
        majorLegendary.Roll(itemTree, muncommon.getText(), majorItemIndex, 0);
    }

    public void MajorRareRoll() {
        majorRare.Roll(itemTree, mrare.getText(), majorItemIndex, 1);
    }

    public void MajorVRareRoll() {
        majorVRare.Roll(itemTree, mvrare.getText(), majorItemIndex, 2);
    }

    public void MajorLegendary() {
        majorLegendary.Roll(itemTree, mlegend.getText(), majorItemIndex, 3);
    }

    public void Reset() {
        var minor = itemTree.getRoot().getChildren().get(0);
        itemTree.getRoot().getChildren().clear();
        ConfigureTreeMinor();
        ConfigureTreeMajor();
        itemTree.getRoot().getChildren().get(minorItemIndex).setExpanded(true);
        itemTree.getRoot().getChildren().get(majorItemIndex).setExpanded(true);
    }

    public void Wipe() {
        SqlOps.ClearTable();
        SqlOps.CreateTable();
        minComm.CreateTreeSection("minor_common.json", "common", "minor");
        minorUncommon.CreateTreeSection("minor_uncommon.json", "uncommon", "minor");
        minorRare.CreateTreeSection("minor_rare.json", "rare", "minor");
        minorVRare.CreateTreeSection("minor_vrare.json", "very rare", "minor");
        minorLegendary.CreateTreeSection("minor_legendary.json", "legendary", "minor");
        majorUncommon.CreateTreeSection("major_uncommon.json", "uncommon", "major");
        majorRare.CreateTreeSection("major_rare.json", "rare", "major");
        majorVRare.CreateTreeSection("major_vrare.json", "very rare", "major");
        majorLegendary.CreateTreeSection("major_legendary.json", "legendary", "major");
    }


    public void initialize() {
        itemTree.setRoot(new TreeItem<MagicItems>(new MagicItems("Item List")));
        ConfigureTreeMinor();
        ConfigureTreeMajor();
        itemTree.getRoot().setExpanded(true);
        itemTree.getRoot().getChildren().get(minorItemIndex).setExpanded(true);
        itemTree.getRoot().getChildren().get(majorItemIndex).setExpanded(true);

    }

}



