package utils.parametersBulders;

import utils.ReportType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FactoryParametersBuilder {

    private Map<ReportType, Class<? extends ParametersBuilder>> QUERY_BUILDER = new HashMap<ReportType, Class<? extends ParametersBuilder>>(){{
        put(ReportType.CLIENT_PER_MONTH, ClientPerMonthBuilder.class);
    }};

    private static FactoryParametersBuilder instance;
    private FactoryParametersBuilder(){};

    public static FactoryParametersBuilder getInstance(){
        if(instance == null)
            instance = new FactoryParametersBuilder();
        return instance;
    }

    public ParametersBuilder getBuilderByType(ReportType type, Map<String, Object> params){
        Class<? extends ParametersBuilder> clazz = QUERY_BUILDER.get(type);
        if (clazz == null) {
            return null;
        }
        Constructor constructor = null;
        try {
            constructor = clazz.getConstructor(Map.class);
            return (ParametersBuilder) constructor.newInstance(params);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException("Class " + clazz.getCanonicalName() + " does not provide required constructor", e);
        } catch (InstantiationException e) {
            return null;
        }
    }

    public Map<String, Object> getBuilderClassByType(ReportType type, String ... v) {
        Class<? extends ParametersBuilder> clazz = QUERY_BUILDER.get(type);
        if (clazz == null) {
            return null;
        }
        Method method = null;
        try {
            method = clazz.getDeclaredMethod("getParameters", ArrayList.class);
            return (Map<String, Object>) method.invoke(null, v);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException("Class " + clazz.getCanonicalName() + " does not provide required constructor", e);
        }
    }
}
