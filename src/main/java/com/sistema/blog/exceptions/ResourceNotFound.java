package com.sistema.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String fileName;
    private long fileValue;

    public ResourceNotFound(String resourceName, String fileName, long fileValue) {
        super(String.format("%s Not found with: %s : '%s'",resourceName, fileName ,fileValue));
        this.resourceName = resourceName;
        this.fileName = fileName;
        this.fileValue = fileValue;
    }
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileValue() {
        return fileValue;
    }

    public void setFileValue(long fileValue) {
        this.fileValue = fileValue;
    }
}