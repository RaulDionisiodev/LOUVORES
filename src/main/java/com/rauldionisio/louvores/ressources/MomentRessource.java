package com.rauldionisio.louvores.ressources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rauldionisio.louvores.entities.Moment;
import com.rauldionisio.louvores.services.MomentService;

@RestController
@RequestMapping(value ="/moment")
public class MomentRessource {
	
	@Autowired
	private MomentService service;
	
	
	@GetMapping
	public ResponseEntity<List<Moment>>findAll(){
		List<Moment> body = service.findAll();
		return ResponseEntity.ok(body);
	}
	
	@ResponseBody
	@RequestMapping(path = "/findByname", method = RequestMethod.GET)
	public ResponseEntity<List<Moment>>findbyname(@RequestParam("name") String name){
		List<Moment> moment = service.findByName(name);
		return ResponseEntity.ok(moment);
		
	}

}
