import java.util.ArrayList;

public class ContentDemo {

    public static void main(String[] args) {

        int currentYear = 2025;

        ArrayList<ContentItem> list = new ArrayList<>();

        list.add(new VideoLecture("Java Basics", 2023, 60, "HD"));
        list.add(new VideoLecture("OOP", 2021, 90, "4K"));

        list.add(new PodcastEpisode("Tech Talk", 2024, 30, "Alice"));
        list.add(new PodcastEpisode("AI News", 2020, 45, "Bob"));

        for (int i = 0; i < list.size(); i++) {
            ContentItem item = list.get(i);

            System.out.println(item);
            System.out.println("Cost: " + item.getLicenseCost(currentYear));

            Downloadable d = (Downloadable) item;
            d.download();
            System.out.println("Max per day: " + d.getMaxDownloadsPerDay());
            System.out.println();
        }
    }
}