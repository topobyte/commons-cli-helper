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
		OptionHelper.add(options, null, "foo-boo", true, true, "an option");
		OptionHelper.add(options, null, "bar-bar", true, true, "option 2");

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
