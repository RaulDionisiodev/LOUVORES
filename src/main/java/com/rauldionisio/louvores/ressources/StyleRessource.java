package com.rauldionisio.louvores.ressources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.services.StyleService;

@RestController
@RequestMapping(value ="/style")
public class StyleRessource {
	
	@Autowired
	private StyleService service;
	
	
	@GetMapping
	public ResponseEntity<List<Style>>findAll(){
		List<Style> body = service.findAll();
		return ResponseEntity.ok(body);
	}
	
	@ResponseBody
	@RequestMapping(path = "/findByname", method = RequestMethod.GET)
	public ResponseEntity<List<Style>>findbyname(@RequestParam("name") String name){
		List<Style> style = service.findByName(name);
		return ResponseEntity.ok(style);
		
	}
	
	@ResponseBody
	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String>insert(@RequestParam("name")String name){
		List<Style> styleList = service.findByName(name);
		boolean exist = false;
		for(Style m : styleList) {
			if(m.getDescription().equals(name)) {
				exist = true;
				break;
			}
		}

		if(!exist && styleList.isEmpty()) {
		   Style Style = new Style(null, name);
		   Style = service.insert(Style);
		   return ResponseEntity.status(HttpStatus.CREATED).body("Estilo inserido com sucesso");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Estilo já existente");
		}
		
		
	}

}
