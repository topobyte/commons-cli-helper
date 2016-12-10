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

import de.topobyte.utilities.apache.commons.cli.commands.args.ParsedArguments;
import de.topobyte.utilities.apache.commons.cli.commands.delegate.Delegate;

public class ExecutionData
{

	private String name;
	private ParsedArguments args;
	private Delegate delegate;

	public ExecutionData(String name, ParsedArguments args, Delegate delegate)
	{
		this.name = name;
		this.args = args;
		this.delegate = delegate;
	}

	public String getName()
	{
		return name;
	}

	public ParsedArguments getArgs()
	{
		return args;
	}

	public Delegate getDelegate()
	{
		return delegate;
	}

}
