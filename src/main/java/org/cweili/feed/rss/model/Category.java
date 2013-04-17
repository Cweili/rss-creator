package org.cweili.feed.rss.model;

import java.io.Serializable;

/**
 * Category
 * 
 * @author Cweili
 * @version 2013-4-17 下午7:23:01
 * 
 */
public final class Category implements Serializable, Cloneable {

	private static final long serialVersionUID = -8513042087874911791L;
	private static final String CATEGORY_BEGIN = "<category>";
	private static final String CATEGORY_END = "</category>";

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
		return CATEGORY_BEGIN + term + CATEGORY_END;
	}
}
