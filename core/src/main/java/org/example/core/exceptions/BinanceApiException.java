package org.example.core.exceptions;

public class BinanceApiException extends RuntimeException {
    public BinanceApiException(String message, IllegalArgumentException iaex) {
        super(message);
    }
}
