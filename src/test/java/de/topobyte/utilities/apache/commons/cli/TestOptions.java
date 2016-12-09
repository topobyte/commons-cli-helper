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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import de.topobyte.utilities.apache.commons.cli.parsing.ArgumentHelper;
import de.topobyte.utilities.apache.commons.cli.parsing.StringOption;

public class TestOptions
{

	@Test
	public void testShortAndLong() throws ParseException
	{
		Options options = new Options();
		OptionHelper.add(options, "f", "foo-boo", true, true, "an option");
		OptionHelper.add(options, "b", "bar-bar", true, true, "another option");

		String[] arguments = new String[] { "-f", "asdf", "--bar-bar", "test" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		StringOption f = ArgumentHelper.getString(line, "f");
		StringOption fooboo = ArgumentHelper.getString(line, "foo-boo");
		StringOption b = ArgumentHelper.getString(line, "b");
		StringOption barbar = ArgumentHelper.getString(line, "bar-bar");

		assertTrue(f.hasValue());
		assertTrue(fooboo.hasValue());
		assertTrue(b.hasValue());
		assertTrue(barbar.hasValue());
		assertEquals("asdf", f.getValue());
		assertEquals("asdf", fooboo.getValue());
		assertEquals("test", b.getValue());
		assertEquals("test", barbar.getValue());
	}

	@Test
	public void testLongOnly() throws ParseException
	{
		Options options = new Options();
		OptionHelper.addL(options, "foo-boo", true, true, "an option");
		OptionHelper.addL(options, "bar-bar", true, true, "option 2");

		String[] arguments = new String[] { "-foo-boo", "asdf", "--bar-bar",
				"test" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		StringOption fooboo = ArgumentHelper.getString(line, "foo-boo");
		StringOption barbar = ArgumentHelper.getString(line, "bar-bar");

		assertTrue(fooboo.hasValue());
		assertTrue(barbar.hasValue());
		assertEquals("asdf", fooboo.getValue());
		assertEquals("test", barbar.getValue());
	}

}
