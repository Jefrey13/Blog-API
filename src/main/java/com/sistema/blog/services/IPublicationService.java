package com.sistema.blog.services;

import com.sistema.blog.dto.publicationDto;

import java.util.List;

public interface IPublicationService {
    public publicationDto createPublication(publicationDto publicationDto);
    public List<publicationDto> getAllPublication();
    public publicationDto getPublicationById(long id);
    public publicationDto updatePublication(publicationDto publicationDto, long id);
    public void deletePublication(long id);
}
