package com.sistema.blog.services.implementation;

import com.sistema.blog.dto.publicationDto;
import com.sistema.blog.exceptions.ResourceNotFound;
import com.sistema.blog.models.publications;
import com.sistema.blog.services.IPublicationService;
import com.sistema.blog.repositories.publicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService implements IPublicationService {
    @Autowired
    private publicationRepository _publicationRepository;

    @Override
    public publicationDto createPublication(publicationDto publicationDto) {

        publications publication = mapEntity(publicationDto);
        publications newPublication = _publicationRepository.save(publication);

        publicationDto publicationResponse = mapDto(newPublication);
        return publicationResponse;
    }

    @Override
    public List<publicationDto> getAllPublication() {
        List<publications> publications = _publicationRepository.findAll();
        return publications.stream().map(publication -> mapDto(publication)).collect(Collectors.toList());
    }

    @Override
    public publicationDto getPublicationById(long id) {
        publications publication = _publicationRepository.
                findById(id).orElseThrow(()-> new ResourceNotFound("Publication not found", "id", id));
        return mapDto(publication);
    }

    @Override
    public publicationDto updatePublication(publicationDto publicationDto, long id) {
        publications publication = _publicationRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Publication", "Id", id));

        publication.setTitle(publicationDto.getTitle());
        publication.setDescription(publicationDto.getDescription());
        publication.setContent(publicationDto.getContent());

        publications updatePublication = _publicationRepository.save(publication);
        return mapDto(updatePublication);
    }

    @Override
    public void deletePublication(long id) {
        publications publication = _publicationRepository.
                findById(id).orElseThrow(()-> new ResourceNotFound("Publication not found", "id", id));
        _publicationRepository.delete(publication);
    }

    private publications mapEntity(publicationDto publicationDto){
        //Convertimos de DTO a ENTIDAD
        publications publication = new publications();
        publication.setTitle(publicationDto.getTitle());
        publication.setDescription(publicationDto.getDescription());
        publication.setContent(publicationDto.getContent());
        return  publication;
    }
    private publicationDto mapDto(publications newPublication){
        //Convertimos entidad a DTO
        publicationDto publicationDtoResponse = new publicationDto();
        publicationDtoResponse.setId(newPublication.getId());
        publicationDtoResponse.setTitle(newPublication.getTitle());
        publicationDtoResponse.setDescription(newPublication.getDescription());
        publicationDtoResponse.setContent(newPublication.getContent());

        return  publicationDtoResponse;
    }
}