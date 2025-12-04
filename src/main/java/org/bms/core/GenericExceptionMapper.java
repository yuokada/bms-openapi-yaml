package org.bms.core;

import jakarta.validation.executable.ValidateOnExecution;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {


    // @Override
    public Response toResponse(ValidateOnExecution ex) {
        var body = Map.of(
            "message", "Internal Server Error",
            "error", ex.getClass().getSimpleName()
        );
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(body)
            .build();
    }


    @Override
    public Response toResponse(Throwable ex) {
        var body = Map.of(
            "message", "Internal Server Error (TBW)",
            "error", ex.getClass().getSimpleName()
        );
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(body)
            .build();
    }
}
