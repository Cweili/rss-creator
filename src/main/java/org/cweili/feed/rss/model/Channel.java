package org.cweili.feed.rss.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.cweili.feed.util.Utils;

/**
 * RSS 2.0 channel
 * 
 * <p>
 * See <a href="http://cyber.law.harvard.edu/rss/rss.html">RSS 2.0 at Harvard
 * Law</a> for more details.
 * </p>
 * 
 * @author Cweili
 * @version 2013-4-17 下午7:31:20
 * @see Item
 * @see Category
 */
public final class Channel {

	private static final String CHANNEL_BEGIN = "<?xml version='1.0' encoding='UTF-8'?><rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\"><channel>";
	private static final String CHANNEL_END = "</channel></rss>";
	private static final String TITLE_BEGIN = "<title><![CDATA[";
	private static final String TITLE_END = "]]></title>";
	private static final String LINK_BEGIN = "<link>";
	private static final String LINK_END = "</link>";
	private static final String ATOM_LINK_BEGIN = "<atom:link href=\"";
	private static final String ATOM_LINK_END = "\" rel=\"self\" type=\"application/rss+xml\" />";
	private static final String DESCRIPTION_BEGIN = "<description><![CDATA[";
	private static final String DESCRIPTION_END = "]]></description>";
	private static final String GENERATOR_BEGIN = "<generator><![CDATA[";
	private static final String GENERATOR_END = "]]></generator>";
	private static final String LANGUAGE_BEGIN = "<language>";
	private static final String LANGUAGE_END = "</language>";
	private static final String LAST_BUILD_DATE_BEGIN = "<lastBuildDate>";
	private static final String LAST_BUILD_DATE_END = "</lastBuildDate>";

	private String title;
	private String link;
	private String atomLink;
	private String description;
	private String generator;
	private Date lastBuildDate;
	private String language;
	private List<Item> items = new ArrayList<Item>();

	public static final String TIME_ZONE_ID = "Asia/Shanghai";

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
	 * Adds the specified item.
	 * 
	 * @param item
	 *            the specified item
	 */
	public void addItem(final Item item) {
		items.add(item);
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
		final StringBuilder stringBuilder = new StringBuilder(CHANNEL_BEGIN);

		stringBuilder.append(TITLE_BEGIN).append(Utils.escapeCdata(title)).append(TITLE_END);

		stringBuilder.append(LINK_BEGIN).append(link).append(LINK_END);

		stringBuilder.append(ATOM_LINK_BEGIN).append(atomLink).append(ATOM_LINK_END);

		stringBuilder.append(DESCRIPTION_BEGIN).append(Utils.escapeCdata(description))
				.append(DESCRIPTION_END);

		stringBuilder.append(GENERATOR_BEGIN).append(Utils.escapeCdata(generator))
				.append(GENERATOR_END);

		stringBuilder.append(LAST_BUILD_DATE_BEGIN);
		stringBuilder.append(DateFormatUtils.SMTP_DATETIME_FORMAT.format(lastBuildDate));
		stringBuilder.append(LAST_BUILD_DATE_END);

		stringBuilder.append(LANGUAGE_BEGIN).append(language).append(LANGUAGE_END);

		for (final Item item : items) {
			stringBuilder.append(item.toString());
		}

		stringBuilder.append(CHANNEL_END);

		return stringBuilder.toString();
	}
}
