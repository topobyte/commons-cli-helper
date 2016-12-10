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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.topobyte.utilities.apache.commons.cli.commands.delegate.Delegate;
import de.topobyte.utilities.apache.commons.cli.commands.delegate.DelegateClass;

public class DelegateExeOptions implements ExeOptions
{

	@Override
	public void usage(String name)
	{
		System.out.println("usage: " + name + " <command>");
		System.out.println("where <command> may be one of the following:");
		for (String command : commands) {
			System.out.println("   " + command);
		}
	}

	private Set<String> commandNames = new HashSet<>();
	private List<String> commands = new ArrayList<>();
	private Map<String, ExeOptionsFactory> optionFactories = new HashMap<>();
	private Map<String, Delegate> delegates = new HashMap<>();

	public void addCommand(String command, ExeOptionsFactory delegateOptions)
	{
		commandNames.add(command);
		commands.add(command);
		optionFactories.put(command, delegateOptions);
	}

	public void addCommand(String command, ExeOptionsFactory delegateOptions,
			Class<?> clazz)
	{
		commandNames.add(command);
		commands.add(command);
		optionFactories.put(command, delegateOptions);
		delegates.put(command, new DelegateClass(clazz, true));
	}

	public boolean hasSubCommand(String command)
	{
		return commandNames.contains(command);
	}

	public ExeOptionsFactory getSubOptions(String task)
	{
		return optionFactories.get(task);
	}

	public Delegate getDelegate(String task)
	{
		return delegates.get(task);
	}

}
