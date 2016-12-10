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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.cli.CommandLine;

import de.topobyte.utilities.apache.commons.cli.commands.args.BasicArguments;
import de.topobyte.utilities.apache.commons.cli.commands.args.CommonsCliArguments;
import de.topobyte.utilities.apache.commons.cli.commands.args.ParsedArguments;
import de.topobyte.utilities.apache.commons.cli.commands.delegate.Delegate;
import de.topobyte.utilities.apache.commons.cli.commands.delegate.DelegateClass;

public class ExeRunner
{

	public static void run(ExecutionData data) throws RunnerException
	{
		Delegate delegate = data.getDelegate();
		ParsedArguments arguments = data.getArgs();

		if (delegate instanceof DelegateClass) {
			DelegateClass delegateClass = (DelegateClass) delegate;
			if (arguments instanceof BasicArguments) {
				BasicArguments basicArgs = (BasicArguments) arguments;
				run(data.getName(), delegateClass, basicArgs);
			} else if (arguments instanceof CommonsCliArguments) {
				CommonsCliArguments commonsArgs = (CommonsCliArguments) arguments;
				run(data.getName(), delegateClass, commonsArgs);
			}
		}
	}

	private static void run(String name, DelegateClass c,
			BasicArguments arguments) throws RunnerException
	{
		String[] args = arguments.getArgs();
		try {
			Class<?> clazz = c.getClazz();
			if (!c.isPassName()) {
				Method method = clazz.getMethod("main", String[].class);
				method.invoke(null, (Object) args);
			} else {
				Method method = clazz.getMethod("main", String.class,
						String[].class);
				method.invoke(null, name, args);
			}
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			throw new RunnerException(
					"Error while starting main method for task", e);
		} catch (InvocationTargetException e) {
			throw new RunnerException(e.getCause());
		}
	}

	private static void run(String name, DelegateClass c,
			CommonsCliArguments arguments) throws RunnerException
	{
		CommandLine line = arguments.getLine();
		try {
			Class<?> clazz = c.getClazz();
			if (!c.isPassName()) {
				Method method = clazz.getMethod("main", CommandLine.class);
				method.invoke(null, line);
			} else {
				Method method = clazz.getMethod("main", String.class,
						CommandLine.class);
				method.invoke(null, name, line);
			}
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			throw new RunnerException(
					"Error while starting main method for task", e);
		} catch (InvocationTargetException e) {
			throw new RunnerException(e.getCause());
		}
	}

}
