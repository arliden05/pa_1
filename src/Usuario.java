import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

import java.util.Objects;
import java.util.Scanner;

import utils.Consulta;
import utils.Utils;

public class Usuario extends Agent {

    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {

                // pedir informaciones del usuario
                System.out.println("¿Desea hacer un viaje? [y/n]");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.nextLine();

                String destino = "";
                String fecha_ida = "";
                String fecha_vuelta = "";

                if (Objects.equals(respuesta, "y")) {

                    System.out.println("Destino:");
                    destino = sc.nextLine();

                    System.out.println("Fecha Ida (del 01/05/2025 al 30/05/2025):");
                    fecha_ida = sc.nextLine();

                    System.out.println("Fecha Vuelta (del 02/05/2025 al 31/05/2025):");
                    fecha_vuelta = sc.nextLine();

                    System.out.println("Datos cogidos.");

                } else {
                    System.out.println("¡Adios!");
                    takeDown();
                }

                // crear consulta y enviarlo al CorteIngles
                Consulta consulta = new Consulta(destino,fecha_ida,fecha_vuelta);
                String consulta_str = consulta.toString();
                Utils.enviarMensaje(this.myAgent,"consulta",consulta_str);

                System.out.println("Enviando consulta.");

                // esperar respuesta del CorteIngles
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
