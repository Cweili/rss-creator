package org.cweili.feed.atom.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

/**
 * Entry
 * 
 * @author Cweili
 * @version 2013-4-17 下午6:59:22
 * 
 */
public final class Entry implements Serializable, Cloneable {

	private static final long serialVersionUID = 3445981458816005673L;
	private static final String ENTRY_BEGIN = "<entry>";
	private static final String ENTRY_END = "</entry>";
	private static final String TITLE_BEGIN = "<title type=\"text\">";
	private static final String TITLE_END = "</title>";
	private static final String AUTHOR_BEGIN = "<author>";
	private static final String AUTHOR_END = "</author>";
	private static final String NAME_BEGIN = "<name>";
	private static final String NAME_END = "</name>";
	private static final String URI_BEGIN = "<uri>";
	private static final String URI_END = "</uri>";
	private static final String ID_BEGIN = "<id>";
	private static final String ID_END = "</id>";
	private static final String SUMMARY_BEGIN = "<summary type=\"html\">";
	private static final String SUMMARY_END = "</summary>";
	private static final String LINK_BEGIN = "<link href=\"";
	private static final String LINK_END = "\" />";
	private static final String UPDATED_BEGIN = "<updated>";
	private static final String UPDATED_END = "</updated>";

	private String id;
	private Date updated;
	private String title;
	private String summary;
	private String link;
	private String author;
	private String uri;
	private Set<Category> categories = new HashSet<Category>();

	/**
	 * Gets the URI.
	 * 
	 * @return URI
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * Sets the URI with the specified URI.
	 * 
	 * @param uri
	 *            the specified URI
	 */
	public void setURI(final String uri) {
		this.uri = uri;
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

	/**
	 * Gets the summary.
	 * 
	 * @return summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the summary with the specified summary.
	 * 
	 * @param summary
	 *            the specified summary
	 */
	public void setSummary(final String summary) {
		this.summary = summary;
	}

	/**
	 * Gets the categories.
	 * 
	 * @return categories
	 */
	public Set<Category> getCatetories() {
		return Collections.unmodifiableSet(categories);
	}

	/**
	 * Adds the specified category.
	 * 
	 * @param category
	 *            the specified category
	 */
	public void addCatetory(final Category category) {
		categories.add(category);
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder(ENTRY_BEGIN);

		stringBuilder.append(TITLE_BEGIN).append(title).append(TITLE_END);

		stringBuilder.append(AUTHOR_BEGIN);
		stringBuilder.append(NAME_BEGIN).append(author).append(NAME_END);
		stringBuilder.append(URI_BEGIN).append(uri).append(URI_END);
		stringBuilder.append(AUTHOR_END);

		for (final Category category : categories) {
			stringBuilder.append(category.toString());
		}

		stringBuilder.append(LINK_BEGIN).append(link).append(LINK_END);
		stringBuilder.append(ID_BEGIN).append(id).append(ID_END);

		stringBuilder.append(UPDATED_BEGIN);
		stringBuilder.append(DateFormatUtils.format(
				// using ISO-8601 instead of RFC-3339
				updated, DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(),
				TimeZone.getTimeZone(Feed.TIME_ZONE_ID)));
		stringBuilder.append(UPDATED_END);

		stringBuilder.append(SUMMARY_BEGIN).append(summary).append(SUMMARY_END);

		stringBuilder.append(ENTRY_END);

		return stringBuilder.toString();
	}
}
