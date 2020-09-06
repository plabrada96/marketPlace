package com.test.marketplace.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.marketplace.common.data.specifiers.CommonSpecifications;
import com.test.marketplace.common.webcontroller.CommonController;
import com.test.marketplace.constants.MappingConstants;
import com.test.marketplace.constants.SwaggerConstants;
import com.test.marketplace.data.Product;
import com.test.marketplace.data.builder.ProductBuilder;
import com.test.marketplace.service.ProductService;

import io.swagger.annotations.Api;

@RestController
@Api(value = SwaggerConstants.API_VALUE_PRODUCT, tags = { SwaggerConstants.API_TAGS_PRODUCT })
@RequestMapping(SwaggerConstants.API_VALUE_PRODUCT)
public class ProductController extends CommonController<Product>{

	@Autowired
	private ProductService service;
	
	@Override
	public Product consult(@PathVariable(MappingConstants.PATH_ID) Long id) {
		return service.consult(id);
	}

	@Override
	public Product save(@RequestBody(required = true) Product product) {
		return service.save(product);
	}

	@Override
	public Product update(@PathVariable(MappingConstants.PATH_ID) Long id, @RequestBody(required = true) Product product) {
		product.setId(id);
		return service.save(product);
	}

	@Override
	public void delete(@PathVariable(MappingConstants.PATH_ID) Long id) {
		service.delete(id);
	}
	
	@GetMapping("")
	public Page<Product> list(ProductBuilder productBuilder) {
		if(productBuilder!=null) {
			return service.list(new CommonSpecifications<Product>(productBuilder));
		}else {
			return new PageImpl(service.list());
		}
	}
}
