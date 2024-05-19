package com.sistema.blog.controllers;

import com.sistema.blog.dto.publicationDto;
import com.sistema.blog.services.implementation.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {
    @Autowired
    private PublicationService _publicationService;

    @GetMapping
    public List<publicationDto> getAllPublication(){
        return  _publicationService.getAllPublication();
    }
    @GetMapping("/{id}")
    public ResponseEntity<publicationDto> getPublicationById(@PathVariable(name ="id") long id){
        return ResponseEntity.ok(_publicationService.getPublicationById(id));
    }
    @PostMapping
    public ResponseEntity<publicationDto> savePublication(@RequestBody publicationDto publicationDto){
        return new ResponseEntity<>(_publicationService.createPublication(publicationDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<publicationDto> updatePublication(@RequestBody publicationDto publicationDto, @PathVariable(name = "id") long id){
        publicationDto publicationDtoResponse = _publicationService.updatePublication(publicationDto, id);
        return new ResponseEntity<>(publicationDtoResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable(name = "id") long id){
        _publicationService.deletePublication(id);
        return new ResponseEntity<>("Deleted Publication", HttpStatus.OK);
    }
}