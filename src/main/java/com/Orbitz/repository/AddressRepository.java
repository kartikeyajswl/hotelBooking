package com.Orbitz.repository;

import com.Orbitz.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByAreaAndCityAndCountryAndStateAndPostalCode(String area, String city, String country, String state, String postalCode);
}