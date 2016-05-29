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

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 * 
 *         Utility methods for commons CLI.
 */
public class OptionHelper
{

	/**
	 * Add a short option to the options specified by parameters
	 * 
	 * @param options
	 *            the options to add to.
	 * @param opt
	 *            the short option name.
	 * @param hasArg
	 *            whether it expects an argument
	 * @param required
	 *            whether this is a required option.
	 * @param description
	 *            the option description
	 * @return the Option object created.
	 */
	public static Option addS(Options options, String opt, boolean hasArg,
			boolean required, String description)
	{
		Option option = new Option(opt, hasArg, description);
		option.setRequired(required);
		options.addOption(option);
		return option;
	}

	/**
	 * Add a short option to the options specified by parameters
	 * 
	 * @param options
	 *            the options to add to.
	 * @param opt
	 *            the short option name.
	 * @param hasArg
	 *            whether it expects an argument
	 * @param required
	 *            whether this is a required option.
	 * @param argName
	 *            the name of the argument.
	 * @param description
	 *            the option description
	 * @return the Option object created.
	 */
	public static Option addS(Options options, String opt, boolean hasArg,
			boolean required, String argName, String description)
	{
		Option option = new Option(opt, hasArg, description);
		option.setRequired(required);
		option.setArgName(argName);
		options.addOption(option);
		return option;
	}

	/**
	 * Add a long option to the options specified by parameters
	 * 
	 * @param options
	 *            the options to add to.
	 * @param longName
	 *            the long option name.
	 * @param hasArg
	 *            whether it expects an argument
	 * @param required
	 *            whether this is a required option.
	 * @param description
	 *            the option description
	 * @return the Option object created.
	 */
	public static Option addL(Options options, String longName, boolean hasArg,
			boolean required, String description)
	{
		Option option = new Option(null, longName, hasArg, description);
		option.setRequired(required);
		options.addOption(option);
		return option;
	}

	/**
	 * Add a long option to the options specified by parameters
	 * 
	 * @param options
	 *            the options to add to.
	 * @param longName
	 *            the long option name.
	 * @param hasArg
	 *            whether it expects an argument
	 * @param required
	 *            whether this is a required option.
	 * @param argName
	 *            the name of the argument.
	 * @param description
	 *            the option description
	 * @return the Option object created.
	 */
	public static Option addL(Options options, String longName, boolean hasArg,
			boolean required, String argName, String description)
	{
		Option option = new Option(null, longName, hasArg, description);
		option.setRequired(required);
		option.setArgName(argName);
		options.addOption(option);
		return option;
	}

	/**
	 * Add an option to the options specified by parameters
	 * 
	 * @param options
	 *            the options to add to.
	 * @param opt
	 *            the short option name.
	 * @param longName
	 *            the long option name.
	 * @param hasArg
	 *            whether it expects an argument
	 * @param required
	 *            whether this is a required option.
	 * @param description
	 *            the option description
	 * @return the Option object created.
	 */
	public static Option add(Options options, String opt, String longName,
			boolean hasArg, boolean required, String description)
	{
		Option option = new Option(opt, longName, hasArg, description);
		option.setRequired(required);
		options.addOption(option);
		return option;
	}

	/**
	 * Add an option to the options specified by parameters
	 * 
	 * @param options
	 *            the options to add to.
	 * @param opt
	 *            the short option name.
	 * @param longName
	 *            the long option name.
	 * @param hasArg
	 *            whether it expects an argument
	 * @param required
	 *            whether this is a required option.
	 * @param argName
	 *            the name of the argument.
	 * @param description
	 *            the option description
	 * @return the Option object created.
	 */
	public static Option add(Options options, String opt, String longName,
			boolean hasArg, boolean required, String argName, String description)
	{
		Option option = new Option(opt, longName, hasArg, description);
		option.setRequired(required);
		option.setArgName(argName);
		options.addOption(option);
		return option;
	}

}
