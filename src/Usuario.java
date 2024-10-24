import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

import java.util.Objects;
import java.util.Scanner;

public class Usuario extends Agent {

    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println("¿Desea hacer un viaje? [y/n]");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.nextLine();

                if (Objects.equals(respuesta, "y")) {

                    System.out.println("Destino:");
                    String destino = sc.nextLine();

                    System.out.println("Fecha Ida (del 01/05/2025 al 30/05/2025):");
                    String fecha_ida = sc.nextLine();

                    System.out.println("Fecha Vuelta (del 02/05/2025 al 31/05/2025):");
                    String fecha_vuelta = sc.nextLine();

                } else {
                    System.out.println("¡Adios!");
                    takeDown();
                }

                ACLMessage msg =
                        this.myAgent.blockingReceive(
                                MessageTemplate.and(
                                        MessageTemplate.MatchOntology("viajes"),
                                        MessageTemplate.MatchPerformative(ACLMessage.INFORM)
                                )
                        );

                try {
                    String respuesta_corteIngles = (String) msg.getContentObject();
                    System.out.println(respuesta_corteIngles);
                } catch (UnreadableException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
