package com.Orbitz.repository;

import com.Orbitz.entity.Booking;
import com.Orbitz.entity.Property;
import com.Orbitz.entity.Room;
import com.Orbitz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomAndStatus(Room room, String status);
     List<Booking> findByProperty(Property property);
     List<Booking> findByUser(User user);

}