package org.bms.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "DemoException", description = "A demo exception for testing purposes")
public class DemoException extends RuntimeException {
    public DemoException(String message) {
        super(message);
    }
}
