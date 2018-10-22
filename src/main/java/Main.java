import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Michal on 22.10.2018
 */

@SpringBootApplication
@ComponentScan(basePackages = {"model", "controller"})
public class Main extends Application {

    private ConfigurableApplicationContext context;
    private Parent rootNode;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainView.fxml"));
        loader.setControllerFactory(context::getBean);
        rootNode = loader.load();
    }

    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("Projekt JAVA - Michał Karkowski");
        stage.show();
    }
}
