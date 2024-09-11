/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domen.Dobavljac;
import domen.DomenskiObjekat;
import domen.Porudzbenica;
import java.util.List;

import java.io.FileInputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;

/**
 * @author student1
 */
public class DatabaseBroker {

    private Connection connection;
    private static DatabaseBroker instanca;

    public static DatabaseBroker getInstanca() {
        if (instanca == null) {
            instanca = new DatabaseBroker();
        }
        return instanca;
    }

    public void connect() throws Exception {
        FileInputStream in = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(in);
        // String driver = props.getProperty("driver");
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        //Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        System.out.println("Uspesno uspostavljena konekcija sa bazom!");
    }

    public void disconnect() throws Exception {

        connection.close();
    }

    public void commit() throws Exception {

        connection.commit();
    }

    public void rollback() throws Exception {

        connection.rollback();
    }

    public void insert(DomenskiObjekat domenskiObjekat) throws Exception {
        String upit = "INSERT INTO " + domenskiObjekat.vratiNazivTabele() + " (" + domenskiObjekat.vratiKoloneZaInsert() + ") VALUES (" + domenskiObjekat.vratiVrednostiZaInsert() + ")";
        System.out.println(upit);
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);

        if (domenskiObjekat.isAutoIncrement()) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                domenskiObjekat.setId(rs.getInt(1));
            }
        }

    }

    public List<DomenskiObjekat> findAll(DomenskiObjekat domenskiObjekat) throws Exception {
        String upit = "Select * from " + domenskiObjekat.vratiNazivTabele() + " " + domenskiObjekat.vratiJoinUslov();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(upit);

        return domenskiObjekat.vratiListu(rs);
    }

    public List<DomenskiObjekat> search(DomenskiObjekat domenskiObjekat, String parametar) throws Exception {
        String upit = "Select * from " + domenskiObjekat.vratiNazivTabele() + " " + domenskiObjekat.vratiJoinUslov() + " WHERE " + domenskiObjekat.vratiUslovPretrage(parametar);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(upit);

        return domenskiObjekat.vratiListu(rs);
    }

    public void update(DomenskiObjekat domenskiObjekat) throws Exception {

        String upit = "UPDATE " + domenskiObjekat.vratiNazivTabele() + " SET " + domenskiObjekat.vratiVrednostiZaUpdate() + " WHERE " + domenskiObjekat.vratiUslovZaId();
        System.out.println(upit);
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);

        System.out.println("Uspesno azuriran u bazi!");

    }

    public void delete(DomenskiObjekat domenskiObjekat) throws Exception {
        String upit = "DELETE FROM " + domenskiObjekat.vratiNazivTabele() + " WHERE " + domenskiObjekat.vratiUslovZaId();
        System.out.println(upit);
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);

        System.out.println("Uspesno obrisan iz baze!");

    }

    public DomenskiObjekat findOne(DomenskiObjekat domenskiObjekat) throws Exception {
        String upit = "Select * from " + domenskiObjekat.vratiNazivTabele() + " " + domenskiObjekat.vratiJoinUslovJedan() + " WHERE " + domenskiObjekat.vratiUslovZaId();
        System.out.println(upit);
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(upit);

        return domenskiObjekat.vratiJednog(rs);
    }



}
