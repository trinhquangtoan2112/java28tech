package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	 @GetMapping("/greeting")
	    public Object greeting(@RequestParam(value = "name") String name,@RequestParam(value = "ten", required = false) int name1) {
		 Greeting gt1 =new Greeting();
		 try {
			 validate(name);
		} catch (FieldException e) {
			List<String> ketQua = new ArrayList<String>();
			ketQua.add(e.getMessage());
			  return ketQua;
		}
		 gt1.setId(counter.incrementAndGet());
		 gt1.setContent(String.format(template, name));
		 System.out.println(name1);
	        return gt1;
	    }
	 public void validate(String name) throws FieldException {
		 
		 if("123".equals(name)) {
			 throw new FieldException("Name ko the la 123");
		 }
	 }
	 @GetMapping("/value123")
	    public String getName11(@RequestParam Map<String,String> params) {
		System.out.println("212442");
		Set<String> set = params.keySet();
		 for (String key : set) { 
	            System.out.println(key + " " + params.get(key));
	        }
	        return "41224241";
	    }
}