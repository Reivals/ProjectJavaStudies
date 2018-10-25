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
 * @version 1.0
 * Startup of application
 */
@SpringBootApplication
@ComponentScan(basePackages = {"model", "controller"})
public class Main extends Application {

    /**
     * Spring context, used only for injection into classes
     */
    private ConfigurableApplicationContext context;
    /**
     * Root element of view injected into scene
     */
    private Parent rootNode;

    /**
     * Starting app method
     * @param args
     */
    public static void main(String args[]){
        launch(args);
    }

    /**
     * Method from from JavaFx
     * Initialize Spring Container + inject controller into view
     */
    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainView.fxml"));
        loader.setControllerFactory(context::getBean);
        rootNode = loader.load();
    }

    /**
     * Method invoked after container starts
     * @param
     */
    public void start(Stage stage) {
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("Projekt JAVA - Michał Karkowski");
        stage.show();
    }
}
