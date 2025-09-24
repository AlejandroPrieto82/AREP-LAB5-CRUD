package eci.edu.arep.crud.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.edu.arep.crud.modelo.Property;
import eci.edu.arep.crud.repositorio.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    public Property create(Property p) {
        return repository.save(p);
    }

    public List<Property> getAll() {
        return repository.findAll();
    }

    public Property getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found with id: " + id));
    }

    public Property update(Long id, Property p) {
        Property existing = getById(id);
        existing.setAddress(p.getAddress());
        existing.setPrice(p.getPrice());
        existing.setSize(p.getSize());
        existing.setDescription(p.getDescription());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Property not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
