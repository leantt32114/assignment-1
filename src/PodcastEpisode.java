public class PodcastEpisode extends ContentItem implements Downloadable {

    private String hostName;

    public PodcastEpisode(String title, int year, int durationMinutes, String hostName) {
        super(title, year, durationMinutes);
        this.hostName = hostName;
    }

    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        double cost = 0.03 * durationMinutes;

        if (age <= 2) {
            cost = cost + 3;
        } else {
            cost = cost + 1;
        }

        return cost;
    }

    public void download() {
        System.out.println("Downloading podcast by " + hostName);
    }

    public int getMaxDownloadsPerDay() {
        return 10;
    }

    public String toString() {
        return super.toString() + ", host=" + hostName;
    }
}