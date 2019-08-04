package lottons.resource.view.foundation.mapper;

import lottons.resource.view.foundation.model.Filter;
import org.springframework.data.jpa.domain.Specification;

public interface IResourceFilter {
    public String getQuerySql(Filter f);
    public String getQeuryHql(Filter f);
    public Specification getSpecification(Filter f);
}
