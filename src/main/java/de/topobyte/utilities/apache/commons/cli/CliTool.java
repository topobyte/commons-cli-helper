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

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class CliTool
{

	private String helpMessage;
	private Options options;

	public CliTool(String helpMessage, Options options)
	{
		this.helpMessage = helpMessage;
		this.options = options;
	}

	public void printHelpAndExit()
	{
		printHelpAndExit(1);
	}

	public void printHelpAndExit(int exitCode)
	{
		new HelpFormatter().printHelp(helpMessage, options);
		System.exit(exitCode);
	}

	public void printMessageAndHelpAndExit(String message)
	{
		printMessageAndHelpAndExit(1, message);
	}

	public void printMessageAndHelpAndExit(int exitCode, String message)
	{
		System.out.println(message);
		printHelpAndExit(exitCode);
	}

	public void printMessagesAndHelpAndExit(String... messages)
	{
		printMessagesAndHelpAndExit(1, messages);
	}

	public void printMessagesAndHelpAndExit(int exitCode, String... messages)
	{
		for (String message : messages) {
			System.out.println(message);
		}
		printHelpAndExit(exitCode);
	}

}
