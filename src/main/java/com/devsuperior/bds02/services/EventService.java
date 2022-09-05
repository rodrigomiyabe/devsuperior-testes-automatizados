package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository repository;
    private final CityRepository cityRepository;

    public EventService(EventRepository repository, CityRepository cityRepository) {
        this.repository = repository;
        this.cityRepository = cityRepository;
    }

    public EventDTO update(Long id, EventDTO dto) {
        Event event = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setUrl(dto.getUrl());
        event.setCity(cityRepository.findById(dto.getCityId()).orElseThrow());
        return new EventDTO(event);
    }

}
