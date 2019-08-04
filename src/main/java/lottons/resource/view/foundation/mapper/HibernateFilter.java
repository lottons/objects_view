package lottons.resource.view.foundation.mapper;

import lottons.resource.view.foundation.model.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HibernateFilter extends BaseResouceFilter {
    public String getQeuryHql(Filter f) {
        HashMap<String, String> conditionMap = (HashMap<String, String>) f.getConditions();
        ArrayList<String> fields = (ArrayList<String>) f.getFields();
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("select ");
        for (int i = 0; i < fields.size() - 1; i++) {
            queryStr.append("o." + fields.get(i) + ", ");
        }

        queryStr.append("o." + fields.get(fields.size() - 1));

        queryStr.append(" from " + f.getResourceName() + " o");

        queryStr.append(" where ");
        Iterator iter = conditionMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            queryStr.append("o." + key + " = '" + val + "'");
        }

        return queryStr.toString();
    }
}
