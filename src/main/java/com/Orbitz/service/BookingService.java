package com.Orbitz.service;

import com.Orbitz.entity.User;
import com.Orbitz.payload.BookingDto;

import java.util.List;

public interface BookingService {
    BookingDto createBooking(long roomId, User user, BookingDto dto);
    void cancelBooking(long bookingId,User user);

    List<BookingDto> getAllBookings(User user, int pageNo, int pageSize, String sortBy, String sortDir);

    List<BookingDto> getAllBookingByPropertyId(User user, long propertyId);

    List<BookingDto> getAllBookingsByUser(User user);

    BookingDto getBookingById(long bookingId, User user);
}
