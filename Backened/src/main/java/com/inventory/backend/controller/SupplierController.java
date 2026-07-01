package com.inventory.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.backend.entity.Supplier;
import com.inventory.backend.service.SupplierService;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {
 private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return service.getAllSuppliers();

 
}
  @PostMapping
public Supplier saveSupplier(@RequestBody Supplier supplier) {
    return service.saveSupplier(supplier);
}
  @GetMapping("/{id}")
  public Supplier getSupplierById(@PathVariable Long id){
      return service.getSupplierById(id);
  }
  @PutMapping("/{id}")
  public Supplier updateSupplier(@PathVariable Long id,
                                 @RequestBody Supplier supplier) {
      return service.updateSupplier(id, supplier);
  }
  @DeleteMapping("/{id}")
  public String deleteSupplier(@PathVariable Long id) {

      service.deleteSupplier(id);

      return "Supplier deleted successfully";
  }
}