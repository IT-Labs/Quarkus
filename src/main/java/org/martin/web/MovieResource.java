package org.martin.web;

import org.jboss.logging.Logger;
import org.martin.entity.Movie;
import org.martin.repository.MovieRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {

    @Inject
    MovieRepository movieRepository;

    @Inject
    Logger logger;

    @GET
    public List<Movie> getAllMovies() {
        logger.info("Return all movies");
        return movieRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Movie getById(@PathParam("id") Long id)
    {
        logger.info("Returning a movie with id " + id );
        return movieRepository.findById(id);
    }

    @Transactional
    @POST
    public Response create(Movie movie) {
        logger.info("Returns the number of books");
        movieRepository.persist(movie);
        return Response.status(Response.Status.CREATED).build();
    }

    @Transactional
    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        logger.info("Deleting a movie");
        movieRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
