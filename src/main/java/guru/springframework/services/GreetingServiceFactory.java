package guru.springframework.services;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService greetingService(String lang) {
        switch (lang) {
            case "es": return new PrimarySpanishGreetingService(greetingRepository);
            case "de": return new PrimaryGermanGreetingService(greetingRepository);
            case "en": return new PrimaryGreetingService(greetingRepository);
            default: return new PrimaryGreetingService(greetingRepository);
        }

    }

}
