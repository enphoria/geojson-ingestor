package com.enphoria.geojsoningestor;

import com.enphoria.geojsoningestor.utils.Init;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeojsonIngestorApplication extends Init {

	public static void main(String[] args) {
		SpringApplication.run(GeojsonIngestorApplication.class, args);
	}

}
