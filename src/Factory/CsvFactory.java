package Factory;

public class CsvFactory implements FileFactory{
    /**
     * Create a Csv file
     * @return csv file
     */
    @Override
    public Files createFile() {
        return new CSV();
    }
}
