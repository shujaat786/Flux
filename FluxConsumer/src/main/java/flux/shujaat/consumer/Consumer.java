package flux.shujaat.consumer;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/consume")
public class Consumer {

	private static Logger log = Logger.getLogger("FluxConsumer");

	@JsonFormat
	@GetMapping("/allPublisher")
	public Map<String, String> publishingData() throws IOException {

		RestTemplate restTemplate = new RestTemplate();

		Map forObject = restTemplate.getForObject("http://localhost:8080/publish/fluxString", Map.class);
		log.info(getObjectPrinting(forObject));
		return forObject;
	}
	
	public String getObjectPrinting(Object inp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper(); // for Object printing to String
		return mapper.writeValueAsString(inp);
	}

}
