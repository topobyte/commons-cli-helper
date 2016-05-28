// Copyright 2016 Sebastian Kuerten
//
// This file is part of commons-cli-helper.
//
// commons-cli-helper is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// commons-cli-helper is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with commons-cli-helper. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.utilities.apache.commons.cli;

import org.apache.commons.cli.Option;

public class OptionUtil
{

	/**
	 * This method provides the same functionality as the {@link Option}'s
	 * {@code getKey()} method, which has package private visibility however. It
	 * returns {@link Option#getOpt()} if the return value of that method is
	 * non-null and {@link Option#getLongOpt()} otherwise.
	 * 
	 * @param option
	 *            the option to get the key for.
	 */
	public static String getKey(Option option)
	{
		String opt = option.getOpt();
		return opt != null ? opt : option.getLongOpt();
	}

}
