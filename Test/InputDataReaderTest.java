import org.junit.jupiter.api.Test;

public class InputDataReaderTest {

    @Test
    void readInputDataTest(){
        assert(InputDataReader.readInputData(true).equals("David Ljunggren"));
        assert(!InputDataReader.readInputData(true).equals("Alhambra Alvares"));
    }
}