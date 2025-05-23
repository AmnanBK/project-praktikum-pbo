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
import java.util.Properties;
import org.jdatepicker.impl.*;

public class ReservationFormView extends BaseView {

    private JTextField tfFirstName, tfLastName;
    private JComboBox<String> cbRoomType, cbRoomNumber;
    private JDatePickerImpl dateCheckIn, dateCheckOut;
    private JButton btnSubmit, btnBack;

    public ReservationFormView() {
        super("Create Reservation", 450, 400);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Component setup
        tfFirstName = new JTextField();
        tfLastName = new JTextField();
        cbRoomType = new JComboBox<>(new String[] { "Standard", "Deluxe", "Suite" });
        cbRoomNumber = new JComboBox<>(new String[] { "101", "102", "201", "202" });

        // Date picker setup
        UtilDateModel modelCheckIn = new UtilDateModel();
        UtilDateModel modelCheckOut = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanelCheckIn = new JDatePanelImpl(modelCheckIn, p);
        JDatePanelImpl datePanelCheckOut = new JDatePanelImpl(modelCheckOut, p);

        dateCheckIn = new JDatePickerImpl(datePanelCheckIn, new DateLabelFormatter());
        dateCheckOut = new JDatePickerImpl(datePanelCheckOut, new DateLabelFormatter());

        btnSubmit = new JButton("Submit");
        btnBack = new JButton("Back");

        // Add components
        int y = 0;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1; add(tfFirstName, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1; add(tfLastName, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Room Type:"), gbc);
        gbc.gridx = 1; add(cbRoomType, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Room Number:"), gbc);
        gbc.gridx = 1; add(cbRoomNumber, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Check-in Date:"), gbc);
        gbc.gridx = 1; add(dateCheckIn, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Check-out Date:"), gbc);
        gbc.gridx = 1; add(dateCheckOut, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(btnBack, gbc);
        gbc.gridx = 1; add(btnSubmit, gbc);

        setVisible(true);
    }

    // Getters
    public String getFirstName() { return tfFirstName.getText().trim(); }
    public String getLastName() { return tfLastName.getText().trim(); }
    public String getRoomType() { return (String) cbRoomType.getSelectedItem(); }
    public String getRoomNumber() { return (String) cbRoomNumber.getSelectedItem(); }

    public java.util.Date getCheckInDate() {
        return (java.util.Date) dateCheckIn.getModel().getValue();
    }

    public java.util.Date getCheckOutDate() {
        return (java.util.Date) dateCheckOut.getModel().getValue();
    }

    public JButton getBtnSubmit() { return btnSubmit; }
    public JButton getBtnBack() { return btnBack; }
}

