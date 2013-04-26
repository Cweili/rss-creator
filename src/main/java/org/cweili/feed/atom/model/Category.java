package org.cweili.feed.atom.model;

import java.io.Serializable;

import org.cweili.feed.util.Utils;

/**
 * Category
 * 
 * @author Cweili
 * @version 2013-4-17 下午7:00:01
 * 
 */
public final class Category implements Serializable, Cloneable {

	private static final long serialVersionUID = -6989957345514230969L;
	private static final String CATEGORY_BEGIN = "<category term=\"";
	private static final String CATEGORY_END = "\" />";

	private String term;

	/**
	 * Gets the term.
	 * 
	 * @return term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * Sets the term with the specified term.
	 * 
	 * @param term
	 *            the specified term
	 */
	public void setTerm(final String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return CATEGORY_BEGIN + Utils.escapeXml(term) + CATEGORY_END;
	}
}
