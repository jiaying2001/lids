package info.jiaying.log_transfer_hub.logparser.domainknowledge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbstractDomainKnowledgeTests {

    private AbstractDomainKnowledge DUT = new AbstractDomainKnowledge() {
        @Override
        public boolean doIdentify(String token) {
            return match(token);
        }
    };

    @Test
    void learnFromFileTest() {
      DUT.learnFromFile("knowledge/test.txt");
      Assertions.assertEquals(2, DUT.getPatterns().size());
      Assertions.assertTrue(DUT.isIdentified("0.0.0.0"));
      Assertions.assertTrue(DUT.isIdentified("2001-12-22 00:00:00"));
      Assertions.assertFalse(DUT.isIdentified("0.0.0."));
      Assertions.assertFalse(DUT.isIdentified(""));
    }
}
