package com.test.marketplace.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.marketplace.common.webcontroller.CommonController;
import com.test.marketplace.constants.MappingConstants;
import com.test.marketplace.constants.SwaggerConstants;
import com.test.marketplace.data.Order;
import com.test.marketplace.service.OrderService;

import io.swagger.annotations.Api;

@RestController
@Api(value = SwaggerConstants.API_VALUE_ORDER, tags = { SwaggerConstants.API_TAGS_ORDER })
@RequestMapping(SwaggerConstants.API_VALUE_ORDER)
public class OrderController extends CommonController<Order>{
	
	@Autowired
	private OrderService service;

	@Override
	public Order consult(@PathVariable(MappingConstants.PATH_ID) Long id) {
		return service.consult(id);
	}

	@Override
	public Order save(@RequestBody(required = true) Order order) {
		return service.save(order);
	}

	@Override
	public Order update(@PathVariable(MappingConstants.PATH_ID) Long id, @RequestBody(required = true) Order order) {
		order.setId(id);
		return service.save(order);
	}

	@Override
	public void delete(@PathVariable(MappingConstants.PATH_ID) Long id) {
		service.delete(id);
	}
}
