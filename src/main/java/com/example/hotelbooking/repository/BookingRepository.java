package com.example.hotelbooking.repository;

import com.example.hotelbooking.model.Booking;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class BookingRepository {
    private final List<Booking> bookings = new CopyOnWriteArrayList<>();

    public List<Booking> findAll() {
        return Collections.unmodifiableList(bookings);
    }

    public Booking save(Booking booking) {
        bookings.add(booking);
        return booking;
    }

    public boolean isRoomAvailable(Integer roomNumber, LocalDate date) {
        return bookings.stream()
                .noneMatch(booking ->
                        booking.getRoomNumber().equals(roomNumber) &&
                                booking.getBookingDate().equals(date)
                );
    }
}
