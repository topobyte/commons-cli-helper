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

import de.topobyte.utilities.apache.commons.cli.parsing.ArgumentParseException;

public class TestDelegateValidArg
{

	public static void main(String[] args)
	{
		ExeOptions options = Git.OPTIONS_FACTORY.createOptions();
		Parser parser = new Parser("git", options);
		args = new String[] { "remote" };
		try {
			parser.parse(args);
		} catch (ArgumentParseException e) {
			System.out.println(e.getMessage());
		}
	}

}
