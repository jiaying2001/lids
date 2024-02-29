package info.jiaying.log_transfer_hub.logparser.domainknowledge.impl;

import info.jiaying.log_transfer_hub.logparser.domainknowledge.AbstractDomainKnowledge;

public class TimeRelatedKnowledge extends AbstractDomainKnowledge {
    private final String FILE_PATH = "knowledge/time_related.txt";

    public TimeRelatedKnowledge() {
        super();
    }

    @Override
    public boolean doIdentify(String token) {
        if (isIdiot()) {
            if(!learnFromFile(FILE_PATH)){
                return false;
            };
        }
        return match(token);
    }
}
