package br.com.femina.service;

import br.com.femina.entity.Categorias;
import br.com.femina.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Optional<Categorias> findById(Long id){
        return this.categoriaRepository.findById(id);
    }

    public Page<Categorias> listAll(Pageable pageable){
        return this.categoriaRepository.findAll(pageable);
    }

    @Transactional
    public void update (Long id, Categorias categorias){
        if((id == categorias.getId())){
            this.categoriaRepository.save(categorias);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void insert (Categorias categorias){
        this.categoriaRepository.save(categorias);
    }

}
