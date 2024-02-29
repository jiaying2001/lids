package info.jiaying.log_transfer_hub.logparser.domainknowledge;

import cn.hutool.core.io.resource.ResourceUtil;
import info.jiaying.log_transfer_hub.util.regx.ReUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
public abstract class AbstractDomainKnowledge implements DomainKnowledge{
    protected List<Pattern> patterns = new ArrayList<>();
    private DomainKnowledge previousNode;
    private DomainKnowledge nextNode;

    public AbstractDomainKnowledge(DomainKnowledge pre, DomainKnowledge next) {
        previousNode = pre;
        nextNode = next;
    }

    @Override
    public boolean isIdentified(String token) {
        if (doIdentify(token)) {
            return true;
        }
        if (nextNode == null) {
            return false;
        }
        return nextNode.isIdentified(token);
    };
    public abstract boolean doIdentify(String token);

    public boolean learnFromFile(String filePath) {
        try(BufferedReader reader = ResourceUtil.getUtf8Reader(filePath)){
            String knowledge;
            while ((knowledge = reader.readLine()) != null) {
               patterns.add(Pattern.compile(knowledge));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return !isIdiot();
    }

    public boolean isIdiot() {
        return patterns.isEmpty();
    }

    public boolean match(String str) {
        return ReUtil.isMatch(str, patterns);
    }
}
