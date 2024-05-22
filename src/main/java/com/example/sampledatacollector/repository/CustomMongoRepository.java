package com.example.sampledatacollector.repository;

import java.util.List;
import java.util.Map;

public interface CustomMongoRepository {
    List<Map<String, Object>> findAllFromCollection(String collectionName);
    List<String> listAllCollections();
}