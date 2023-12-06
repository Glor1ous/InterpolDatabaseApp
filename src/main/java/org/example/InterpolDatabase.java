package org.example;
import java.util.ArrayList;

class InterpolDatabase {
    private ArrayList<Criminal> criminals = new ArrayList<>();

    public void addCriminal(Criminal criminal) {
        criminals.add(criminal);
    }

    public ArrayList<Criminal> searchCriminals(int searchOption, String searchValue) {
        ArrayList<Criminal> foundCriminals = new ArrayList<>();

        for (Criminal criminal : criminals) {
            if (criminal.matchesSearchCriteria(searchOption, searchValue)) {
                foundCriminals.add(criminal);
            }
        }

        return foundCriminals;
    }

    public boolean deleteCriminal(String lastName) {
        for (Criminal criminal : criminals) {
            if (criminal.getLastName().equals(lastName)) {
                criminals.remove(criminal);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("=== База данных ===\n");
        for (Criminal criminal : criminals) {
            result.append("=================================\n");
            result.append(criminal.toString());
        }
        return result.toString();
    }
}
