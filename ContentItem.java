public abstract class ContentItem {

    protected int id;
    protected static int idGen = 1;

    protected String title;
    protected int year;
    protected int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        id = idGen;
        idGen++;

        if (title == null || title.equals("")) {
            throw new IllegalArgumentException();
        }
        this.title = title;

        int now = java.time.Year.now().getValue();
        if (year < 1990 || year > now) {
            throw new IllegalArgumentException();
        }
        this.year = year;

        if (durationMinutes <= 0) {
            throw new IllegalArgumentException();
        }
        this.durationMinutes = durationMinutes;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double getLicenseCost(int currentYear);

    public String toString() {
        return "id=" + id + ", title=" + title + ", year=" + year + ", duration=" + durationMinutes;
    }
}