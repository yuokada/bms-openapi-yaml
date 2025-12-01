package org.bms.core;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

@Produces(MediaType.APPLICATION_JSON)
public interface InternalEndpointResourceIf {
    @GET
    @Path("/roles")
    @Operation(hidden = true)
    Response getRoles(
        @Parameter(schema = @Schema(type = SchemaType.NUMBER))
        @PositiveOrZero
        @QueryParam("offset") int offset,
        @QueryParam("limit")
        @Parameter(schema = @Schema(type = SchemaType.NUMBER))
        @PositiveOrZero
        @DefaultValue("50") int limit
    );
}
