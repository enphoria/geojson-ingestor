package com.enphoria.geojsoningestor.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${application.ingestor.api.path}")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
@Api(tags = "geojson-ingestor")
public class IngestorController {
}
