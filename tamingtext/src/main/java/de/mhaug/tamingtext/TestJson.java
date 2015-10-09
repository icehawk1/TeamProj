package de.mhaug.tamingtext;

import com.google.gson.annotations.SerializedName;

public class TestJson {
	@SerializedName("CurrentTest")
	public CurrentTest currentTest = null;
	public String source = "";

	@Override
	public String toString() {
		return source + "|" + currentTest.toString();
	}

	public static class CurrentTest {
		public String peng = "";
		public String bumm = "";

		@Override
		public String toString() {
			return "(" + peng + ", " + bumm + ")";
		}
	}
}
