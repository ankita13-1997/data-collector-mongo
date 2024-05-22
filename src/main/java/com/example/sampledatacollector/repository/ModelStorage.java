package com.example.sampledatacollector.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sampledatacollector.model.CSVData;

@Repository
public interface ModelStorage extends MongoRepository< CSVData , String> {
	
}
