/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author amnan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestDAO {

    // Cari guest berdasarkan ID (NIK)
    public Guest findById(int guestId) {
        String query = "SELECT * FROM guest WHERE guest_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, guestId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Guest(
                            rs.getInt("guest_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone_number")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding guest: " + e.getMessage());
        }

        return null;
    }

    // Tambahkan guest baru
    public boolean insert(Guest guest) {
        String query = "INSERT INTO guest (guest_id, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, guest.getGuestId());
            stmt.setString(2, guest.getFirstName());
            stmt.setString(3, guest.getLastName());
            stmt.setString(4, guest.getEmail());
            stmt.setString(5, guest.getPhoneNumber());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Insert guest failed: " + e.getMessage());
            return false;
        }
    }
}
