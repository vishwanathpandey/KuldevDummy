package com.example.kuldevdummy.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {


        private String value;
        private String name;
        private String description;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
