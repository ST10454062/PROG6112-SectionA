
package com.mycompany.tvseries;

import java.util.Scanner;

public class TVSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series series = new Series(); // Create an instance

        while (true) {
            System.out.println("\nLATEST SERIES 2025");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String option = scanner.nextLine();
            if (!option.equals("1")) {  // Exit loop
                break;
            }

            // Display menu options
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report 2025.");
            System.out.println("(6) Exit Application.");

            option = scanner.nextLine();

            // Handle user selection using switch-case
            switch (option) {
                case "1": series.CaptureSeries(); break;
                case "2": series.SearchSeries(); break;
                case "3": series.UpdateSeries(); break;
                case "4": series.DeleteSeries(); break;
                case "5": series.SeriesReport(); break;
                case "6": series.ExitSeriesApplication(); break;
                default: System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Application closed.");
        scanner.close();
    }
}
