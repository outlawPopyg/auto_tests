import org.example.Group;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestUtils;

public class TestDataGeneratorTest {

	@ParameterizedTest
	@ValueSource(strings = { "/storage/test.xml" })
	public void test(String fileName) throws Exception {
		Group group = (Group) TestUtils.retrieveData(fileName, Group.class);
		Assert.assertEquals(3, group.getData().size());
	}
}
