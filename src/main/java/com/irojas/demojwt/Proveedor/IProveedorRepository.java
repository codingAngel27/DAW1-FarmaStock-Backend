package com.irojas.demojwt.Proveedor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {
	
	@Query(value = "SELECT p FROM Proveedor p WHERE p.nomProvee LIKE  %:name%")
    public List<Proveedor>findByName(@Param("name") String name);

}
