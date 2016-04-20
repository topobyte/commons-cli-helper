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
import java.util.List;

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

}
