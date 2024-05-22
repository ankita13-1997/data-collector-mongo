package com.example.sampledatacollector.model;

import javax.persistence.Entity;
import java.util.Map;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class CSVData {
	    @Id
	    private String id;
	    private Map<String, Object> dynamicFields;
	    

	    // Getters and setters
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public Map<String, Object> getDynamicFields() {
	        return dynamicFields;
	    }

	    public void setDynamicFields(Map<String, Object> dynamicFields) {
	        this.dynamicFields = dynamicFields;
	    }

}
