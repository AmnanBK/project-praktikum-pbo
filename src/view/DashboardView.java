/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author amnan
 */

import javax.swing.*;
import java.awt.*;

public class DashboardView extends BaseView {

    private JButton btnCreateReservation;
    private JButton btnViewReservations;
    private JButton btnRoomDetails;

    public DashboardView() {
        super("Hotel Reservation", 400, 250);
        setLayout(new BorderLayout());

        // Judul atas
        JLabel lblTitle = new JLabel("Hotel Reservation ", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Panel tombol di tengah
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(3, 1, 10, 10));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));

        btnCreateReservation = new JButton("Create Reservation");
        btnViewReservations = new JButton("View Reservations");
        btnRoomDetails = new JButton("Room Details");

        panelButtons.add(btnCreateReservation);
        panelButtons.add(btnViewReservations);
        panelButtons.add(btnRoomDetails);

        add(panelButtons, BorderLayout.CENTER);

        setVisible(true);
    }

    // Getter untuk menghubungkan ke controller
    public JButton getBtnCreateReservation() {
        return btnCreateReservation;
    }

    public JButton getBtnViewReservations() {
        return btnViewReservations;
    }

    public JButton getBtnRoomDetails() {
        return btnRoomDetails;
    }
}
