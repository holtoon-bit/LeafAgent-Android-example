package com.market.leafandroid.repositories.seller;

import com.market.leafandroid.objects.Seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

public class SellerDAOImpl implements SellerDAO {
    private final String path = "jdbc:sqlite:F:\\Codding\\Java\\LeafAgentAndroidApp\\app\\src\\main\\database\\base.db";
    private Connection connection;

    public SellerDAOImpl() {
        try {
            Properties config = new Properties();
            config.setProperty("open_mode", "1");
            connection = DriverManager.getConnection(path, config);
//            connection = DriverManager.getConnection(path);
        } catch (Exception e) {
            System.out.println("error!");
            System.out.println(e);
        }
    }

    @Override
    public void create(Seller seller) {

    }

    @Override
    public Seller read(int id) {
        return null;
    }

    @Override
    public LinkedList<Seller> readAll() {
        LinkedList<Seller> sellers = new LinkedList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM seller");
            while (resultSet.next()) {
                sellers.add(new Seller(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sellers;
    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void delete(Seller seller) {

    }
}
