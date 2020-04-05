package org.mirrane;

import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXML;
import org.mirrane.entity.Client;
import org.mirrane.service.ClientService;

public class PrimaryController {

    ClientService clientService;

    @FXML
    private TextField nameTextField;

    public PrimaryController() {
        this.clientService = new ClientService();
        TextField nameTextField = new TextField();

        /*
        ClientService  clientService = new ClientService();

        System.out.println("1------------------------------------------------------");
        clientService.addClient(new Client("hajar"));
        System.out.println("2------------------------------------------------------");
        clientService.getClients().forEach(client -> System.out.println(client.toString()));
        System.out.println("3------------------------------------------------------");
        System.out.println(clientService.getClientById(3).toString());
        System.out.println("4------------------------------------------------------");
        clientService.updateClient(new Client(1,"mama" ));
        System.out.println("5------------------------------------------------------");
        clientService.deleteClient(4);
        System.out.println("6------------------------------------------------------");
        clientService.getClients().forEach(client -> System.out.println(client.toString()));
         */
    }



    @FXML
    private void switchToSecondary() throws IOException {


        Client client = new Client();
        client.setName(nameTextField.getText());
        clientService.addClient(client);

       // App.setRoot("secondary");
    }
}
