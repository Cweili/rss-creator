package org.cweili.feed.rss.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Item
 * 
 * @author Cweili
 * @version 2013-4-17 下午7:25:21
 * 
 */
public final class Item {

	private static final String ITEM_BEGIN = "<item>";
	private static final String ITEM_END = "</item>";
	private static final String TITLE_BEGIN = "<title>";
	private static final String TITLE_END = "</title>";
	private static final String LINK_BEGIN = "<link>";
	private static final String LINK_END = "</link>";
	private static final String DESCRIPTION_BEGIN = "<description>";
	private static final String DESCRIPTION_END = "</description>";
	private static final String AUTHOR_BEGIN = "<author>";
	private static final String AUTHOR_END = "</author>";
	private static final String GUID_BEGIN = "<guid isPermaLink=\"false\">";
	private static final String GUID_END = "</guid>";
	private static final String PUB_DATE_BEGIN = "<pubDate>";
	private static final String PUB_DATE_END = "</pubDate>";

	private String guid;
	private Date pubDate;
	private String title;
	private String description;
	private String link;
	private String author;
	private Set<Category> categories = new HashSet<Category>();

	/**
	 * Gets the GUID.
	 * 
	 * @return GUID
	 */
	public String getGUID() {
		return guid;
	}

	/**
	 * Sets the GUID with the specified GUID.
	 * 
	 * @param guid
	 *            the specified GUID
	 */
	public void setGUID(final String guid) {
		this.guid = guid;
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
	 * Gets publish date.
	 * 
	 * @return publish date
	 */
	public Date getPubDate() {
		return pubDate;
	}

	/**
	 * Sets the publish date with the specified publish date.
	 * 
	 * @param pubDate
	 *            the specified publish date
	 */
	public void setPubDate(final Date pubDate) {
		this.pubDate = pubDate;
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
		final StringBuilder stringBuilder = new StringBuilder(ITEM_BEGIN);

		stringBuilder.append(TITLE_BEGIN).append(title).append(TITLE_END);

		stringBuilder.append(LINK_BEGIN).append(link).append(LINK_END);

		stringBuilder.append(DESCRIPTION_BEGIN).append(description).append(DESCRIPTION_END);

		stringBuilder.append(AUTHOR_BEGIN).append(author).append(AUTHOR_END);

		stringBuilder.append(GUID_BEGIN).append(guid).append(GUID_END);

		for (final Category category : categories) {
			stringBuilder.append(category.toString());
		}

		stringBuilder.append(PUB_DATE_BEGIN);
		stringBuilder.append(DateFormatUtils.format(pubDate, "EEE, dd MMM yyyy HH:mm:ss z",
				TimeZone.getTimeZone(Channel.TIME_ZONE_ID)));
		stringBuilder.append(PUB_DATE_END);

		stringBuilder.append(ITEM_END);

		return stringBuilder.toString();
	}
}
