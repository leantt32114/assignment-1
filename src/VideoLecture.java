public class VideoLecture extends ContentItem implements Downloadable {

    private String quality;

    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes);
        this.quality = quality;
    }

    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        double cost = 0.05 * durationMinutes;

        if (age <= 2) {
            cost = cost + 5;
        } else {
            cost = cost + 2;
        }

        return cost;
    }

    public void download() {
        System.out.println("Downloading video in " + quality);
    }

    public int getMaxDownloadsPerDay() {
        return 3;
    }

    public String toString() {
        return super.toString() + ", quality=" + quality;
    }
}