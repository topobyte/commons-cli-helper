package de.topobyte.utilities.apache.commons.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import de.topobyte.utilities.apache.commons.cli.parsing.ArgumentHelper;
import de.topobyte.utilities.apache.commons.cli.parsing.ArgumentParseException;
import de.topobyte.utilities.apache.commons.cli.parsing.BooleanOption;
import de.topobyte.utilities.apache.commons.cli.parsing.DoubleOption;
import de.topobyte.utilities.apache.commons.cli.parsing.IntegerOption;
import de.topobyte.utilities.apache.commons.cli.parsing.LongOption;
import de.topobyte.utilities.apache.commons.cli.parsing.StringOption;

public class TestMulti
{

	@Test
	public void testString() throws ParseException
	{
		Options options = new Options();
		OptionHelper.addS(options, "foo", true, true, "an option");
		OptionHelper.addS(options, "bar", true, true, "another option");

		String[] arguments = new String[] { "-foo", "asdf", "-bar", "test",
				"-bar", "more" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		StringOption foo = ArgumentHelper.getString(line, "foo");
		StringOption bar = ArgumentHelper.getString(line, "bar");

		assertTrue(foo.hasValue());
		assertTrue(bar.hasValue());
		assertEquals("asdf", foo.getValue());
		assertEquals("test", bar.getValue());

		List<StringOption> bars = ArgumentHelper.getStrings(line, "bar");
		assertEquals(2, bars.size());
		assertEquals("test", bars.get(0).getValue());
		assertEquals("more", bars.get(1).getValue());
	}

	@Test
	public void testBoolean() throws ParseException, ArgumentParseException
	{
		Options options = new Options();
		OptionHelper.addS(options, "foo", true, true, "an option");
		OptionHelper.addS(options, "bar", true, true, "another option");

		String[] arguments = new String[] { "-foo", "true", "-bar", "true",
				"-bar", "false" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		BooleanOption foo = ArgumentHelper.getBoolean(line, "foo");
		BooleanOption bar = ArgumentHelper.getBoolean(line, "bar");

		assertTrue(foo.hasValue());
		assertTrue(bar.hasValue());
		assertEquals(true, foo.getValue());
		assertEquals(true, bar.getValue());

		List<BooleanOption> bars = ArgumentHelper.getBooleans(line, "bar");
		assertEquals(2, bars.size());
		assertEquals(true, bars.get(0).getValue());
		assertEquals(false, bars.get(1).getValue());
	}

	@Test
	public void testInteger() throws ParseException, ArgumentParseException
	{
		Options options = new Options();
		OptionHelper.addS(options, "foo", true, true, "an option");
		OptionHelper.addS(options, "bar", true, true, "another option");

		String[] arguments = new String[] { "-foo", "10", "-bar", "20", "-bar",
				"30" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		IntegerOption foo = ArgumentHelper.getInteger(line, "foo");
		IntegerOption bar = ArgumentHelper.getInteger(line, "bar");

		assertTrue(foo.hasValue());
		assertTrue(bar.hasValue());
		assertEquals(10, foo.getValue());
		assertEquals(20, bar.getValue());

		List<IntegerOption> bars = ArgumentHelper.getIntegers(line, "bar");
		assertEquals(2, bars.size());
		assertEquals(20, bars.get(0).getValue());
		assertEquals(30, bars.get(1).getValue());
	}

	@Test
	public void testLong() throws ParseException, ArgumentParseException
	{
		Options options = new Options();
		OptionHelper.addS(options, "foo", true, true, "an option");
		OptionHelper.addS(options, "bar", true, true, "another option");

		String[] arguments = new String[] { "-foo", "10", "-bar", "20", "-bar",
				"30" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		LongOption foo = ArgumentHelper.getLong(line, "foo");
		LongOption bar = ArgumentHelper.getLong(line, "bar");

		assertTrue(foo.hasValue());
		assertTrue(bar.hasValue());
		assertEquals(10, foo.getValue());
		assertEquals(20, bar.getValue());

		List<LongOption> bars = ArgumentHelper.getLongs(line, "bar");
		assertEquals(2, bars.size());
		assertEquals(20, bars.get(0).getValue());
		assertEquals(30, bars.get(1).getValue());
	}

	@Test
	public void testDouble() throws ParseException, ArgumentParseException
	{
		Options options = new Options();
		OptionHelper.addS(options, "foo", true, true, "an option");
		OptionHelper.addS(options, "bar", true, true, "another option");

		String[] arguments = new String[] { "-foo", "10.1", "-bar", "20.2",
				"-bar", "30.303" };
		CommandLine line = new DefaultParser().parse(options, arguments);

		DoubleOption foo = ArgumentHelper.getDouble(line, "foo");
		DoubleOption bar = ArgumentHelper.getDouble(line, "bar");

		assertTrue(foo.hasValue());
		assertTrue(bar.hasValue());
		assertEquals(10.1, foo.getValue(), 0);
		assertEquals(20.2, bar.getValue(), 0);

		List<DoubleOption> bars = ArgumentHelper.getDoubles(line, "bar");
		assertEquals(2, bars.size());
		assertEquals(20.2, bars.get(0).getValue(), 0);
		assertEquals(30.303, bars.get(1).getValue(), 0);
	}

}
