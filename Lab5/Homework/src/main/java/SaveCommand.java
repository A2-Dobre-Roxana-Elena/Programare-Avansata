import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.File;

public class SaveCommand extends Command{
    public SaveCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String arg) throws CommandException, IOException {
        parseArguments(arg);
        if (arguments.get(0).equals("salveaza") && arguments.get(1).equals("catalogul") && arguments.size() == 3) {

            ObjectMapper objectMapper = new ObjectMapper();
            //objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(arguments.get(2)), catalog);

         //   ObjectMapper objectMapper = new ObjectMapper(); ///serializare
           // objectMapper.writeValue(new File(path), catalog);
        } else {
            throw new CommandException("Comanda de salvare a fost introdusa gresit. Aveti grija sa respectati formatul.");
        }
    }
}
