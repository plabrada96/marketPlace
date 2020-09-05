package com.test.marketplace.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.marketplace.common.webcontroller.CommonController;
import com.test.marketplace.constants.MappingConstants;
import com.test.marketplace.constants.SwaggerConstants;
import com.test.marketplace.data.Category;
import com.test.marketplace.service.CategoryService;

import io.swagger.annotations.Api;

@RestController
@Api(value = SwaggerConstants.API_VALUE_CATEGORY, tags = { SwaggerConstants.API_TAGS_CATEGORY })
@RequestMapping(SwaggerConstants.API_VALUE_CATEGORY)
public class CategoryController extends CommonController<Category>{

	@Autowired
	private CategoryService service;
	
	@Override
	public Category consult(@PathVariable(MappingConstants.PATH_ID) Long id) {
		return service.consult(id);
	}

	@Override
	public Category save(@RequestBody(required = true) Category category) {
		return service.save(category);
	}

	@Override
	public Category update(@PathVariable(MappingConstants.PATH_ID) Long id, @RequestBody(required = true) Category category) {
		category.setId(id);
		return service.save(category);
	}

	@Override
	public void delete( @PathVariable(MappingConstants.PATH_ID) Long id) {
		service.delete(id);
	}

}
