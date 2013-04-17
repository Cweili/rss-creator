package org.cweili.feed.atom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cweili.feed.atom.model.Entry;

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

	private String id;
	private String title;
	private String subtitle;
	private Date updated;
	private String author;
	private String link;
	private List<Entry> entries = new ArrayList<Entry>();
}
