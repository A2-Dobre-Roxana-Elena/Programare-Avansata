import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command{
    public ViewCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String arg) throws CommandException, IOException {
        parseArguments(arg);
        if (arguments.get(0).equals("deschidere") && arguments.get(1).equals("document") && arguments.size() == 3) {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            assert desktop != null;
            desktop.open(new File(catalog.findById(arguments.get(2)).getLocation()));
        } else {
            throw new CommandException("Comanda de deschidere a documentelui a fost introdusa gresit. Aveti grija sa respectati formatul.");
        }
    }
}
