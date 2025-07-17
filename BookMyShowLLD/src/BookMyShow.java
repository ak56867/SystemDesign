import Enum.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        // creating movieController and theatreController
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        bookMyShow.createBooking(City.DELHI, "Avengers");

        bookMyShow.createBooking(City.MUMBAI, "Batman");

        bookMyShow.createBooking(City.DELHI, "Avengers");
    }

    void createBooking(City city, String movieName) {
        //get list of all movies in the city
        List<Movie> moviesInCity = movieController.getMoviesByCity(city);

        //find given movie by name
        Movie interestedMovie = null;
        for(Movie movie: moviesInCity) {
            if((movie.movieName).equalsIgnoreCase(movieName)) {
                interestedMovie = movie;
                break;
            }
        }

        //get all the theatre-wise shows for the movie
        Map<Theatre,List<Show>> theatreVsShows = theatreController.getAllShowsOfMovieInCity(city, interestedMovie);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = theatreVsShows.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatID() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");


    }

    void initialize() {
        createMovies();
        createTheatres();
    }

    void createMovies() {
        //create 2 movies
        Movie avengers = new Movie();
        avengers.setMovieID(101);
        avengers.setMovieName("Avengers");

        Movie batman = new Movie();
        batman.setMovieID(102);
        batman.setMovieName("Batman");

        //add movies to controller
        movieController.addMovie(City.DELHI, avengers);
        movieController.addMovie(City.DELHI, batman);
        movieController.addMovie(City.MUMBAI, batman);
        movieController.addMovie(City.MUMBAI, avengers);
    }

    void createTheatres() {
        Movie avengers = movieController.getMovieByName("Avengers");
        Movie batman = movieController.getMovieByName("Batman");

        //create theatres
        Theatre inox = new Theatre();
        inox.setTheatreID(1);
        inox.setCity(City.DELHI);
        inox.setScreens(createScreens());
        //create shows for theatre
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inox.getScreens().get(0), avengers, 8);
        Show inoxEveningShow = createShows(2, inox.getScreens().get(0), batman, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inox.setShows(inoxShows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreID(2);
        pvrTheatre.setScreens(createScreens());
        pvrTheatre.setCity(City.MUMBAI);
        //create shows for theatre
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreens().get(0), avengers, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreens().get(0), batman, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        //add theatres to controller
        theatreController.addTheatre(City.DELHI, inox);
        theatreController.addTheatre(City.MUMBAI, pvrTheatre);


    }

     List<Screen> createScreens() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenID(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatID(i);
            seats.add(seat);
        }

        return seats;
    }

    Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Show show = new Show();
        show.setShowID(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }


}