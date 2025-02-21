// Copyright 2025 Sebastian Kuerten
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

public class TestQuotes
{

	@Test
	public void testSingleQuotesStart() throws ParseException
	{
		test("'some value");
	}

	@Test
	public void testSingleQuotesEnd() throws ParseException
	{
		test("some value'");
	}

	@Test
	public void testSingleQuotes() throws ParseException
	{
		test("'some value'");
	}

	@Test
	public void testSingleQuotesWithin() throws ParseException
	{
		test("some val'ue");
	}

	@Test
	public void testDoubleQuotesStart() throws ParseException
	{
		test("\"some value");
	}

	@Test
	public void testDoubleQuotesEnd() throws ParseException
	{
		test("some value\"");
	}

	@Test
	public void testDoubleQuotes() throws ParseException
	{
		test("\"some value\"");
	}

	@Test
	public void testDoubleQuotesWithin() throws ParseException
	{
		test("some val\"ue");
	}

	private void test(String value) throws ParseException
	{
		Options options = new Options();
		OptionHelper.addL(options, "foo", true, true, "an option");

		String[] arguments = new String[] { "-foo", value };
		CommandLine line = new DefaultParser().parse(options, arguments);

		StringOption foo = ArgumentHelper.getString(line, "foo");

		assertTrue(foo.hasValue());
		assertEquals(value, foo.getValue());
	}

}
