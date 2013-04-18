package org.cweili.feed.atom.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.cweili.feed.util.Utils;

/**
 * Atom 1.0 feed
 * 
 * <p>
 * See <a href="http://tools.ietf.org/html/rfc4287">RFC 4278</a> for more
 * details.
 * </p>
 * 
 * @author Cweili
 * @version 2013-4-17 下午6:59:45
 * @see Entry
 * @see Category
 */
public final class Feed implements Serializable, Cloneable {

	private static final long serialVersionUID = 2536558722965102764L;
	private static final String FEED_BEGIN = "<?xml version=\"1.0\"?><feed xmlns=\"http://www.w3.org/2005/Atom\">";
	private static final String FEED_END = "</feed>";
	private static final String ID_BEGIN = "<id>";
	private static final String ID_END = "</id>";
	private static final String TITLE_BEGIN = "<title type=\"text\"><![CDATA[";
	private static final String TITLE_END = "]]></title>";
	private static final String SUBTITLE_BEGIN = "<subtitle type=\"text\"><![CDATA[";
	private static final String SUBTITLE_END = "]]></subtitle>";
	private static final String UPDATED_BEGIN = "<updated>";
	private static final String UPDATED_END = "</updated>";
	private static final String AUTHOR_BEGIN = "<author><name><![CDATA[";
	private static final String AUTHOR_END = "]]></name></author>";
	private static final String LINK_BEGIN = "<link href=\"";
	private static final String LINK_END = "\" rel=\"alternate\" type=\"text/html\" />";
	private static final String GENERATOR_BEGIN = "<generator><![CDATA[";
	private static final String GENERATOR_END = "]]></generator>";

	private String id;
	private String title;
	private String subtitle;
	private Date updated;
	private String author;
	private String link;
	private String generator;
	private List<Entry> entries = new ArrayList<Entry>();

	public static final String TIME_ZONE_ID = "Asia/Shanghai";

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

	/**
	 * Adds the specified entry.
	 * 
	 * @param entry
	 *            the specified entry
	 */
	public void addEntry(final Entry entry) {
		entries.add(entry);
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder(FEED_BEGIN);

		stringBuilder.append(ID_BEGIN).append(id).append(ID_END);

		stringBuilder.append(TITLE_BEGIN).append(Utils.cdataSpecialChars(title)).append(TITLE_END);

		stringBuilder.append(SUBTITLE_BEGIN).append(Utils.cdataSpecialChars(subtitle))
				.append(SUBTITLE_END);

		stringBuilder.append(UPDATED_BEGIN);
		stringBuilder.append(DateFormatUtils.format(
				// using ISO-8601 instead of RFC-3339
				updated, DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern(),
				TimeZone.getTimeZone(TIME_ZONE_ID)));
		stringBuilder.append(UPDATED_END);

		stringBuilder.append(AUTHOR_BEGIN).append(Utils.cdataSpecialChars(author))
				.append(AUTHOR_END);

		stringBuilder.append(LINK_BEGIN).append(link).append(LINK_END);

		stringBuilder.append(GENERATOR_BEGIN).append(Utils.cdataSpecialChars(generator))
				.append(GENERATOR_END);

		for (final Entry entry : entries) {
			stringBuilder.append(entry.toString());
		}

		stringBuilder.append(FEED_END);

		return stringBuilder.toString();
	}

	/**
	 * Gets the generator
	 * 
	 * @return generator
	 */
	public String getGenerator() {
		return generator;
	}

	/**
	 * Sets the generator
	 * 
	 * @param generator
	 *            the specified generator
	 */
	public void setGenerator(String generator) {
		this.generator = generator;
	}
}
