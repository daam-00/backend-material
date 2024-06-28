package com.example.doublecloutch.service;

import com.example.doublecloutch.entity.Material;
import com.example.doublecloutch.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    private static final Logger logger = Logger.getLogger(MaterialService.class.getName());

    public List<Material> findAll() {
        logger.info("Retrieving all materials");
        return materialRepository.findAll();
    }
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Material> findById(Long id) {
        logger.info("Retrieving material with ID: " + id);
        return materialRepository.findById(id);
    }

    public Material save(Material material) {
        logger.info("Saving material: " + material);
        return materialRepository.save(material);
    }

    public void deleteById(Long id) {
        logger.info("Deleting material with ID: " + id);
        materialRepository.deleteById(id);
    }
}