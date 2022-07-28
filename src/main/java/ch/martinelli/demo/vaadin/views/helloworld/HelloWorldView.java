package ch.martinelli.demo.vaadin.views.helloworld;

import ch.martinelli.demo.vaadin.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    private final DecimalFormat decimalFormate = new DecimalFormat("###,###,###.00");

    public HelloWorldView() {
        Binder<Person> binder = new Binder<>(Person.class);

        TextField name = new TextField("Name");
        binder.forField(name)
                .bind("name");

        TextField salary = new TextField("Salary");
        binder.forField(salary)
                .withConverter(new Converter<String, BigDecimal>() {
                    @Override
                    public Result<BigDecimal> convertToModel(String value, ValueContext context) {
                        if (value == null || value.length() == 0) {
                            return Result.ok(new BigDecimal(0));
                        } else {
                            return Result.ok(new BigDecimal(value));
                        }
                    }

                    @Override
                    public String convertToPresentation(BigDecimal value, ValueContext context) {
                        if (value == null) {
                            return "";
                        } else {
                            return decimalFormate.format(value);
                        }
                    }
                })
                .bind("salary");

        binder.setBean(new Person());

        add(name, salary);
    }

}
