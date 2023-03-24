import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Documentele-Mele");
        var document1 = new Document("document1","Primul-Document","C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Lab5/fisierJson.json");
        var document2 = new Document("document2","Al-Doilea-Document", "C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Lab5/fisierJson.json");
        catalog.add(document1);
        catalog.add(document2);
        CatalogUtil.save(catalog, "C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Lab5/fisierJson.json");


    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("C:/Users/utilizator/Documents/GitHub/Programare-Avansata/Lab5/Lab5/fisierJson.json");
            CatalogUtil.view(catalog.findById("document1"));
            System.out.println(catalog);
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
