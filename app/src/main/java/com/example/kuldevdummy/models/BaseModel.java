package com.example.kuldevdummy.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BaseModel {


        private List<Component> components;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public List<Component> getComponents() {
            return components;
        }

        public void setComponents(List<Component> components) {
            this.components = components;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
