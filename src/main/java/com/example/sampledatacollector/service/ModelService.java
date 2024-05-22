package com.example.sampledatacollector.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sampledatacollector.model.CSVData;
import com.example.sampledatacollector.repository.ModelStorage;
import java.util.ArrayList;

@Service
public class ModelService implements IModelService {

	@Autowired
	ModelStorage modelStorageRepo;
	
	
	 public List<CSVData> getAllData() {
		  System.out.println(" .."+ modelStorageRepo.findAll() );
	      return modelStorageRepo.findAll();
	  }
	
//	@Override
//	 public List<String> listCollections() {
//	        return modelStorageRepo.getDb().listCollectionNames().into(new ArrayList<>());
//	    }
//	@Override
//	 public  List<Map<String, Object>> getDataFromCollection(String collectionName) {
//	        List<Map<String, Object>> data =modelStorageRepo.findAll(Map.class, collectionName);
//	        return data;
//	    }
	 
	 
}
