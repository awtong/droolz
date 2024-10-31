package awt.droolz;

import awt.droolz.dto.Person;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KieContainer kieContainer;

    @GetMapping("/droolz")
    public void droolz() {
        final KieSession kieSession = kieContainer.newKieSession("rule");

        Person person = new Person();
        person.setFirstName("FN");
        person.setLastName("LN");
        kieSession.insert(person);
        kieSession.fireAllRules();
    }
}
