package org.cweili.feed.atom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.cweili.feed.atom.model.Category;
import org.cweili.feed.atom.model.Entry;
import org.cweili.feed.atom.model.Feed;

/**
 * Atom 1.0 feed
 * 
 * <p>
 * See <a href="http://tools.ietf.org/html/rfc4287">RFC 4278</a> for more
 * details.
 * </p>
 * 
 * @author Cweili
 * @version 2013-4-17 下午8:49:36
 */
public class Atom {

	private String title;
	private String subtitle;
	private String link;
	private String author;
	private String id;
	private Date updated;
	private List<Entry> entries = new ArrayList<Entry>();

	/**
	 * A empty Atom feed.
	 */
	public Atom() {
		title = "";
		subtitle = "";
		link = "";
		author = "";
		id = "";
		updated = new Date();
	}

	/**
	 * Generate Atom feed.
	 * 
	 * @param title
	 *            the title
	 * @param subtitle
	 *            the subtitle
	 * @param link
	 *            the link
	 * @param author
	 *            the author
	 * @param id
	 *            the specified id
	 * @param updated
	 *            the specified updated time
	 */
	public Atom(String title, String subtitle, String link, String author, String id, Date updated) {
		this.title = title;
		this.subtitle = subtitle;
		this.link = link;
		this.author = author;
		this.id = id;
		this.updated = updated;
	}

	/**
	 * Adds the specified entry.
	 * 
	 * @param title
	 *            the title
	 * @param link
	 *            the link
	 * @param uri
	 *            the uri
	 * @param id
	 *            the specified id
	 * @param author
	 *            the author
	 * @param summary
	 *            the summary
	 * @param updated
	 *            the specified updated time
	 * @param categories
	 *            the categories
	 */
	public void addEntry(String title, String link, String uri, String id, String author,
			String summary, Date updated, Collection<String> categories) {
		Entry entry = new Entry();
		entry.setTitle(title);
		entry.setLink(link);
		entry.setURI(uri);
		entry.setId(id);
		entry.setAuthor(author);
		entry.setSummary(summary);
		entry.setUpdated(updated);

		for (String term : categories) {
			Category category = new Category();
			category.setTerm(term);
			entries.add(entry);
		}
	}

	/**
	 * Gets the id.
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id with the specified id.
	 * 
	 * @param id
	 *            the specified id
	 */
	public void setId(final String id) {
		this.id = id;
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
	 * Gets the subtitle.
	 * 
	 * @return subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Sets the subtitle with the specified subtitle.
	 * 
	 * @param subtitle
	 *            the specified subtitle
	 */
	public void setSubtitle(final String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * Gets the author.
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author with the specified author.
	 * 
	 * @param author
	 *            the specified author
	 */
	public void setAuthor(final String author) {
		this.author = author;
	}

	/**
	 * Gets update date.
	 * 
	 * @return update date
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * Sets the update date with the specified update date.
	 * 
	 * @param updated
	 *            the specified update date
	 */
	public void setUpdated(final Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		final Feed feed = new Feed();
		feed.setTitle(title);
		feed.setSubtitle(subtitle);
		feed.setLink(link);
		feed.setAuthor(author);
		feed.setId(id);
		feed.setUpdated(updated);

		for (Entry entry : entries) {
			feed.addEntry(entry);
		}
		return feed.toString();
	}

}
