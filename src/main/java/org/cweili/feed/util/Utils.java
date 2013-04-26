/**
 * 
 */
package org.cweili.feed.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Cweili
 * @version 2013-4-18 上午9:28:32
 * 
 */
public class Utils {

	/**
	 * escapeCdata
	 * 
	 * @param input
	 *            input string
	 * @return the string after escape CDATA
	 */
	public static String escapeCdata(String input) {
		return StringUtils.replace(input, "]]>", "]]&gt;");
	}

	/**
	 * escapeXml
	 * 
	 * @param input
	 *            input string
	 * @return the string after escape XML
	 */
	public static String escapeXml(String input) {

		// input = StringUtils.replace(input, "&amp;", "&");
		// input = StringUtils.replace(input, "&", "&amp;");
		// input = StringUtils.replace(input, "\'", "&apos;");
		// input = StringUtils.replace(input, "\"", "&quot;");
		// input = StringUtils.replace(input, "<", "&lt;");
		// input = StringUtils.replace(input, ">", "&gt;");
		// input = StringUtils.replace(input, "«", "&laquo;");
		// input = StringUtils.replace(input, "»", "&raquo;");
		input = StringEscapeUtils.escapeXml(input);
		input = StringUtils.stripToEmpty(input);

		return input;
	}
}
