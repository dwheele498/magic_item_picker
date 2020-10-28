package Items;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import sample.SqlOps;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public abstract class MagicItemcontainer {
    HashMap<Integer, MagicItems> containerMap;

    public MagicItemcontainer() {
        containerMap = new HashMap<>();
    }

    public void addItem(int rollEnd, MagicItems items) {
        containerMap.put(rollEnd, items);
    }

    public Collection<MagicItems> getList() {
        return containerMap.values();
    }

    public MagicItems getItem(int roll) {
        return containerMap.get(roll);
    }

    public void CreateTreeSection(String jsonFileLocation, String rarity, String tier) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(jsonFileLocation));
            List<MagicItems> commonMagicItems = new Gson().fromJson(reader, new TypeToken<List<MagicItems>>() {
            }.getType());
            System.out.println(commonMagicItems.get(0).getRollStart());
            for (MagicItems item : commonMagicItems) {
                item.setRolls();
                item.setRarity(rarity);
                item.setTier(tier);
                this.addItem(item.rollEnd, item);
                SqlOps.InsertTable(item);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void GetTableItems(String rarity, String tier) {
        var rs = SqlOps.SelectTable(rarity, tier);
        ArrayList<MagicItems> items = new ArrayList<>();
        for (String s : rs
        ) {
            var split = s.split("_");
            var i = new MagicItems(split[0], split[1], Integer.parseInt(split[3]), Integer.parseInt(split[2]));
            i.setTier(split[4]);
            i.setRarity(split[5]);
            items.add(i);
        }
        for (MagicItems item : items) {
            this.addItem(item.rollEnd, item);

        }

    }

    public void Roll(TreeView<MagicItems> treeView, String selction, int index, int treeSectionIndex) {
        Random random = new Random();
        int times = Integer.parseInt(selction);
        if (times < 1 || times > 20) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Roll Value Error");
            alert.setContentText("You must enter a value between 1 and 100");
            alert.showAndWait();
        } else {
            for (int i = 0; i < times; i++) {
                var minorItemSelection = treeView.getRoot().getChildren().get(index);
                var selector = minorItemSelection.getChildren().get(treeSectionIndex);
                ArrayList<Integer> options = new ArrayList<>();
                for (MagicItems item : getList()
                ) {
                    options.add(item.getRollEnd());
                }
                var result = options.get(random.nextInt(options.size()));
                selector.getChildren().add(new TreeItem<MagicItems>(this.getItem(result)));
            }
        }
    }
}

