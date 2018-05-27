package utils.parametersBulders;

import java.util.HashMap;
import java.util.Map;

import static utils.ConstantQueries.CLIENT_PER_DOCTOR;
import static utils.ConstantQueries.TIME_IN_DAY;

public class ClientPerDoctorBuilder extends ParametersBuilder {
    private static String PARAM_ONE_NAME = "TYPE";
    private static String type;

    protected ClientPerDoctorBuilder(Map<String, Object> params) {
        super(params);
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
        return String.format(CLIENT_PER_DOCTOR,type);
    }

}
