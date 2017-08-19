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

	/**
	 * Prints the help message and terminates the JVM with the specified exit
	 * code.
	 * 
	 * Same as calling {@link #printHelpAndExit(int)} with an exit code of 1.
	 */
	public void printHelpAndExit()
	{
		printHelpAndExit(1);
	}

	/**
	 * Prints the help message and terminates the JVM with the specified exit
	 * code.
	 * 
	 * @param exitCode
	 *            the exit code to use for {@link System#exit(int)}
	 */
	public void printHelpAndExit(int exitCode)
	{
		new HelpFormatter().printHelp(helpMessage, options);
		System.exit(exitCode);
	}

	/**
	 * Prints the specified message, followed by the help message and terminates
	 * the JVM with an exit code of 1.
	 * 
	 * Same as calling {@link #printMessageAndHelpAndExit(int, String)} with an
	 * exit code of 1.
	 * 
	 * @param message
	 *            the line to print in front of the help message
	 */
	public void printMessageAndHelpAndExit(String message)
	{
		printMessageAndHelpAndExit(1, message);
	}

	/**
	 * Prints the specified message, followed by the help message and terminates
	 * the JVM with the specified exit code.
	 * 
	 * @param exitCode
	 *            the exit code to use for {@link System#exit(int)}
	 * @param message
	 *            the line to print in front of the help message
	 */
	public void printMessageAndHelpAndExit(int exitCode, String message)
	{
		System.out.println(message);
		printHelpAndExit(exitCode);
	}

	/**
	 * Prints the specified messages, followed by the help message and
	 * terminates the JVM with an exit code of 1.
	 * 
	 * Same as calling {@link #printMessagesAndHelpAndExit(int, String...)} with
	 * an exit code of 1.
	 * 
	 * @param messages
	 *            the lines to print in front of the help message
	 */
	public void printMessagesAndHelpAndExit(String... messages)
	{
		printMessagesAndHelpAndExit(1, messages);
	}

	/**
	 * Prints the specified messages, followed by the help message and
	 * terminates the JVM with the specified exit code.
	 * 
	 * @param exitCode
	 *            the exit code to use for {@link System#exit(int)}
	 * @param messages
	 *            the lines to print in front of the help message
	 */
	public void printMessagesAndHelpAndExit(int exitCode, String... messages)
	{
		for (String message : messages) {
			System.out.println(message);
		}
		printHelpAndExit(exitCode);
	}

}
