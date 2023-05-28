package com.example.kuldevdummy.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


    public class Component {

        private String type;
        private String imageUrl;
        private String name;
        private String description;
        private Integer columns;
        private List<Data> data;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
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

        public Integer getColumns() {
            return columns;
        }

        public void setColumns(Integer columns) {
            this.columns = columns;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
