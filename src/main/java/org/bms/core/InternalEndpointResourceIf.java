package org.bms.core;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bms.model.DemoException;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Produces(MediaType.APPLICATION_JSON)
public interface InternalEndpointResourceIf {
    @GET
    @Path("/roles")
    // @Operation(hidden = true)
    Response getRoles(
        @Parameter(schema = @Schema(type = SchemaType.NUMBER))
        @PositiveOrZero
        @QueryParam("offset") int offset,
        @QueryParam("limit")
        @Parameter(schema = @Schema(type = SchemaType.NUMBER))
        @PositiveOrZero
        @DefaultValue("50") int limit
    );

    @GET
    @Path("/teams-excep/{id}")
    @APIResponses({
        @APIResponse(
            responseCode = "200",
            description = "User found"
        ),
        @APIResponse(
            responseCode = "404",
            description = "User not found",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = DemoException.class)
            )
        )
    })
    default Response getTeamByIdWithExcep(@PathParam("id") Integer teamId) throws DemoException {
        throw new DemoException("dummy exception");
    }

}
