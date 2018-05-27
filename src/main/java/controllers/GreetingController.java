package controllers;

import java.util.concurrent.atomic.AtomicLong;
import dao.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.ReportType;
import utils.parametersBulders.FactoryParametersBuilder;
import utils.parametersBulders.ParametersBuilder;

import java.util.Map;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private FactoryParametersBuilder factoryBuilder = FactoryParametersBuilder.getInstance();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/timeInDay")
    public Map<String, Integer> timeInDay(@RequestParam(value="day", defaultValue="WEN") String day) {
        Map<String, Object> params =  factoryBuilder.getBuilderClassByType(ReportType.TIME_IN_DAY, day);
        ParametersBuilder builder = factoryBuilder.getBuilderByType(ReportType.TIME_IN_DAY, params);
        return builder.runQuery();
    }

    @RequestMapping("/clientsPerDocTypes")
    public Map<String, Integer> clientsPerDocTypes(@RequestParam(value="day", defaultValue="WEN") String day) {
        Map<String, Object> params =  factoryBuilder.getBuilderClassByType(ReportType.TIME_IN_DAY, day);
        ParametersBuilder builder = factoryBuilder.getBuilderByType(ReportType.TIME_IN_DAY, params);
        return builder.runQuery();
    }

    @RequestMapping("/clientsPerMonths")
    public Map<String, Integer> clientsPerMonths(@RequestParam(value="day", defaultValue="WEN") String day) {
        Map<String, Object> params =  factoryBuilder.getBuilderClassByType(ReportType.TIME_IN_DAY, day);
        ParametersBuilder builder = factoryBuilder.getBuilderByType(ReportType.TIME_IN_DAY, params);
        return builder.runQuery();
    }



}
