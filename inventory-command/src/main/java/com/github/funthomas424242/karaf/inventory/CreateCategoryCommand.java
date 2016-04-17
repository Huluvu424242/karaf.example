package com.github.funthomas424242.karaf.inventory;

import javax.inject.Inject;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "funthomas", name = "createCategory", description = "Erstellt eine Kategorie")
@Service
public class CreateCategoryCommand implements Action {

	@Option(name = "-d", aliases = {
			"--description" }, description = "A description to the category", required = false, multiValued = false)
	private String description = "DefaultBeschreibung";

	@Argument(name = "name", description = "Name of Category", required = true, multiValued = false)
	private String name;

	@Inject
	private InventoryEntityBroker broker;

	public void setBroker(final InventoryEntityBroker broker) {
		this.broker = broker;
	}

	@Override
	public Object execute() throws Exception {
		broker.addCategory(name, description);
		return null;
	}
}
