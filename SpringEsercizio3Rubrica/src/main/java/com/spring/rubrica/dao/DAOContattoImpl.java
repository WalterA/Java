package com.spring.rubrica.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.rubrica.entity.Contatto;



@Repository
public class DAOContattoImpl implements DaoContatto {
    private Map<Integer, Contatto> mappaContatti = new HashMap<>();

    public void insert(Contatto c) {
        if (mappaContatti.containsKey(c.getId())) {
            throw new RuntimeException("Contatto già presente: " + c.getId());
        }
        mappaContatti.put(c.getId(), c);
    }

    public boolean delete(Integer idContatto) {
        Contatto c = mappaContatti.remove(idContatto);
        return c != null;
    }

    public List<Contatto> selectAll() {
        return new ArrayList<>(mappaContatti.values());
    }

    public Contatto selectById(Integer idContatto) {
        return mappaContatti.get(idContatto);
    }
}


