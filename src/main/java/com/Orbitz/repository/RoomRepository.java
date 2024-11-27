package com.Orbitz.repository;


import com.Orbitz.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    boolean existsByRoomNoAndPropertyId(Integer roomNo, Long propertyId);
}