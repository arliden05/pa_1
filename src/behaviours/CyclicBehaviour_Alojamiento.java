package behaviours;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class CyclicBehaviour_Alojamiento extends CyclicBehaviour {
    @Override
    public void action() {
        //esperar a que me llegue el request
        ACLMessage msg =
                this.myAgent.blockingReceive(
                        MessageTemplate.and(
                                MessageTemplate.MatchOntology("ontologia"),
                                MessageTemplate.MatchPerformative(ACLMessage.REQUEST)
                        )
                );
    }
}
