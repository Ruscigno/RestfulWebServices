package com.ruscigno.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {

	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBean() {
		DynamicSomeBean bean = new DynamicSomeBean("value1", "value2", "value3", "value4");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);

		return mapping;
	}

	//Don't worry about duplicated lines, just to try on Filtering
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<DynamicSomeBean> list = Arrays.asList(new DynamicSomeBean("value1", "value2", "value3", "value4"),
				new DynamicSomeBean("value12", "value22", "value32", "value42"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3", "field42");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);

		return mapping;
	}
}
