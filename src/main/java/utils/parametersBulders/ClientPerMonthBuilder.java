package utils.parametersBulders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static utils.ConstantQueries.CLIENT_PER_MONTH;
import static utils.ConstantQueries.TIME_IN_DAY;

public class ClientPerMonthBuilder extends ParametersBuilder {
    private static String PARAM_ONE_NAME = "MONTH_FROM";
    private static String PARAM_TWO_NAME = "MONTH_TO";
    private Date month_from;
    private Date month_to;

    protected ClientPerMonthBuilder(Map<String, Object> params) {
        super(params);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        try {
            month_from = formatter.parse((String) params.get(PARAM_ONE_NAME));
            month_to =  formatter.parse((String) params.get(PARAM_TWO_NAME));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Object> getParameters(String ... v){
        if(v == null)
            return null;
        if(v[0] == null)
            return null;
        if(v[1] == null)
            return null;
        return new HashMap<String, Object>(){{
            put(PARAM_ONE_NAME,v[0]);
            put(PARAM_TWO_NAME,v[1]);
        }};
    }

    @Override
    protected String buildQuery() {
        return String.format(CLIENT_PER_MONTH,month_from,month_to);
    }

}
