package com.spring.base.controllo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/Lotto")
public class NumeriLotto {
	@GetMapping("/estrazione")
	public List<Integer> getRa() {
		List<Integer> num = new ArrayList<Integer>(10);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			num.add(random.nextInt(100));
		}
		return num;

	}

}
