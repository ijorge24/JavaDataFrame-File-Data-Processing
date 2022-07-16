package Factory;

public class JsonFactory implements FileFactory{
    /**
     * Create a Json file
     * @return Json file
     */
    @Override
    public Files createFile() {
        return new JSON();
    }
}
