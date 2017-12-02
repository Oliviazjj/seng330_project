package org.springframework.samples.petclinic.web;


import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.model.Event;
import org.springframework.samples.petclinic.service.ClinicService;


/**
 * Instructs Spring MVC on how to parse and print elements of type 'EmployEventType'. Starting from Spring 3.0, Formatters have
 * come as an improvement in comparison to legacy PropertyEditors. See the following links for more details: - The
 * Spring ref doc: http://static.springsource.org/spring/docs/current/spring-framework-reference/html/validation.html#format-Formatter-SPI
 * - A nice blog entry from Gordon Dickens: http://gordondickens.com/wordpress/2010/09/30/using-spring-3-0-custom-type-converter/
 * <p/>
 * Also see how the bean 'conversionService' has been declared inside /WEB-INF/mvc-core-config.xml
 *
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @author Michael Isvy
 */
public class EmployEventTypeFormatter implements Formatter<Event> {

    private final ClinicService clinicService;
//    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployEventTypeFormatter.class);



    @Autowired
    public EmployEventTypeFormatter(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @Override
    public String print(Event event, Locale locale) {
        return event.getName();
    }

    @Override
    public Event parse(String text, Locale locale) throws ParseException {
        Collection<Event> findEventOptions = this.clinicService.findEventOptions();
        for (Event event : findEventOptions) {
//        	logger.debug("event name: ", event.getName());
            if (event.getName().equals(text)) {
                return event;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

}