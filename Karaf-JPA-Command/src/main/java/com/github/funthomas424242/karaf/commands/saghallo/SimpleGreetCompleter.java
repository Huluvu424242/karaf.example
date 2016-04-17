package com.github.funthomas424242.karaf.commands.saghallo;

import java.util.List;

import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.console.CommandLine;
import org.apache.karaf.shell.api.console.Completer;
import org.apache.karaf.shell.api.console.Session;
import org.apache.karaf.shell.support.completers.StringsCompleter;

@Service
public class SimpleGreetCompleter implements Completer {

	@Override
	public int complete(final Session session, final CommandLine commandLine, final List<String> candidates) {
		StringsCompleter delegate = new StringsCompleter();
		delegate.getStrings().add("Hallo");
		delegate.getStrings().add("Hello");
		return delegate.complete(session, commandLine, candidates);
	}

}