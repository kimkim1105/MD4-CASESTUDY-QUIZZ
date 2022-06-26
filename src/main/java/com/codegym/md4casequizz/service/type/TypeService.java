package com.codegym.md4casequizz.service.type;

import com.codegym.md4casequizz.model.Level;
import com.codegym.md4casequizz.model.Type;
import com.codegym.md4casequizz.repository.ILevelRepository;
import com.codegym.md4casequizz.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService {
    @Autowired
    ITypeRepository typeRepository;

    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        typeRepository.deleteById(id);
    }
}
