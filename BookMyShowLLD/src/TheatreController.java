import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Enum.City;

public class TheatreController {
    public Map<City, List<Theatre>> cityTheatreMap;
    public List<Theatre> allTheatres;

    public TheatreController() {
        cityTheatreMap = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public void addTheatre(City city, Theatre theatre) {
        //add to all theatres list
        allTheatres.add(theatre);

        //add to city
        List<Theatre> theatres = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityTheatreMap.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getAllShowsOfMovieInCity(City city, Movie movie) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>(); //to return list of shows for each theatre for that particular movie

        List<Theatre> theatres = cityTheatreMap.get(city);

        for(Theatre theatre: theatres) {    //traverse each theatre
            List<Show> shows = theatre.getShows();
            List<Show> showsOfMovie = new ArrayList<>();

            for(Show show: shows) { //traverse each show of each theatre
                if(show.movie.getMovieID() == movie.movieID) { //if show is of the required movie then add it to list
                    showsOfMovie.add(show);
                }
            }
            if(!showsOfMovie.isEmpty()) {   //if list is not empty create a key value in map
                theatreVsShows.put(theatre, showsOfMovie);
            }
        }
        return  theatreVsShows;
    }
}
