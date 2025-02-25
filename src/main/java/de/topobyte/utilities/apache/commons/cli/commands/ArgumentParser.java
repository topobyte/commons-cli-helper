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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import de.topobyte.utilities.apache.commons.cli.commands.args.BasicArguments;
import de.topobyte.utilities.apache.commons.cli.commands.args.CommonsCliArguments;
import de.topobyte.utilities.apache.commons.cli.commands.delegate.Delegate;
import de.topobyte.utilities.apache.commons.cli.commands.options.BasicExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.CommonsCliExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.DelegateExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptionsFactory;
import de.topobyte.utilities.apache.commons.cli.parsing.ArgumentParseException;

public class ArgumentParser
{

	private String name;
	private ExeOptions options;

	private ErrorHandlingStrategy errorHandlingStrategy = ErrorHandlingStrategy.EXIT;

	public ArgumentParser(String name, ExeOptions options)
	{
		this.name = name;
		this.options = options;
	}

	public void setErrorHandlingStrategy(
			ErrorHandlingStrategy errorHandlingStrategy)
	{
		this.errorHandlingStrategy = errorHandlingStrategy;
	}

	public ExecutionData parse(String[] args)
	{
		try {
			return parse(name, args, null);
		} catch (ArgumentParseException e) {
			error(e, options, name);
			return null;
		}
	}

	public ExecutionData parse(String name, String[] args, Delegate delegate)
			throws ArgumentParseException
	{
		if (options instanceof DelegateExeOptions) {
			DelegateExeOptions delegateOptions = (DelegateExeOptions) options;
			return parse(name, delegateOptions, args, delegate);
		} else if (options instanceof CommonsCliExeOptions) {
			CommonsCliExeOptions commonsOptions = (CommonsCliExeOptions) options;
			return parse(name, commonsOptions, args, delegate);
		} else if (options instanceof BasicExeOptions) {
			BasicExeOptions basicOptions = (BasicExeOptions) options;
			return parse(name, basicOptions, args, delegate);
		}
		return null;
	}

	private ExecutionData parse(String name, BasicExeOptions basicOptions,
			String[] args, Delegate delegate)
	{
		BasicArguments arguments = new BasicArguments(args);
		return new ExecutionData(name, arguments, delegate);
	}

	private ExecutionData parse(String name,
			CommonsCliExeOptions commonsOptions, String[] args,
			Delegate delegate)
	{
		Options options = commonsOptions.getOptions();
		try {
			DefaultParser parser = DefaultParser.builder()
					.setStripLeadingAndTrailingQuotes(false).build();
			CommandLine line = parser.parse(options, args);
			CommonsCliArguments arguments = new CommonsCliArguments(
					commonsOptions, line);
			return new ExecutionData(name, arguments, delegate);
		} catch (ParseException e) {
			error(e, commonsOptions, name);
			return null;
		}
	}

	private ExecutionData parse(String name, DelegateExeOptions delegateOptions,
			String[] args, Delegate delegate) throws ArgumentParseException
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

		ExeOptionsFactory subOptionsFactory = delegateOptions
				.getSubOptions(task);
		ExeOptions subOptions = subOptionsFactory.createOptions();
		Delegate nextDelegate = delegateOptions.getDelegate(task);
		String subName = name + " " + task;
		ArgumentParser subParser = new ArgumentParser(subName, subOptions);
		subParser.setErrorHandlingStrategy(errorHandlingStrategy);
		try {
			return subParser.parse(subName, taskArgs, nextDelegate);
		} catch (ArgumentParseException e) {
			error(e, subOptions, subName);
			return null;
		}
	}

	private void error(Exception e, ExeOptions exeOptions, String name)
	{
		System.out.println(e.getMessage());
		exeOptions.usage(name);
		if (errorHandlingStrategy == ErrorHandlingStrategy.EXIT) {
			System.exit(1);
		}
	}

}
