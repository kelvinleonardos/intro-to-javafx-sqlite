package introsqlite.controller;

import introsqlite.config.DatabaseConnection;
import introsqlite.model.Mahasiswa;
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

	public ObservableList<Mahasiswa> selectAll() {
        String sql = "SELECT * FROM mahasiswa";
        ObservableList<Mahasiswa> data = FXCollections.observableArrayList();


        try (Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa(
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("prodi")
                );
                data.add(mahasiswa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return data;
    }

	public Mahasiswa select(String nim) {
		String sql = "SELECT nim, nama, prodi FROM mahasiswa WHERE nim = ?";
		Mahasiswa mahasiswa = null;
		try (Connection conn = DatabaseConnection.connect();
		 	PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nim);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				mahasiswa = new Mahasiswa(
					rs.getString("nim"),
					rs.getString("nama"),
					rs.getString("prodi")
				);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return mahasiswa;
	}

	public void update(String nim, String nama, String prodi) {
    	String sql = "UPDATE mahasiswa SET nama = ?, prodi = ? WHERE nim = ?";
    	try (Connection conn = DatabaseConnection.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, nama);
        	pstmt.setString(2, prodi);
        	pstmt.setString(3, nim);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil diperbarui.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}

	public void delete(String nim) {
    	String sql = "DELETE FROM mahasiswa WHERE nim = ?";
    	try (Connection conn = DatabaseConnection.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, nim);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil dihapus.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}

}
