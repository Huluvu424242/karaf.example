package com.github.funthomas424242.karaf.commands.saghallo;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "funthomas", name = "sagHallo", description = "Sagt Hallo")
@Service
public class SagHallo implements Action {

	@Argument(index = 0, name = "name", description = "Der zu grüßende Name", required = true, multiValued = false)
	@Completion(SimpleNameCompleter.class)
	String name = null;

	@Option(name = "-g", aliases = "--greet", description = "Die Grußformel", required = false, multiValued = false)
	@Completion(SimpleGreetCompleter.class)
	String gruss = "Hallo";

	@Override
	public Object execute() throws Exception {
		System.out.println(gruss + " " + name + "!");
		return null;
	}
}