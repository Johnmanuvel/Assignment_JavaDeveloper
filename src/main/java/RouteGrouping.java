package main.java;

import java.util.*;

public class RouteGrouping {
    private static void addRoute(Map<Integer, List<String>> fareRouteMap, String route, int fare) {
        List<String> routes = fareRouteMap.get(fare);
        if (routes == null) {
            routes = new ArrayList<>();
            fareRouteMap.put(fare, routes);
        }
        routes.add(route);
    }

    public static void main(String[] args) {
        Map<Integer, List<String>> fareRouteMap = new HashMap<>();
        String[] inputData = {
                "13 10",
                "13-c 15",
                "342-R 10",
                "146-Q 10",
                "27 15",
                "29-A 12",
                "215-U 12",
                "27-E1 15",
                "13J 12",
                "SBS-D34G 10"
        };

        for (String input : inputData) {
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                String route = parts[0];
                int fare;

                try {
                    fare = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid fare format: " + parts[1]);
                    continue;
                }
                addRoute(fareRouteMap, route, fare);
            } else {
                System.out.println("Invalid input format: " + input);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fare: ");

        int userFare;
        try {
            userFare = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid fare format. Please enter a valid integer.");
            return;
        }
        List<String> routesForFare = fareRouteMap.get(userFare);
        if (routesForFare != null) {
            System.out.println("Routes for fare " + userFare + ": " + routesForFare);
        } else {
            System.out.println("No routes found for fare " + userFare);
        }
    }
}
