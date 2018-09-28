package org.springsecurity.SpringSecurityExample.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {
	@RequestMapping(value="hello/{name}")
	public String sayHelloTo(@PathVariable final String name) {
		return "Hello" +name;
	}
}
