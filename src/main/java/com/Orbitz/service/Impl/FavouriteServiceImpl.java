package com.Orbitz.service.Impl;

import com.Orbitz.entity.Favourite;
import com.Orbitz.entity.Property;
import com.Orbitz.entity.User;
import com.Orbitz.exception.FavouriteException;
import com.Orbitz.payload.FavouriteDto;
import com.Orbitz.repository.FavouriteRepository;
import com.Orbitz.repository.PropertyRepository;
import com.Orbitz.service.FavouriteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    private FavouriteRepository favouriteRepository;
    private PropertyRepository propertyRepository;

    public FavouriteServiceImpl(FavouriteRepository favouriteRepository, PropertyRepository propertyRepository) {
        this.favouriteRepository = favouriteRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public FavouriteDto addFavourite(long propertyId, User user, FavouriteDto favouriteDto) {
        Property property = propertyRepository.findById(propertyId).orElseThrow(
                () -> new FavouriteException("Property not found with id: " + propertyId)
        );

        Optional<Favourite> byUserAndProperty = favouriteRepository.findByUserAndProperty(user, property);
        if (!byUserAndProperty.isEmpty()){
            throw new FavouriteException("Favourite Already exist with propertyId: "+propertyId);
        }
        favouriteDto.setProperty(property);
        favouriteDto.setUser(user);
        Favourite favourite = dtoToEntity(favouriteDto);

        Favourite save = favouriteRepository.save(favourite);
        return entityToDto(save);

    }

    @Override
    public FavouriteDto updateFavourite(long favouriteId, long propertyId, User user, FavouriteDto dto) {
        Favourite favourite=null;
        favourite = favouriteRepository.findById(favouriteId).orElseThrow(
                () -> new FavouriteException("Favourite not found with id: " + favouriteId)
        );
        Property property = propertyRepository.findById(propertyId).orElseThrow(
                () -> new FavouriteException("Property not found with id: " + propertyId)
        );
        dto.setProperty(property);
        dto.setUser(user);

        favourite=dtoToEntity(dto);
        favourite.setId(favouriteId);

        Favourite save = favouriteRepository.save(favourite);
        return entityToDto(save);

    }

    @Override
    public List<FavouriteDto> getFavouriteByUser(User user) {
        List<Favourite> favouriteByUser = favouriteRepository.findFavouriteByUser(user);
        List<FavouriteDto> collect = favouriteByUser.stream().map(e -> entityToDto(e)).collect(Collectors.toList());
        return collect;
    }

    //dto to entity
    private Favourite dtoToEntity(FavouriteDto favouriteDto){
        Favourite favourite=new Favourite();
        favourite.setStatus(favouriteDto.getStatus());
        favourite.setProperty(favouriteDto.getProperty());
        favourite.setUser(favouriteDto.getUser());
        return favourite;
    }
    //entity to dto
    private FavouriteDto entityToDto(Favourite favourite){
        FavouriteDto dto=new FavouriteDto();
        dto.setId(favourite.getId());
        dto.setStatus(favourite.getStatus());
        dto.setProperty(favourite.getProperty());
        dto.setUser(favourite.getUser());
        return dto;
    }
}


