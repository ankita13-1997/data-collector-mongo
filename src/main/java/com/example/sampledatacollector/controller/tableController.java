package com.example.sampledatacollector.controller;


import com.example.sampledatacollector.model.CSVData;
import com.example.sampledatacollector.repository.ModelStorage;
import com.example.sampledatacollector.service.IModelService;
import com.example.sampledatacollector.service.ModelService;
import com.opencsv.exceptions.CsvException;

import ch.qos.logback.core.model.Model;
import io.swagger.annotations.ApiParam;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/table")
@ComponentScan
@EnableAutoConfiguration
public class tableController {

	
	@Autowired
	private IModelService modelFile;

    @GetMapping("/welcomeBook")
    public String tableView() {
        return "i view the table";
    }


    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile fileName) throws IOException, CsvException {
    	if (fileName.getOriginalFilename().endsWith(".csv")) {
    		try (Reader reader = new InputStreamReader(fileName.getInputStream());
    	             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
    	            List<Map<String, String>> tableData = new ArrayList<>();
    	            for (CSVRecord csvRecord : csvParser) {
    	                Map<String, String> row = new HashMap<>();
    	                for (String header : csvParser.getHeaderNames()) {
    	                    row.put(header, csvRecord.get(header));
    	                }
    	                tableData.add(row);
    	            }
    	            return ResponseEntity.ok(tableData); // Return data on success
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	            return ResponseEntity.badRequest().body("Invalid CSV file"); // Return error message and status code 400
    	        }
    		
    	}else {
  		    List<CSVData> mongoData = modelFile.getAllData(); // Assuming your service returns MongoDB data as Map
  		    System.out.println(mongoData + " " +mongoData.toString());
            return ResponseEntity.ok(mongoData); // Return MongoDB data as table data 15748
    		
    	}
        
    }
    
    // Endpoint for retrieving data from MongoDB
    @GetMapping("/mongo")
    public ResponseEntity<?> getMongoData() {
    	System.out.println("I am called");
        List<CSVData> data = modelFile.getAllData();

        // Extract all field names dynamically
        Set<String> fieldNames = data.stream()
                                     .flatMap(item -> item.getDynamicFields().keySet().stream())
                                     .collect(Collectors.toSet());
        

        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("fieldNames", fieldNames);
        System.out.println("res" + " "+ response+ " "+response.toString() + " " + fieldNames);

        return ResponseEntity.ok(response);
    }
    
//    @GetMapping("/table/collections")
//    public ResponseEntity<?> listCollections() {
//        List<String> collections;
//		try {
//			collections = ModelService.listCollections();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return ResponseEntity.ok(collections);
//    }
//
//    // Endpoint to retrieve data from a specific collection
//    @GetMapping("/table/mongo/{collectionName}")
//    public ResponseEntity<?> getMongoData(@PathVariable String collectionName) {
//        List<Map<String, Object>> data;
//		try {
//			data = ModelService.getDataFromCollection(collectionName);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        // Extract all field names dynamically
//        Set<String> fieldNames = data.stream()
//                                     .flatMap(item -> item.keySet().stream())
//                                     .collect(Collectors.toSet());
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("data", data);
//        response.put("fieldNames", fieldNames);
//
//        return ResponseEntity.ok(response);
//    }
//    
    


}
