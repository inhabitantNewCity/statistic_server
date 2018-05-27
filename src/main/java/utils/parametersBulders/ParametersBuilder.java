package utils.parametersBulders;

import java.util.Map;

abstract public class ParametersBuilder {

    protected Map<String, Object> params;

    protected ParametersBuilder(Map<String, Object> params){
        this.params = params;
    }


    public static Map<String, Object> getParameters(String ... v){
        return null;
    }

    protected abstract String buildQuery();

    public Map<String, Integer> runQuery(){
        //todo: run build query
        //todo: analyze query result in class
        String query = buildQuery();
        return null;
    };
}
