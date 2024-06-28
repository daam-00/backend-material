package com.example.doublecloutch.controller;

import com.example.doublecloutch.entity.Material;
import com.example.doublecloutch.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    private static final Logger logger = Logger.getLogger(MaterialController.class.getName());

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Material> getMaterialById(@PathVariable Long id) {
        return materialService.findById(id);
    }

    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        logger.info("Received material: " + material);
        return materialService.save(material);
    }

    @PutMapping("/{id}")
    public Material updateMaterial(@PathVariable Long id, @RequestBody Material materialDetails) {
        Material material = materialService.findById(id).orElseThrow(() -> new RuntimeException("Material not found with id " + id));

        material.setCode(materialDetails.getCode());
        material.setName(materialDetails.getName());

        return materialService.save(material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable Long id) {
        materialService.deleteById(id);
    }}