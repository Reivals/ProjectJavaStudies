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

    //Spring context
    private ConfigurableApplicationContext context;
    //Loader fxml file
    private Parent rootNode;

    /*
    ARGUMENTS FROM MAIN METHOD ARE NOT USED ANYWHERE,
    I'VE PLACED THEM JUST FOR KEEPING WITH JAVA SYNTAX
     */
    public static void main(String args[]){
        launch(args);
    }

    /*
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

    /*
     * Method invoked after container starts
     */
    public void start(Stage stage) {
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("Projekt JAVA - Michał Karkowski");
        stage.show();
    }
}
