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

public class TestBasic
{

	@Test
	public void test() throws ParseException
	{
		Options options = new Options();
		OptionHelper.add(options, "foo", true, true, "an option");
		OptionHelper.add(options, "bar", true, true, "another option");

		String[] arguments = new String[] { "-foo", "asdf", "-bar", "test" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		StringOption foo = ArgumentHelper.getString(line, "foo");
		StringOption bar = ArgumentHelper.getString(line, "bar");

		assertTrue(foo.hasValue());
		assertTrue(bar.hasValue());
		assertEquals("asdf", foo.getValue());
		assertEquals("test", bar.getValue());
	}

}
