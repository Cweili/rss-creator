package org.cweili.feed.rss;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.cweili.feed.rss.model.Category;
import org.cweili.feed.rss.model.Channel;
import org.cweili.feed.rss.model.Item;

/**
 * RSS 2.0
 * 
 * <p>
 * See <a href="http://cyber.law.harvard.edu/rss/rss.html">RSS 2.0 at Harvard
 * Law</a> for more details.
 * </p>
 * 
 * @author Cweili
 * @version 2013-4-17 下午7:56:47
 */
public class RSS {

	private String title;
	private String link;
	private String atomLink;
	private String description;
	private String generator;
	private Date lastBuildDate;
	private String language;
	private List<Item> items = new ArrayList<Item>();

	/**
	 * A empty RSS feed.
	 */
	public RSS() {
		title = "";
		link = "";
		atomLink = "";
		description = "";
		generator = "";
		lastBuildDate = new Date();
		language = "zh-CN";
	}

	/**
	 * Generate default Chinese RSS feed.
	 * 
	 * @param title
	 *            the title
	 * @param link
	 *            the link
	 * @param atomLink
	 *            the atom link
	 * @param description
	 *            the description
	 * @param generator
	 *            the specified generator
	 * @param lastBuildDate
	 *            the specified last build date
	 */
	public RSS(String title, String link, String atomLink, String description, String generator,
			Date lastBuildDate) {
		this.title = title;
		this.link = link;
		this.atomLink = atomLink;
		this.description = description;
		this.generator = generator;
		this.lastBuildDate = lastBuildDate;
		this.language = "zh-CN";
	}

	/**
	 * Generate RSS feed.
	 * 
	 * @param title
	 *            the title
	 * @param link
	 *            the link
	 * @param atomLink
	 *            the atom link
	 * @param description
	 *            the description
	 * @param generator
	 *            the specified generator
	 * @param lastBuildDate
	 *            the specified last build date
	 * @param language
	 *            the specified language
	 */
	public RSS(String title, String link, String atomLink, String description, String generator,
			Date lastBuildDate, String language) {
		this.title = title;
		this.link = link;
		this.atomLink = atomLink;
		this.description = description;
		this.generator = generator;
		this.lastBuildDate = lastBuildDate;
		this.language = language;
	}

	/**
	 * Adds the specified item.
	 * 
	 * @param title
	 *            the title
	 * @param link
	 *            the permalink
	 * @param author
	 *            the author
	 * @param description
	 *            the description
	 * @param pubDate
	 *            the specified publish date
	 * @param categories
	 *            the categories
	 */
	public void addItem(String title, String link, String author, String description, Date pubDate,
			Collection<String> categories) {
		Item item = new Item();
		item.setTitle(title);
		item.setLink(link);
		item.setGUID(link);
		item.setAuthor(author);
		item.setDescription(description);
		item.setPubDate(pubDate);

		for (String term : categories) {
			Category category = new Category();
			category.setTerm(term);
			item.addCatetory(category);
		}

		items.add(item);
	}

	/**
	 * Adds the specified item.
	 * 
	 * @param title
	 *            the title
	 * @param link
	 *            the permalink
	 * @param author
	 *            the author
	 * @param description
	 *            the description
	 * @param pubDate
	 *            the specified publish date
	 * @param categories
	 *            the categories
	 */
	public void addItem(String title, String link, String author, String description, Date pubDate,
			String[] categories) {
		Item item = new Item();
		item.setTitle(title);
		item.setLink(link);
		item.setGUID(link);
		item.setAuthor(author);
		item.setDescription(description);
		item.setPubDate(pubDate);

		for (String term : categories) {
			Category category = new Category();
			category.setTerm(term);
			item.addCatetory(category);
		}

		items.add(item);
	}

	/**
	 * Adds the specified item.
	 * 
	 * @param title
	 *            the title
	 * @param link
	 *            the permalink
	 * @param guid
	 *            the specified GUID
	 * @param author
	 *            the author
	 * @param description
	 *            the description
	 * @param pubDate
	 *            the specified publish date
	 * @param categories
	 *            the categories
	 */
	public void addItem(String title, String link, String guid, String author, String description,
			Date pubDate, Collection<String> categories) {
		Item item = new Item();
		item.setTitle(title);
		item.setLink(link);
		item.setGUID(guid);
		item.setAuthor(author);
		item.setDescription(description);
		item.setPubDate(pubDate);

		for (String term : categories) {
			Category category = new Category();
			category.setTerm(term);
			item.addCatetory(category);
		}

		items.add(item);
	}

	/**
	 * Adds the specified item.
	 * 
	 * @param title
	 *            the title
	 * @param link
	 *            the permalink
	 * @param guid
	 *            the specified GUID
	 * @param author
	 *            the author
	 * @param description
	 *            the description
	 * @param pubDate
	 *            the specified publish date
	 * @param categories
	 *            the categories
	 */
	public void addItem(String title, String link, String guid, String author, String description,
			Date pubDate, String[] categories) {
		Item item = new Item();
		item.setTitle(title);
		item.setLink(link);
		item.setGUID(guid);
		item.setAuthor(author);
		item.setDescription(description);
		item.setPubDate(pubDate);

		for (String term : categories) {
			Category category = new Category();
			category.setTerm(term);
			item.addCatetory(category);
		}

		items.add(item);
	}

	/**
	 * Sets the atom link with the specified atom link.
	 * 
	 * @param atomLink
	 *            the specified atom link
	 */
	public void setAtomLink(final String atomLink) {
		this.atomLink = atomLink;
	}

	/**
	 * Gets the atom link.
	 * 
	 * @return atom link
	 */
	public String getAtomLink() {
		return atomLink;
	}

	/**
	 * Gets the last build date.
	 * 
	 * @return last build date
	 */
	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	/**
	 * Sets the last build date with the specified last build date.
	 * 
	 * @param lastBuildDate
	 *            the specified last build date
	 */
	public void setLastBuildDate(final Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	/**
	 * Gets generator.
	 * 
	 * @return generator
	 */
	public String getGenerator() {
		return generator;
	}

	/**
	 * Sets the generator with the specified generator.
	 * 
	 * @param generator
	 *            the specified generator
	 */
	public void setGenerator(final String generator) {
		this.generator = generator;
	}

	/**
	 * Gets the link.
	 * 
	 * @return link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the link with the specified link.
	 * 
	 * @param link
	 *            the specified link
	 */
	public void setLink(final String link) {
		this.link = link;
	}

	/**
	 * Gets the title.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title with the specified title.
	 * 
	 * @param title
	 *            the specified title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description with the specified description.
	 * 
	 * @param description
	 *            the specified description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Gets the language.
	 * 
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language with the specified language.
	 * 
	 * @param language
	 *            the specified language
	 */
	public void setLanguage(final String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		final Channel channel = new Channel();
		channel.setTitle(title);
		channel.setLink(link);
		channel.setAtomLink(atomLink);
		channel.setDescription(description);
		channel.setGenerator(generator);
		channel.setLastBuildDate(lastBuildDate);
		channel.setLanguage(language);

		for (Item item : items) {
			channel.addItem(item);
		}
		return channel.toString();
	}

}
