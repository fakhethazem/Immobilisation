package com.tekup.Immobilisation.Services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tekup.Immobilisation.entities.AnnonceDto;


@Service
public class JsoupService {
	
	public static List<AnnonceDto> list_ann =  new ArrayList<AnnonceDto>();
	
	
	public void getDataFromtunisiaAnnonce()
	{
       try {
		Document doc =Jsoup.connect("http://www.tunisie-annonce.com/AnnoncesImmobilier.asp").get();
		Elements contents = doc.getElementsByClass("Tableau1");
		//System.out.println(contents);
		 for (Element element : contents) {
			                 Elements reg_url = element.getElementsByTag("a");
			                 String region=reg_url.get(0).text();
			                 String url="http://www.tunisie-annonce.com/" + reg_url.get(1).attr("href");
			                 Elements nat = element.getElementsByTag("td");
			                 String nature=nat.get(3).text();
			                 String type=nat.get(5).text();
			                 String prix= nat.get(9).text();
			          		 String modifie=nat.get(11).text();
			             	AnnonceDto annonceDto = new AnnonceDto(region, nature, type, url,prix, modifie);
			          		// System.out.println(annonceDto.toString());
			          		list_ann.add(annonceDto);
                                      }
		
		 
		
		}catch (IOException io)
		{
		System.out.println(io.getMessage());
	
		}	
	}
	
	/* public List<AnnonceDto> getDataByRegion(String region)  {
		 List<AnnonceDto> annonces = new ArrayList<AnnonceDto>();
		 for (AnnonceDto annonce : list_ann) {
			 AnnonceDto anno=annonce;
			 if (anno.getRegion()==region){
				 annonces.add(anno);
				 
			 }
		 }
		 
		 return annonces;
	}
	*/
	
	 /*final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();

	    mapper.writeValue(out, list_ann);

	    final byte[] data = out.toByteArray();
	    System.out.println(new String(data));
		 //System.out.println(list_ann);*/
	

}
