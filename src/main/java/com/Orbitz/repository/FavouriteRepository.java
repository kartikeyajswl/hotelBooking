package com.Orbitz.repository;

import com.Orbitz.entity.Favourite;
import com.Orbitz.entity.Property;
import com.Orbitz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    @Query("Select f from Favourite f where f.user=:user and f.property=:property")
    Optional<Favourite> findByUserAndProperty(@Param("user") User user, @Param("property") Property property);

    @Query("Select f from Favourite f where f.user=:user")
    List<Favourite> findFavouriteByUser(@Param("user") User user);
}