package com.rauldionisio.louvores;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rauldionisio.louvores.entities.Album;
import com.rauldionisio.louvores.entities.Artist;
import com.rauldionisio.louvores.entities.Moment;
import com.rauldionisio.louvores.entities.Music;
import com.rauldionisio.louvores.entities.Style;
import com.rauldionisio.louvores.repositories.AlbumRepository;
import com.rauldionisio.louvores.repositories.ArtistRepository;
import com.rauldionisio.louvores.repositories.MomentRepository;
import com.rauldionisio.louvores.repositories.MusicRepository;
import com.rauldionisio.louvores.repositories.StyleRepository;

@SpringBootApplication
public class LouvoresApplication implements CommandLineRunner {
	
	@Autowired
	private MusicRepository musicRepository;
	@Autowired
	private StyleRepository styleRepository;
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private MomentRepository momentRepository;

	public static void main(String[] args) {
		SpringApplication.run(LouvoresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Style style = new Style (null, "Pop");
		Style style2 = new Style (null, "R&B");
		Style style4 = new Style (null, "Rock");
		Style style5 = new Style(null, "Worship");
		styleRepository.saveAll(Arrays.asList( style, style2, style4, style5));
		Artist davidson = new Artist(null, "Davidson Silva", style);
		Artist frutos =  new Artist (null, "Banda Frutos", style2);
		Artist id2 = new Artist(null, "ID2", style4);
		Artist gil = new Artist(null, "Gil Monteiro", style5);
		artistRepository.saveAll(Arrays.asList(davidson, frutos, id2, gil));
		Album aguas = new Album(null, "Águas profundas", davidson, style);
		Album bracos = new Album(null, "Braços Abertos", frutos, style2);
		Album gratidao = new Album (null, "Gratidão", id2, style4);
		Album respirar = new Album (null, "Respirar", gil, style5);
		albumRepository.saveAll(Arrays.asList(aguas, bracos, gratidao, respirar));
		Moment moment = new Moment(null, "Louvor");
		Moment moment2 = new Moment(null, "Adoração");
		Moment cura = new Moment (null, "Cura e Libertação");
		momentRepository.saveAll(Arrays.asList(moment, moment2, cura));
		Music amar = new Music(null, "Amar-te Mais", new String(
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
		amar.setArtist(davidson);
		amar.setStyle(style);
		amar.setAlbum(aguas);
		aguas.getMusicList().add(amar);
		
		Music mais = new Music(null, "Mais e Mais e Mais", new String(
				"Mais e mais e mais\n"
				+ "Mais e mais e mais\n"
				+ "Eu vou te buscar\n"
				+ "\n"
				+ "Com fervor e decisão,\n"
				+ "Eu vou te buscar\n"
				+ "Teu amor é o bem maior\n"
				+ "Para me saciar\n"
				+ "\n"
				+ "Tu és vida plena,\n"
				+ "Vida verdadeira\n"
				+ "Resposta para sede de infinito\n"
				+ "Que há em mim\n"
				+ "\n"
				+ "Tu és vida plena, (vida plena)\n"
				+ "Vida verdadeira (a árvore da vida)\n"
				+ "Resposta para sede de infinito\n"
				+ "Que há em mim\n"
				+ "\n"
				+ "É sede de ti\n"
				+ "\n"
				+ "Ó Deus eterno,\n"
				+ "Amor eterno,\n"
				+ "Eu vou te buscar\n"
				+ "A tua graça\n"
				+ "E misericórdia\n"
				+ "Vão me sustentar\n"
				+ "\n"
				+ "Mais e mais e mais\n"
				+ "Mais e mais e mais\n"
				+ "Eu vou te buscar\n"
				+ "Verdadeiramente, decididamente, eu vou te buscar\n"
				+ "\n"
				+ "Mais e mais e mais e mais e mais e mais e mais e mais e mais\n"
				+ "Eu vou (mais) te buscar\n"
				+ "Verdadeiramente, decididamente\n"
				+ "Eu vou te buscar\n"
				));
		mais.setAlbum(bracos);
		mais.setArtist(frutos);
		mais.setStyle(frutos.getStyle());
		
		Music principe = new Music(null, "Príncipe da paz", new String(
				"Eu volto cansado de tentar\n"
				+ "Livrar me das culpas, me libertar\n"
				+ "Mas nada poderá lavar me, se não teu sangue\n"
				+ "\n"
				+ "Nem todas as fugas que eu busquei\n"
				+ "Nem mesmo os heróis que eu criei\n"
				+ "Em nada poderei salvar me, sem não em teu sangue\n"
				+ "\n"
				+ "Me rendo a ti abro mão de mim\n"
				+ "Muda o que eu gosto de errar\n"
				+ "Muda o que eu não sei mudar\n"
				+ "\n"
				+ "Cura-me príncipe da paz\n"
				+ "Cura-me homem de Nazaré\n"
				+ "Cura me príncipe da paz\n"
				+ "Cura me, cura-me\n"
				));
		principe.setAlbum(gratidao);
		principe.setArtist(id2);
		principe.setStyle(id2.getStyle());
		
		Music resp = new Music(null, "Respirar", new String(
				"Te amo Deus com o meu respirar\n"
				+ "Amado meu vivo pra te adorar\n"
				+ "\n"
				+ "Você mudou a escuridão em luz pra mim\n"
				+ "Me carregou nos braços seus quando eu cai\n"
				+ "Amor tão grande, amor que eu nunca vi\n"
				+ "Amor tão forte, me abraça até o fim\n"
				+ "\n"
				+ "Te amo Deus com o meu respirar\n"
				+ "Amado meu vivo pra te adorar\n"
				+ "\n"
				+ "A distância entre que sou e quem devo ser\n"
				+ "Foi vencida numa cruz sem eu merecer\n"
				+ "Amor tão grande, amor que eu nunca vi\n"
				+ "Amor tão forte, me abraça até o fim\n"
				+ "\n"
				+ "Te amo Deus com o meu respirar\n"
				+ "Amado meu vivo pra te adorar"));
		resp.setAlbum(respirar);
		resp.setArtist(gil);
		resp.setStyle(style5);
		
		
		
		musicRepository.saveAll(Arrays.asList(amar, mais, principe, resp));
		amar.getMomentList().add(moment2);
		amar.getMomentList().add(moment);
		mais.getMomentList().add(moment);
		principe.getMomentList().add(cura);
		resp.getMomentList().addAll(Arrays.asList(moment, moment2));
		respirar.getMusicList().add(resp);
		gratidao.getMusicList().add(principe);
		bracos.getMusicList().add(mais);
		albumRepository.saveAll(Arrays.asList(aguas, bracos, gratidao, respirar));
		musicRepository.saveAll(Arrays.asList(amar, mais, principe, resp));
		
	}

}
