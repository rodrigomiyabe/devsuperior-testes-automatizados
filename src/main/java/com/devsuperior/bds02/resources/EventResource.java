package com.devsuperior.bds02.resources;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

   private final EventService service;

    public EventResource(EventService service) {
        this.service = service;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id,@RequestBody EventDTO dto){
         dto = service.update(id,dto);
        return   ResponseEntity.ok().body(dto);
    }
}
