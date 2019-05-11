package flux.shujaat.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@RestController

@RequestMapping("/publish")
public class Publisher {
	
	 private static Logger log = Logger.getLogger("FluxConsumer");
	 
	 @JsonFormat
	 @GetMapping("/fluxString")
	 public Flux<String> publishingFluxData() throws JsonProcessingException {
	        ObjectMapper mapperObj = new ObjectMapper();
	        Map<String, String> fluxRet = new HashMap<>();
	        fluxRet.put("One", "Atul");
	        fluxRet.put("Two", "Shujaat");
	        String jsonResp = mapperObj.writeValueAsString(fluxRet);
	        return  Flux.just(jsonResp);
	    }
	 
	 @JsonFormat
	 @GetMapping("/fluxMap")
	 public Flux<Map<String,Integer>>publishMap() throws JsonProcessingException{
		 
		 Map<String,Integer>hm = new HashMap<>();
		 hm.put("a", 1);
		 hm.put("b", 2);
		 hm.put("c", 3);
		 
		 return Flux.just(hm);
	 }

}
