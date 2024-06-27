package lv.latvijasrokdarbi;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.latvijasrokdarbi.model.Atlaide;
import lv.latvijasrokdarbi.model.Kategorija;
import lv.latvijasrokdarbi.model.Pircejs;
import lv.latvijasrokdarbi.model.Prece;
import lv.latvijasrokdarbi.model.PrecesBilde;
import lv.latvijasrokdarbi.repo.IAtlaideRepo;
import lv.latvijasrokdarbi.repo.IKategorijaRepo;
import lv.latvijasrokdarbi.repo.IPircejsRepo;
import lv.latvijasrokdarbi.repo.IPreceRepo;
import lv.latvijasrokdarbi.repo.IPrecesBildeRepo;

@SpringBootApplication
public class SparniTimeklaVietneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparniTimeklaVietneApplication.class, args);
	}
	@Bean
	public CommandLineRunner testDB(IAtlaideRepo atlaideRepo, IKategorijaRepo kategorijaRepo,
			IPreceRepo preceRepo, IPrecesBildeRepo precesBildeRepo, IPircejsRepo pircejsRepo) {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				
				Kategorija kategorija1 = new Kategorija("Apģērbs", "Dažādas apģerbu preces");
				Kategorija kategorija2 = new Kategorija("Dekorācija", "Dažādas dekoratīvas preces");
				kategorijaRepo.save(kategorija1);
				kategorijaRepo.save(kategorija2);
				

				LocalDateTime tagad = LocalDateTime.now();
				
				Atlaide atlaide1 = new Atlaide("Lieldienu izpārdošana", 0.5f, tagad, tagad.plusDays(3), "Ļoti lielas atlaides!");
				Atlaide atlaide2 = new Atlaide("Mazdienu izpārdošana", 0.01f, tagad, tagad.plusDays(4), "Ļoti mazas atlaides!");
				atlaideRepo.save(atlaide1);
				atlaideRepo.save(atlaide2);
				
				Prece prece1 = new Prece(kategorija1, "Zeķe", "Ļoti skaista zeķe", 10, 1, atlaide1);
				Prece prece2 = new Prece(kategorija2, "Zaķis", "Ļoti skaists zaķis", 20, 1, null);
				preceRepo.save(prece1);
				preceRepo.save(prece2);
				
				PrecesBilde precesBilde1 = new PrecesBilde(prece1, "/images/bilde1.png", "skaista bilde");
				PrecesBilde precesBilde2 = new PrecesBilde(prece1, "/images/bilde2.png", "normāla bilde");
				PrecesBilde precesBilde3 = new PrecesBilde(prece2, "/images/bilde3.png", "izcila bilde");
				precesBildeRepo.save(precesBilde1);
				precesBildeRepo.save(precesBilde2);
				precesBildeRepo.save(precesBilde3);
				
				
				Pircejs pircejs1 = new Pircejs("Aldis", "Gaspačo", "agaspacho@gmail.com", "Liepāja, Brīvības iela 20", "SWEDBANK", "LVSWED12", "LVHABA12345");
				Pircejs pircejs2 = new Pircejs("Bruno", "Bīrs", "bbruno@inbox.lv", "Rīga Brīvības gatve 357", "SEB", "LVSEBU123", "LVSEBUB1234");
				Pircejs pircejs3 = new Pircejs("Cālis", "Cīrulis", "cakcak@hotmail.ru", "Ventspils, Inženieru iela 101", "LUMINOR", "LVLUMI999", "LVHABA1234567");
				pircejsRepo.save(pircejs1);
				pircejsRepo.save(pircejs2);
				pircejsRepo.save(pircejs3);
				
				
			}

		};
	}

}
