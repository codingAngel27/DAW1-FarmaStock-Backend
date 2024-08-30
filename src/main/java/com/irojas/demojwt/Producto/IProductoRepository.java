package com.irojas.demojwt.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository  extends JpaRepository<Producto, Integer>{
	
	@Query(value = "SELECT p FROM Producto p WHERE p.nomPro LIKE  %:name%")
    public List<Producto>findByName(@Param("name") String name);
	
}
