package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class InterpolDatabase {
    private static final String DATABASE_FILE = "interpol_database.json";
    private ArrayList<Criminal> criminals;

    public InterpolDatabase() {
        loadDatabase();
    }

    public void addCriminal(Criminal criminal) {
        criminals.add(criminal);
        saveDatabase();
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
        Criminal criminalToDelete = null;
        for (Criminal criminal : criminals) {
            if (criminal.getLastName().equals(lastName)) {
                criminalToDelete = criminal;
                break;
            }
        }

        if (criminalToDelete != null) {
            criminals.remove(criminalToDelete);
            saveDatabase();
            return true;
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

    private void saveDatabase() {
        try (Writer writer = new FileWriter(DATABASE_FILE)) {
            Gson gson = new Gson();
            gson.toJson(criminals, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDatabase() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(DATABASE_FILE));
            TypeToken<ArrayList<Criminal>> token = new TypeToken<>() {};
            criminals = new Gson().fromJson(reader, token.getType());
            if (criminals == null) {
                criminals = new ArrayList<>();
            }
        } catch (IOException e) {
            criminals = new ArrayList<>();
        }
    }
}
