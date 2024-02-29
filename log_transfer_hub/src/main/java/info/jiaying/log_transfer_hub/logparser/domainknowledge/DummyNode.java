package info.jiaying.log_transfer_hub.logparser.domainknowledge;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DummyNode extends AbstractDomainKnowledge{
    public DummyNode(DomainKnowledge pre, DomainKnowledge next) {
        super(pre, next);
    }
    @Override
    public boolean doIdentify(String token) {
        return false;
    }
}
