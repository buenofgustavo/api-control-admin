package com.centralti.tdm.errors;

public class ErrorResponses {
    private String message;
    // Adicione outros campos, se necessário

    public ErrorResponses(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
