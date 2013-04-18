/**
 * 
 */
package org.cweili.feed.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cweili.feed.atom.Atom;

/**
 * Test Atom
 * 
 * @author Cweili
 * @version 2013-4-18 上午10:51:29
 * 
 */
public class TestAtom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		 * @param generator
		 *            the generator
		 * @param updated
		 *            the specified updated time
		 */
		final Atom atom = new Atom("The title", "The subtitle", "The link to your homepage",
				"The author", "The atom link", "The generator", new Date());

		/**
		 * Adds the specified entry.
		 * 
		 * @param title
		 *            the title
		 * @param link
		 *            the link
		 * @param id
		 *            the specified id
		 * @param author
		 *            the author
		 * @param uri
		 *            the author uri
		 * @param summary
		 *            the summary
		 * @param updated
		 *            the specified updated time
		 * @param categories
		 *            the categories
		 */
		atom.addEntry("Entry1 title", "The link to your entry", "The entry id", "The author",
				"The link to author", "The summary", new Date(), new String[] { "Category 1",
						"Category 2" });

		List<String> categories = new ArrayList<String>();
		categories.add("Category 3");
		categories.add("Category 4");
		/**
		 * Adds the specified entry.
		 * 
		 * @param title
		 *            the title
		 * @param link
		 *            the link
		 * @param author
		 *            the author
		 * @param summary
		 *            the summary
		 * @param updated
		 *            the specified updated time
		 * @param categories
		 *            the categories
		 */
		atom.addEntry("Entry1 title", "The link to your entry", "The author", "The summary",
				new Date(), categories);

		System.out.println(atom);
	}
}
