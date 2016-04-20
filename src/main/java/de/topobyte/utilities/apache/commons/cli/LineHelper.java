// Copyright 2015 Sebastian Kuerten
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;

public class LineHelper
{

	public static boolean getValue(CommandLine line, String optionName,
			boolean defaultValue, boolean trueIfPresent)
	{
		if (!line.hasOption(optionName)) {
			return defaultValue;
		}
		return trueIfPresent;
	}

	public static List<String> getRemainingArguments(CommandLine line)
	{
		String[] arguments = line.getArgs();
		List<String> args = new ArrayList<>();
		for (String argument : arguments) {
			args.add(argument);
		}
		return args;
	}

	/**
	 * Of a collection of specified option names, find those options that are
	 * present in the {@link CommandLine} argument.
	 * 
	 * @param line
	 *            the command line to inspect.
	 * @param options
	 *            the option names to look for.
	 * @return the {@link Set} of option names present in the command line
	 *         parameter, a subset of the <code>options</code> supplied.
	 */
	public static Set<String> findOptions(CommandLine line,
			Collection<String> options)
	{
		Set<String> results = new HashSet<>();
		for (String option : options) {
			if (line.hasOption(option)) {
				results.add(option);
			}
		}
		return results;
	}

}
