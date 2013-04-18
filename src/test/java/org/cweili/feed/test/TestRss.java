package org.cweili.feed.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cweili.feed.rss.RSS;

/**
 * Test RSS
 * 
 * @author Cweili
 * @version 2013-4-18 上午10:51:36
 * 
 */
public class TestRss {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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
		final RSS rss = new RSS("The title", "The link to your homepage", "The atom link",
				"The description", "The generator", new Date());

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
		rss.addItem("Item1 Title", "The link to your item", "Item GUID 1", "The author",
				"The description", new Date(), new String[] { "Category 1", "Category 2" });

		List<String> categories = new ArrayList<String>();
		categories.add("Category 3");
		categories.add("Category 4");
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
		rss.addItem("Item2 Title", "The link to your item", "The author", "The description",
				new Date(), categories);

		System.out.println(rss);
	}
}
