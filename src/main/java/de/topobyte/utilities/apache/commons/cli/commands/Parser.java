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

package de.topobyte.utilities.apache.commons.cli.commands;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import de.topobyte.utilities.apache.commons.cli.parsing.ArgumentParseException;

public class Parser
{

	private String name;
	private ExeOptions options;

	public Parser(String name, ExeOptions options)
	{
		this.name = name;
		this.options = options;
	}

	public void parse(String[] args) throws ArgumentParseException
	{
		if (options instanceof DelegateExeOptions) {
			DelegateExeOptions delegateOptions = (DelegateExeOptions) options;
			parse(delegateOptions, args);
		} else if (options instanceof CommonsCliExeOptions) {
			CommonsCliExeOptions commonsOptions = (CommonsCliExeOptions) options;
			parse(commonsOptions, args);
		}
	}

	private void parse(CommonsCliExeOptions commonsOptions, String[] args)
	{
		Options options = commonsOptions.getOptions();
		try {
			new DefaultParser().parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			commonsOptions.usage(name);
		}
	}

	private void parse(DelegateExeOptions delegateOptions, String[] args)
			throws ArgumentParseException
	{
		if (args.length == 0) {
			throw new ArgumentParseException("Missing command name");
		}
		String task = args[0];
		if (!delegateOptions.hasSubCommand(task)) {
			throw new ArgumentParseException(
					String.format("Invalid command '%s'", task));
		}
		String[] taskArgs = new String[args.length - 1];
		for (int i = 0; i < taskArgs.length; i++) {
			taskArgs[i] = args[i + 1];
		}

		ExeOptionsFactory subOptions = delegateOptions.getSubOptions(task);
		Parser subParser = new Parser(name + " " + task,
				subOptions.createOptions());
		try {
			subParser.parse(taskArgs);
		} catch (ArgumentParseException e) {
			subOptions.createOptions().usage(name + " " + task);
		}
	}

}
