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

import de.topobyte.utilities.apache.commons.cli.CliTool;

public class BasicExeOptions implements ExeOptions
{

	private String usage;

	public BasicExeOptions()
	{
		this(null);
	}

	public BasicExeOptions(String usage)
	{
		this.usage = usage;
	}

	public String getUsage()
	{
		return usage;
	}

	@Override
	public void usage(String name)
	{
		String syntax;
		if (usage == null) {
			syntax = name;
		} else {
			syntax = name + " " + usage;
		}
		System.out.println(syntax);
	}

	@Override
	public CliTool tool(String name)
	{
		return new CliTool(name, this);
	}

}
