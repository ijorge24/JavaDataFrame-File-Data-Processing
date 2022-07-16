package Factory;

public class TxtFactory implements FileFactory{
    /**
     * Create a TXT file
     * @return TXT file
     */
    @Override
    public Files createFile() {
        return new TXT();
    }
}
