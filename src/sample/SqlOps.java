package sample;

import Items.MagicItems;

import java.sql.*;
import java.util.ArrayList;

public class SqlOps {
    public static Connection c = null;
    public static String url = "jdbc:sqlite:items.db";

    public static void CreateConnection() {


        try {
            c = DriverManager.getConnection(url);
            if (c != null) {
                DatabaseMetaData meta = c.getMetaData();
                System.out.println(meta);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CreateTable() {
        String sql = "CREATE TABLE IF NOT EXISTS magic_items(id INTEGER PRIMARY KEY AUTOINCREMENT, item_name string, item_url string,roll_start int, roll_end int,tier string, rarity string)";
        try {
            c = DriverManager.getConnection(url);
            Statement statement = c.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ClearTable() {
        String sql = "DROP TABLE magic_items";
        try {
            c = DriverManager.getConnection(url);
            Statement statement = c.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void InsertTable(MagicItems items) {
        String sql = "INSERT INTO magic_items(item_name,item_url,roll_start,roll_end,tier,rarity) VALUES (?,?,?,?,?,?)";
        try {
            c = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, items.getName());
            preparedStatement.setString(2, items.getUrl());
            preparedStatement.setInt(3, items.getRollStart());
            preparedStatement.setInt(4, items.getRollEnd());
            preparedStatement.setString(5, items.getTier());
            preparedStatement.setString(6, items.getRarity());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> SelectTable(String rarity, String tier) {
        ArrayList<String> results = new ArrayList<String>();
        String sql = "SELECT item_name,item_url,roll_start,roll_end,tier,rarity FROM magic_items WHERE rarity=? and tier=?";
        try {
            c = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, rarity);
            preparedStatement.setString(2, tier);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                results.add(rs.getString("item_name") + "_" + rs.getString("item_url") + "_" +
                        rs.getInt("roll_start") + "_" + rs.getInt("roll_end") + "_" +
                        rs.getString("tier") + "_" + rs.getString("rarity"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;


    }


}
