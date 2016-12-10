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
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import de.topobyte.utilities.apache.commons.cli.commands.options.CommonsCliExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptionsFactory;

public class GitRemoteAdd
{

	public static ExeOptionsFactory OPTIONS_FACTORY = new ExeOptionsFactory() {

		@Override
		public ExeOptions createOptions()
		{
			Options options = new Options();
			options.addOption(Option.builder("t").hasArg().argName("branch")
					.desc("branch to track").build());
			options.addOption(Option.builder("m").hasArg().argName("master")
					.desc("remote master branch").build());
			return new CommonsCliExeOptions(options);
		}

	};

	public static void main(String name, CommandLine line)
	{
		System.out.println(String.format("This is '%s'", name));
		String branch = line.getOptionValue("t");
		System.out.println("branch: " + branch);
	}

}
