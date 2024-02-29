package info.jiaying.log_transfer_hub.logparser.domainknowledge;

import java.util.HashMap;
import java.util.Map;

public class DomainKnowledgeManager implements DomainKnowledge{
    DomainKnowledge DUMMY_HEAD;
    DomainKnowledge DUMMY_TAIL;

    public DomainKnowledgeManager() {
        DUMMY_TAIL = new DummyNode();
        DUMMY_HEAD = new DummyNode(null, DUMMY_TAIL);
        ((AbstractDomainKnowledge)DUMMY_TAIL).setPreviousNode(DUMMY_HEAD);
    }

    public void register(DomainKnowledge domainKnowledge) {
        DomainKnowledge last = ((AbstractDomainKnowledge)DUMMY_TAIL).getPreviousNode();
        ((AbstractDomainKnowledge)last).setNextNode(domainKnowledge);
        ((AbstractDomainKnowledge)DUMMY_TAIL).setPreviousNode(domainKnowledge);
        return;
    }


    @Override
    public boolean isIdentified(String token) {
        return DUMMY_HEAD.isIdentified(token);
    }
}
