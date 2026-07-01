package com.inventory.backend.service;

import org.springframework.stereotype.Service;
import com.inventory.backend.entity.Supplier;
import com.inventory.backend.repository.SupplierRepository;
import java.util.List;

@Service
public class SupplierService {
  private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    public Supplier saveSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    public Supplier getSupplierById(Long id){
        return repository.findById(id)
                .orElseThrow();
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {

        Supplier existingSupplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        existingSupplier.setName(supplier.getName());
        existingSupplier.setContactPerson(supplier.getContactPerson());
        existingSupplier.setPhone(supplier.getPhone());
        existingSupplier.setEmail(supplier.getEmail());
        existingSupplier.setNotes(supplier.getNotes());

        return repository.save(existingSupplier);
    }

	 



}
