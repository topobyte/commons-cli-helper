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

import java.util.Arrays;

import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptions;

public class TestMultiple
{

	public static void main(String[] args) throws RunnerException
	{
		test(new String[] {});
		test(new String[] { "remote" });
		test(new String[] { "remote", "add" });
		test(new String[] { "remote", "rename" });
		test(new String[] { "remote", "remove" });
		test(new String[] { "foo" });
		test(new String[] { "remote", "foo" });
		test(new String[] { "remote", "add", "-t", "master" });
		test(new String[] { "remote", "add", "-y" });
		test(new String[] { "remote", "rename" });
		test(new String[] { "remote", "rename", "-y" });
		test(new String[] { "stash", "show" });
		test(new String[] { "stash", "show", "test" });
	}

	public static void test(String[] args) throws RunnerException
	{
		ExeOptions options = Git.OPTIONS_FACTORY.createOptions();
		ArgumentParser parser = new ArgumentParser("git", options);
		System.out.println(
				String.format("*** Testing with %s", Arrays.asList(args)));

		ExecutionData data = parser.parse(args);
		if (data != null) {
			ExeRunner.run(data);
		}
	}

}
