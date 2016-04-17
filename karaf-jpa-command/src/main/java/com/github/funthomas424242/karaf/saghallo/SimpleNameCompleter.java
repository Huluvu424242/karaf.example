package com.github.funthomas424242.karaf.saghallo;

import java.util.List;

import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.api.console.CommandLine;
import org.apache.karaf.shell.api.console.Completer;
import org.apache.karaf.shell.api.console.Session;
import org.apache.karaf.shell.support.completers.StringsCompleter;

@Service
public class SimpleNameCompleter implements Completer {

	@Override
	public int complete(final Session session, final CommandLine commandLine, final List<String> candidates) {
		StringsCompleter delegate = new StringsCompleter();
		delegate.getStrings().add("FunThomas424242");
		delegate.getStrings().add("Du");
		delegate.getStrings().add("Michael");
		delegate.getStrings().add("Mascha");
		return delegate.complete(session, commandLine, candidates);
	}

}