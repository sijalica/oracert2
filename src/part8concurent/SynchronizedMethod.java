package part8concurent;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Shared data approaches
*/

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// This class represents a ball which contains information
// about who hit the ball and how many times each player hit it
class TheBallInTheAir {

    private String ballType = "Volleyball";
    // Total number of hits on the ball

    private int hit;
    // Map of players and their hits..
    private Map<String, Integer> players = new TreeMap<>();

    // Method called by threads, adds player to map if not found
    // or increments value in map
    public int addHit(String player) {
        synchronized (this) {
            this.hit++;
        }

        if (players.containsKey(player)) {
            players.computeIfPresent(player, (key, val) -> ++val);
        } else {
            if (players.putIfAbsent(player, 1) != null) {
                System.out.println("Race encountered");
                players.computeIfPresent(player, (key, val) -> ++val);
            }
        }

        return this.hit;
    }

    // Present writeable output
    public String toString() {
        return "Total " + ballType + " hits: " + this.hit
                + ", Player hits: " + players.values().stream().mapToInt(s -> s).sum()
                + "\nPlayers List: " + players;
    }
}

public class SynchronizedMethod {

    // Create a shared ball.
    public static TheBallInTheAir sharedBall = new TheBallInTheAir();

    public static void main(String[] args) {
        // Set up players
        String[] players = {"Jane", "Mary", "Ralph", "Joe"};
        Random r = new Random();
        // random list of player names, representing their turn to hit ball
        List<String> playerTurns =
                Stream.generate(() -> players[r.nextInt(4)])
                        .limit(100)
                        .collect(Collectors.toList());

        ExecutorService executorService = null;

        try {
            executorService = Executors.newSingleThreadExecutor();

            // Start the volleyball game...
            for (String player : playerTurns) {
                executorService.submit(() -> sharedBall.addHit(player));
            }

        } finally {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    // Wait no longer than 1 second for completion confirmation
                    executorService.awaitTermination(1, TimeUnit.SECONDS);
                    System.out.println(sharedBall);

                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}