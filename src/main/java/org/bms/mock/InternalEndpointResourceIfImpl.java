package org.bms.mock;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.bms.core.InternalEndpointResourceIf;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/dummy/api/v1/internal")
public class InternalEndpointResourceIfImpl implements InternalEndpointResourceIf {

    private static final Logger LOGGER = Logger.getLogger(InternalEndpointResourceIfImpl.class);

    private static final List<String> roles = List.of(
        "Administrator",
        "Manager",
        "Coach",
        "Player"
    );

    @Override
    public Response getRoles(int offset, int limit) {
        List<String> players = roles.subList(offset, Math.min(offset + limit, roles.size()));
        return Response.ok(players).build();
    }
}
