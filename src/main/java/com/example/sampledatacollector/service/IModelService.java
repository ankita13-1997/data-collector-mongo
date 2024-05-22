package com.example.sampledatacollector.service;

import java.util.List;
import java.util.Map;

import com.example.sampledatacollector.model.CSVData;

public interface IModelService {
	public List<CSVData> getAllData();
//	public List<String> listCollections();
//	public List<Map<String, Object>> getDataFromCollection(String collectionName);
}
