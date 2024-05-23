package introsqlite.controller;

import introsqlite.config.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MahasiswaController {

	public void createTable() {
    	String sql = "CREATE TABLE IF NOT EXISTS mahasiswa ("
               	+ " nim TEXT PRIMARY KEY,"
               	+ " nama TEXT NOT NULL,"
               	+ " prodi TEXT NOT NULL"
               	+ ");";
    	try (Connection conn = DatabaseConnection.connect();
         	Statement stmt = conn.createStatement()) {
        	stmt.execute(sql);
        	System.out.println("Tabel berhasil dibuat.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}

	public void insert(String nim, String nama, String prodi) {
		createTable();
    	String sql = "INSERT INTO mahasiswa(nim, nama, prodi) VALUES(?, ?, ?)";
    	try (Connection conn = DatabaseConnection.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, nim);
        	pstmt.setString(2, nama);
			pstmt.setString(3, prodi);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil ditambahkan.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}

	public ObservableList<Contact> selectAll() {
    	String sql = "SELECT id, name, email FROM contacts";
    	ObservableList<Contact> contacts = FXCollections.observableArrayList();

    	try (Connection conn = DatabaseConnection.connect();
         	Statement stmt = conn.createStatement();
         	ResultSet rs = stmt.executeQuery(sql)) {

        	while (rs.next()) {
            	Contact contact = new Contact(
                    	rs.getInt("id"),
                    	rs.getString("name"),
                    	rs.getString("email")
            	);
            	contacts.add(contact);
        	}
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}

    	return contacts;
	}

	public void update(int id, String name, String email) {
    	String sql = "UPDATE contacts SET name = ?, email = ? WHERE id = ?";
    	try (Connection conn = DatabaseConnection.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, name);
        	pstmt.setString(2, email);
        	pstmt.setInt(3, id);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil diperbarui.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}

	public void delete(int id) {
    	String sql = "DELETE FROM contacts WHERE id = ?";
    	try (Connection conn = DatabaseConnection.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, id);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil dihapus.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}

	public static class Contact {
    	private int id;
    	private String name;
    	private String email;

    	public Contact(int id, String name, String email) {
        	this.id = id;
        	this.name = name;
        	this.email = email;
    	}

    	public int getId() {
        	return id;
    	}

    	public String getName() {
        	return name;
    	}

    	public String getEmail() {
        	return email;
    	}
	}
}
