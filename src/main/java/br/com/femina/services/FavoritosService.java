package br.com.femina.services;

import br.com.femina.entities.Favoritos;
import br.com.femina.repositories.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    @Transactional
    public void insert(Favoritos favoritos) {
        this.favoritosRepository.save(favoritos);
    }

    public Optional<Favoritos> findById(Long id) {
        return this.favoritosRepository.findById(id);
    }

    public Page<Favoritos> findAll(Pageable pageable) { return this.favoritosRepository.findAll(pageable); }

    @Transactional
    public void delete(Long id, Favoritos favoritos) {
        if (id == favoritos.getId()){
            this.favoritosRepository.delete(favoritos);
        } else {
            throw new RuntimeException();
        }
    }

}
