package risk.Players;

import risk.Enums.CountryEnum;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<CountryEnum> countriesOwned;

    public Player(String name) {
        this.name = name;
        countriesOwned = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<CountryEnum> getCountries() {
        return countriesOwned;
    }

    public String getCountriesAsString() {
        StringBuilder sb = new StringBuilder(countriesOwned.get(0).name());
        for (int i = 1; i < countriesOwned.size(); i++) {
            sb.append(", ").append(countriesOwned.get(i).name());
        }
        return sb.toString();
    }

    public String getCountriesAsStringWithArmies() {
        StringBuilder sb = new StringBuilder(name + "'s countries:\n");
        for (CountryEnum c : countriesOwned) {
            sb.append(c.name()).append(": ").append(c.country.getArmies()).append('\n');
        }
        return sb.toString();
    }

    public void removeCountry(CountryEnum c) {
        countriesOwned.remove(c);
    }

    public void addCountry(CountryEnum c) {
        countriesOwned.add(c);
    }

    /**
     * Number of armies to add at start of turn.
     * Is equal to countries divided by 3 rounded down.
     *
     * @return number of arimes to add
     */
    public int newArmiesOnTurn() {
        return Math.max(3, countriesOwned.size() / 3);
    }

    public boolean addArmies(CountryEnum country, int numArmies) {
        int index = countriesOwned.indexOf(country);

        // Check if the country is owned or not.
        if (index == -1) {
            return false;
        }

        countriesOwned.get(index).country.addArmies(numArmies);
        return true;
    }

    public static int getInitialArmies(int players) {
        switch (players) {
            case 2:
                return 50;
            case 3:
                return 35;
            case 4:
                return 30;
            case 5:
                return 25;
            default:    // 6 players
                return 20;
        }
    }

    public boolean ownsCountry(CountryEnum country) {
        return countriesOwned.contains(country);
    }
}
