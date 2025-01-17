package part2exceptions;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Exception Handling and Assertions
Topic:  try-with-resources
Sub-topic:  Suppressed Exceptions
*/

// Season implements AutoCloseable
public class Season implements AutoCloseable {
    // Each season has a season number
    private int seasonNumber;

    // Constructor for Season
    public Season(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    // Episode is an inner class that also implements AutoCloseable
    public class Episode implements AutoCloseable {
        // Each episode has an episode number
        private int episodeNumber;

        // Constructor for Episode
        public Episode(int episodeNumber) {
            this.episodeNumber = episodeNumber;
        }

        // Overridden close method
        public void close() {
            System.out.println("Trying to close the Episode");
            // Introduce Exception during the close for episode 1 only
            if (this.episodeNumber == 1)
                throw new RuntimeException("Closing Failed on Episode");
            System.out.println("Closed the episode");
        }

        public void run() {
            System.out.println("Running Episode " + this.episodeNumber);
            // Introduce Exception during the run for episode 1 only
            if (this.episodeNumber == 1)
                throw new RuntimeException("Episode failed");
        }
    }

    // Overridden close method
    public void close() {
        System.out.println("Trying to close the Season");
        // Introduce an Exception during the close for season 1 only
        if (this.seasonNumber == 1)
            throw new RuntimeException("Closing Failed on Season");
        System.out.println("Closed the Season");
    }

    public void run() {
        System.out.println("Running Series " + this.seasonNumber);
        if (this.seasonNumber == 1)
            throw new RuntimeException("Season failed");
    }

    public static void main(String[] args) {

        // Main method kicks off the first Season & Episode using basic
        // try-with-resources statement with two AutoCloseable resources...
        try (
                Season s = new Season(1);
                Season.Episode e = s.new Episode(1)) {
            s.run();
            e.run();
        } catch (Exception e) {
        System.out.println("ERROR CAUGHT: " + e);

        for (Throwable t : e.getSuppressed()) {
            System.out.println("SUPPRESSED: " + t);
        }
    }
    }
}