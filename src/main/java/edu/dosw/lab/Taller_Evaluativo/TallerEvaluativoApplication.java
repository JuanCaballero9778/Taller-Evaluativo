package edu.dosw.lab.Taller_Evaluativo;

import edu.dosw.lab.solid.MonitoreoStock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "edu.dosw.lab")
public class TallerEvaluativoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(TallerEvaluativoApplication.class, args);

        MonitoreoStock monitoreoStock = context.getBean(MonitoreoStock.class);
        monitoreoStock.run(args);
    }
}
