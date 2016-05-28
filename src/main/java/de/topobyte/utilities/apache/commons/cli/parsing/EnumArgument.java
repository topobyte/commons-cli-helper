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

package de.topobyte.utilities.apache.commons.cli.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnumArgument<K extends Enum<K>>
{

	private Class<K> clazz;

	private Map<String, K> argSwitch = new HashMap<>();

	public EnumArgument(Class<K> clazz)
	{
		this.clazz = clazz;

		K[] values = clazz.getEnumConstants();
		for (K value : values) {
			argSwitch.put(getName(value), value);
		}
	}

	private String getName(K value)
	{
		return value.name().toLowerCase().replaceAll("_", "-");
	}

	public K parse(String argument)
	{
		return argSwitch.get(argument);
	}

	public List<String> getPossibleNames(boolean sort)
	{
		List<String> names = new ArrayList<>();
		K[] values = clazz.getEnumConstants();
		for (K value : values) {
			names.add(getName(value));
		}
		if (sort) {
			Collections.sort(names);
		}
		return names;
	}

}
