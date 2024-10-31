package awt.droolz.config;

import awt.droolz.dto.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Foo {
    public static void main(final String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("rules");

        // Set up the fact model:
        Person person = new Person();

        person.setFirstName("Andy");
        person.setLastName("Tong");

        // Insert the person into the session:
        kSession.insert(person);

        // Fire all rules:
        kSession.fireAllRules();
    }
}
