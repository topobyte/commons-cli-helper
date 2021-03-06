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

import java.util.Comparator;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;

/**
 * An {@link Option} comparator that mimics the behavior of the default
 * comparator used by the {@link HelpFormatter}.
 */
public class DefaultOptionComparator implements Comparator<Option>
{

	@Override
	public int compare(Option opt1, Option opt2)
	{
		String o1 = OptionUtil.getKey(opt1);
		String o2 = OptionUtil.getKey(opt2);
		return o1.compareTo(o2);
	}

}
