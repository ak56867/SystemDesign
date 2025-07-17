import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Enum.City;

public class MovieController {
    public Map<City, List<Movie>> cityMovieMap;
    public List<Movie> allMovies;

    public MovieController() {
        cityMovieMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(City city, Movie movie) {
        //add movie to all movies list
        allMovies.add(movie);

        //add movie to city
        List<Movie> movies = cityMovieMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovieMap.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {
        for(Movie movie: allMovies) {
            if((movie.movieName).equalsIgnoreCase(movieName))
                return movie;
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityMovieMap.get(city);
    }

    //REMOVE movie from a particular city, make use of cityVsMovies map

    //UPDATE movie of a particular city, make use of cityVsMovies map

    //CRUD operation based on Movie ID, make use of allMovies list

}
