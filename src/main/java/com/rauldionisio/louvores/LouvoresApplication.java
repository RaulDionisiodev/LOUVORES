package com.rauldionisio.louvores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.repositories.MusicRepository;

@SpringBootApplication
public class LouvoresApplication implements CommandLineRunner {
	
	@Autowired
	private MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(LouvoresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Music music = new Music(null, "Amar-te Mais", new StringBuffer(
				"Amar-te mais, que a mim mesmo\n"
				+ "Amar-te mais, que tudo que há aqui\n"
				+ "Amar-te mais, que aos mais queridos\n"
				+ "Amar-te e dar a vida só por ti\n"
				+ "Amar-te mais, que a mim mesmo\n"
				+ "Amar-te mais, que tudo que há aqui\n"
				+ "Amar-te mais, que aos mais queridos\n"
				+ "Amar-te e dar a vida só por ti\n"
				+ "Com minhas forças\n"
				+ "Com minha alma\n"
				+ "De todo o coração\n"
				+ "Viverei eu só pra te amar\n"
				+ "Amar-te, amar-te, amar-te\n"
				+ "E dar a vida só por ti"));
		musicRepository.save(music);
		
	}

}
