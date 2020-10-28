package Items;

public class MagicItems {
    public String name;
    public int rollStart;
    public int rollEnd;
    public String url;
    public int[] range;
    public String tier;
    public String rarity;

    public MagicItems(String name) {
        this.name = name;
    }

    public MagicItems(String name, String url, int rollEnd, int rollStart) {
        this.name = name;
        this.rollEnd = rollEnd;
        this.rollStart = rollStart;
        this.url = url;


    }

    public MagicItems(String name, String url, int[] range) {
        this.name = name;
        this.range = range;
        this.rollEnd = this.range[1];
        this.rollStart = this.range[0];
        this.url = url;


    }

    public void setRolls() {
        rollStart = range[0];
        rollEnd = range[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollStart() {
        return rollStart;
    }

    public void setRollStart(int rollStart) {
        this.rollStart = rollStart;
    }

    public int getRollEnd() {
        return rollEnd;
    }

    public void setRollEnd(int rollEnd) {
        this.rollEnd = rollEnd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String toString() {
        return (name);
    }

}
