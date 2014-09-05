package org.jugvale.call4papers.rest.utils;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class RESTUtils {

	public static <T> T lanca404SeNulo(T object, String message) {
		if (object == null) {
			throw new WebApplicationException(Response.status(NOT_FOUND)
					.entity(message).build());
		}
		return object;
	}

	public static <T> T lanca404SeNulo(T object, long id) {
		return lanca404SeNulo(object, "ID: '" + id + "' não encontrado");
	}

	public static Response recursoCriado(Class<?> resource, long id) {
		return Response.created( UriBuilder.fromResource(resource)
								.path(String.valueOf(id)).build())
								.build();
	}
}
