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

package de.topobyte.utilities.apache.commons.cli.commands.options;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class CommonsCliExeOptions implements ExeOptions
{

	private Options options;
	private String usageSuffix;

	public CommonsCliExeOptions(Options options, String usageSuffix)
	{
		this.options = options;
		this.usageSuffix = usageSuffix;
	}

	public Options getOptions()
	{
		return options;
	}

	@Override
	public void usage(String name)
	{
		String syntax;
		if (usageSuffix == null) {
			syntax = name;
		} else {
			syntax = name + " " + usageSuffix;
		}
		new HelpFormatter().printHelp(syntax, options);
	}

}
