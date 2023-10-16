package spring;

import org.springframework.beans.factory.FactoryBean;

import java.util.List;

public class MealsFactoryBean implements FactoryBean<List<String>> {
    @Override
    public List<String> getObject() throws Exception {
        return List.of(
                "gazpacho",
                "carbonara",
                "pizza with pineapple"
        );
    }

    @Override
    public Class<?> getObjectType() {
        return List.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
