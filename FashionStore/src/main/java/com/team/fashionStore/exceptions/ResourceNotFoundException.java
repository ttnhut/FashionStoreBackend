/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.exceptions;

/**
 *
 * @author Asus
 */
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private long fiedValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fiedValue) {
        super(String.format("%s not found with %s %s", resourceName,fieldName,fiedValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fiedValue = fiedValue;
    }

    /**
     * @return the resourceName
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName the resourceName to set
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return the fiedValue
     */
    public long getFiedValue() {
        return fiedValue;
    }

    /**
     * @param fiedValue the fiedValue to set
     */
    public void setFiedValue(long fiedValue) {
        this.fiedValue = fiedValue;
    }
    
    
}
