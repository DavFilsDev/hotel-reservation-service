package com.example.hotelbooking.dto;

import com.example.hotelbooking.model.Booking;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingResponse {
    private String customerName;
    private String phoneNumber;
    private String email;
    private Integer roomNumber;
    private String roomDescription;
    private String bookingDate;

    public BookingResponse(Booking booking) {
        this.customerName = booking.getCustomerName();
        this.phoneNumber = booking.getPhoneNumber();
        this.email = booking.getEmail();
        this.roomNumber = booking.getRoomNumber();
        this.roomDescription = booking.getRoomDescription();
        this.bookingDate = booking.getBookingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Getters
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public Integer getRoomNumber() { return roomNumber; }
    public String getRoomDescription() { return roomDescription; }
    public String getBookingDate() { return bookingDate; }
}