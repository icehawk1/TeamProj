package de.mhaug.tamingtext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		List<News> input = main.readNewsFiles();
		main.doNER(input);
	}

	private List<News> readNewsFiles() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		File newsFile = new File("src/main/resources/news/03_10_2015.json");
		Gson gson = new Gson();

		Type collectionType = new TypeToken<Collection<News>>() {
		}.getType();
		List<News> result = gson.fromJson(new FileReader(newsFile), collectionType);

		for (News elem : result)
			elem.sanitize();

		return result;
	}

	private void doNER(List<News> input) throws InvalidFormatException, FileNotFoundException, IOException {
		Tokenizer tokenizer = SimpleTokenizer.INSTANCE;
		NameFinderME orgFinder = new NameFinderME(new TokenNameFinderModel(new FileInputStream(
				"src/main/resources/en-ner-organization.bin")));
		NameFinderME personFinder = new NameFinderME(new TokenNameFinderModel(new FileInputStream(
				"src/main/resources/en-ner-person.bin")));
		NameFinderME locationFinder = new NameFinderME(new TokenNameFinderModel(new FileInputStream(
				"src/main/resources/en-ner-location.bin")));

		findEntities(input, tokenizer, orgFinder);
		findEntities(input, tokenizer, personFinder);
		findEntities(input, tokenizer, locationFinder);
	}

	private void findEntities(List<News> input, Tokenizer tokenizer, NameFinderME entityFinder) throws IOException,
			InvalidFormatException, FileNotFoundException {

		for (News elem : input) {
			String[] tokens = tokenizer.tokenize(elem.currentNews.mainStory);
			Span[] names = entityFinder.find(tokens);
			displayNames(names, tokens);
		}
	}

	private void displayNames(Span[] names, String[] tokens) {
		for (int si = 0; si < names.length; si++) {
			StringBuilder cb = new StringBuilder();
			for (int ti = names[si].getStart(); ti < names[si].getEnd(); ti++) {
				cb.append(tokens[ti]).append(" ");
			}
			System.out.print(cb.substring(0, cb.length() - 1) + "\t\t ");
			System.out.println("ttype: " + names[si].getType());
		}
	}
}
