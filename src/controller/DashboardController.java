/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author amnan
 */

import view.DashboardView;
import view.ReservationFormView;
import view.ReservationListView;
import view.RoomDetailsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardController {

    private DashboardView dashboardView;

    public DashboardController(DashboardView view) {
        this.dashboardView = view;

        // Event handling
        dashboardView.getBtnCreateReservation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReservationFormView(); // Show form for new reservation
                dashboardView.dispose();
            }
        });

        dashboardView.getBtnViewReservations().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReservationListView(); // Show reservation list
                dashboardView.dispose();
            }
        });

        dashboardView.getBtnRoomDetails().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RoomDetailsView(); // Show room details
                dashboardView.dispose();
            }
        });
    }
}
