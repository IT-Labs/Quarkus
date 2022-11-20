package org.martin.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.martin.entity.Movie;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {
}
