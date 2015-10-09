package de.mhaug.tamingtext;

import org.jsoup.Jsoup;

import com.google.gson.annotations.SerializedName;

public class News {
	// public List<CurrentNews> currentNews = new ArrayList<>();
	@SerializedName("CurrentNews")
	public CurrentNews currentNews = null;
	@SerializedName("Source")
	public String source = "";

	public void sanitize() {
		if (currentNews != null)
			currentNews.sanitize();
	}

	@Override
	public String toString() {
		if (currentNews != null)
			return currentNews.toString();
		else
			return "null";
	}

	public class CurrentNews {
		@SerializedName("Title")
		public String title = "";
		@SerializedName("Description")
		public String description = "";
		@SerializedName("MainStory")
		public String mainStory = "";

		public void sanitize() {
			title = Jsoup.parse(title).text();
			description = Jsoup.parse(description).text();
			mainStory = Jsoup.parse(mainStory).text();
		}

		@Override
		public String toString() {
			return title;
		}
	}
}
