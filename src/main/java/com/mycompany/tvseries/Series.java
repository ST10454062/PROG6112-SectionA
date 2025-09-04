
package com.mycompany.tvseries;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    
    public ArrayList<SeriesModel> getSeriesList() {
        return seriesList;
    }

    // 1. Capture a new series
    public void CaptureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");

        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        int age = getValidAge();

        System.out.print("Enter the number of episodes for " + name + ": ");
        int episodes = Integer.parseInt(scanner.nextLine());

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
    }

    // Helper method for age validation
    private int getValidAge() {
        int age = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter the series age restriction: ");
            String input = scanner.nextLine();
            try {
                age = Integer.parseInt(input);
                if (age >= 2 && age <= 18) { // Valid age range
                    valid = true;
                } else {
                    System.out.println("You have entered an incorrect series age!!! Please re-enter the series age >>");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!!! Please re-enter the series age >>");
            }
        }
        return age;
    }

    // 2. Search for a series by ID
    public void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.println(s.toString());
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    // 3. Update series
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.print("Enter the series name: ");
                s.setSeriesName(scanner.nextLine());

                s.setSeriesAge(getValidAge());

                System.out.print("Enter the number of episodes: ");
                s.setSeriesNumberOfEpisodes(Integer.parseInt(scanner.nextLine()));

                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }
    
    // Series.java
    public SeriesModel findSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    // 4. Delete series
    public void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete: ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    seriesList.remove(s);
                    System.out.println("Series with Series Id: " + id + " WAS deleted!");
                } else {
                    System.out.println("Delete cancelled.");
                }
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    // 5. Print report of all series
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available to display.");
        } else {
            int count = 1;
            for (SeriesModel s : seriesList) {
                System.out.println("\nSeries " + count);
                System.out.println(s.toString());
                count++;
            }
        }
    }

    // 6. Exit application
    public void ExitSeriesApplication() {
        System.out.println("Exiting application... Goodbye!");
        System.exit(0);
    }
}

