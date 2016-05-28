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

package de.topobyte.utilities.apache.commons.cli.parsing;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;

public class ArgumentHelper
{

	public static boolean parseBooleanWithDefaultValue(String value,
			boolean defaultValue)
	{
		try {
			return parseBoolean(value);
		} catch (ArgumentParseException e) {
			return defaultValue;
		}
	}

	public static boolean parseBoolean(String value)
			throws ArgumentParseException
	{
		String lower = value.toLowerCase();
		if (lower.equals("yes")) {
			return true;
		} else if (lower.equals("true")) {
			return true;
		} else if (lower.equals("no")) {
			return false;
		} else if (lower.equals("false")) {
			return false;
		} else {
			throw new ArgumentParseException("unable to parse boolean: '"
					+ value + "'");
		}
	}

	public static int parseInteger(String value) throws ArgumentParseException
	{
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new ArgumentParseException("unable to parse integer: '"
					+ value + "'");
		}
	}

	public static BooleanOption getBoolean(CommandLine line, String option)
			throws ArgumentParseException
	{
		String value = line.getOptionValue(option);
		if (value == null) {
			return new BooleanOption(false);
		}
		boolean bool = parseBoolean(value);
		return new BooleanOption(true, bool);
	}

	public static List<BooleanOption> getBooleans(CommandLine line,
			String option) throws ArgumentParseException
	{
		String[] values = line.getOptionValues(option);
		if (values == null) {
			return new ArrayList<>();
		}
		List<BooleanOption> options = new ArrayList<>();
		for (String value : values) {
			boolean bool = parseBoolean(value);
			options.add(new BooleanOption(true, bool));
		}
		return options;
	}

	public static IntegerOption getInteger(CommandLine line, String option)
			throws ArgumentParseException
	{
		String value = line.getOptionValue(option);
		if (value == null) {
			return new IntegerOption(false);
		}
		int num = parseInteger(value);
		return new IntegerOption(true, num);
	}

	public static List<IntegerOption> getIntegers(CommandLine line,
			String option) throws ArgumentParseException
	{
		String[] values = line.getOptionValues(option);
		if (values == null) {
			return new ArrayList<>();
		}
		List<IntegerOption> options = new ArrayList<>();
		for (String value : values) {
			int num = parseInteger(value);
			options.add(new IntegerOption(true, num));
		}
		return options;
	}

	public static StringOption getString(CommandLine line, String option)
	{
		String value = line.getOptionValue(option);
		if (value == null) {
			return new StringOption(false);
		}
		return new StringOption(true, value);
	}

	public static List<StringOption> getStrings(CommandLine line, String option)
	{
		String[] values = line.getOptionValues(option);
		if (values == null) {
			return new ArrayList<>();
		}
		List<StringOption> options = new ArrayList<>();
		for (String value : values) {
			options.add(new StringOption(true, value));
		}
		return options;
	}

}
