package com.example.hotelbooking.service;

import com.example.hotelbooking.dto.BookingRequest;
import com.example.hotelbooking.model.Booking;
import com.example.hotelbooking.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(BookingRequest request) {
        // Check if room is available
        if (!bookingRepository.isRoomAvailable(request.getRoomNumber(), request.getBookingDate())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    String.format("Room %d is not available for date %s",
                            request.getRoomNumber(),
                            request.getBookingDate().toString())
            );
        }

        // Create and save booking
        Booking booking = new Booking(
                request.getCustomerName(),
                request.getPhoneNumber(),
                request.getEmail(),
                request.getRoomNumber(),
                request.getRoomDescription(),
                request.getBookingDate()
        );

        return bookingRepository.save(booking);
    }
}