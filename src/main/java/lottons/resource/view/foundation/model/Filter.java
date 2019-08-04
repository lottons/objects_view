package lottons.resource.view.foundation.model;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Filter {
    Map<String, String> conditions = new HashMap();
    List<String> fields = new ArrayList();
    String betweenFrom;
    String betweenTo;
    String resourceName;

    public Map<String, String> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, String> conditions) {
        this.conditions = conditions;
    }

    public String getBetweenFrom() {
        return betweenFrom;
    }

    public void setBetweenFrom(String betweenFrom) {
        this.betweenFrom = betweenFrom;
    }

    public String getBetweenTo() {
        return betweenTo;
    }

    public void setBetweenTo(String betweenTo) {
        this.betweenTo = betweenTo;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }


    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public static void main(String[] args) {
        Filter f = new Filter();
        f.getConditions().put("name","asdf ");
        f.getFields().add("name");
        f.setResourceName("customer");

        String str1= JSON.toJSONString(f);
        System.out.println(str1);
    }
}
