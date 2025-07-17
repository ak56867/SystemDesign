import java.util.ArrayList;
import java.util.List;
import Enum.City;

public class Theatre {
    public int theatreID;
    public City city;
    public List<Show> shows = new ArrayList<>();
    public List<Screen> screens = new ArrayList<>();

    public int getTheatreID() {
        return theatreID;
    }

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
