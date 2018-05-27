package utils.parametersBulders;

import java.util.HashMap;
import java.util.Map;

import static utils.ConstantQueries.TIME_IN_DAY;

public class TimeInDay extends ParametersBuilder {
    private static String PARAM_ONE_NAME = "DAY";
    private String value;

    protected TimeInDay(Map<String, Object> params) {
        super(params);
        value=(String) params.get(PARAM_ONE_NAME);
    }

    public static Map<String, Object> getParameters(String ... v){
        if(v == null)
            return null;
        if(v[0] == null)
            return null;
        return new HashMap<String, Object>(){{put(PARAM_ONE_NAME,v[0]);}};
    }

    @Override
    protected String buildQuery() {
        return String.format(TIME_IN_DAY,value);
    }


}
