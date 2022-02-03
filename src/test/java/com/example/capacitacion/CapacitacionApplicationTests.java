package com.example.capacitacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.capacitacion.controllers.CaProducsController;
import com.example.capacitacion.entity.CaProduc;

@SpringBootTest
class CapacitacionApplicationTests {
	@Autowired
	CaProducsController productController;

	@Test
	void getAllProducts() {
		List<CaProduc> products;
		products = productController.getCaProducs().getBody();

		assertNotNull(products);
	}

	@Test
	void getProduct() {
		CaProduc product = productController.getCaProduc(1).getBody();

		assertNotNull(product);
	}

	@Test
	void createProduct() {
		CaProduc product = new CaProduc();
		product.setProNumero(2);
		product.setProNombre("Mouse");
		product.setProNumcat(1);

		CaProduc newProduct = productController.createCaProduc(product).getBody();

		assertNotNull(newProduct);
	}

	@Test
	void modifyProduct() {
		CaProduc product = new CaProduc();
		product.setProNumero(2);
		product.setProNombre("Mouse Gamer");
		product.setProNumcat(2);

		CaProduc newProduct;
		newProduct = productController.updateCaProduc(product.getProNumero(), product).getBody();

		assertNotNull(newProduct);
	}

	@Test
	void deleteProduct() {
		CaProduc newProduct = 
		productController.deleteCaProduc(3).getBody();

		assertNull(newProduct);
	}
}
