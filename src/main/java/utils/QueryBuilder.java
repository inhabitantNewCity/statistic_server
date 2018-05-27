package utils;

import com.sun.javafx.collections.MappingChange;
import utils.parametersBulders.ParametersBuilder;

import java.util.HashMap;
import java.util.Map;

public class QueryBuilder {

    private Map<ReportType, ParametersBuilder> queryTemplate = new HashMap<ReportType, ParametersBuilder>(){{
       //put()
    }};

    public String buildQuery(ReportType type){
         return null;
    }
}
