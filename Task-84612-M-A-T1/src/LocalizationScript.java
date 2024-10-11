import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocalizationScript {

    private final Map<String, Map<String, String>> translations;

    public LocalizationScript() {
        translations = new HashMap<>();
        initTranslations();
    }

    private void initTranslations() {
        // Initialize translations for different languages
        translations.put("en", new HashMap<>());
        translations.get("en").put("welcome_message", "Welcome to our home automation system!");
        translations.get("en").put("light_on", "Turn light on");

        translations.put("es", new HashMap<>());
        translations.get("es").put("welcome_message", "Bienvenido a nuestro sistema de automatización de hogar!");
        translations.get("es").put("light_on", "Prender la luz");

        // Add more languages and translations as needed
    }

    public String translate(String key, Locale locale) {
        String languageCode = locale.getLanguage();
        Map<String, String> translationsForLanguage = translations.get(languageCode);

        if (translationsForLanguage == null) {
            // Fall back to default language if the specified language is not supported
            translationsForLanguage = translations.get("en");
        }

        String translation = translationsForLanguage.get(key);

        if (translation == null) {
            // Handle missing translations
            return "Translation not found for key: " + key;
        }

        return translation;
    }

    public static void main(String[] args) {
        LocalizationScript localizationScript = new LocalizationScript();

        Locale englishLocale = new Locale("en");
        Locale spanishLocale = new Locale("es");

        System.out.println(localizationScript.translate("welcome_message", englishLocale)); // Output: Welcome to our home automation system!
        System.out.println(localizationScript.translate("welcome_message", spanishLocale)); // Output: Bienvenido a nuestro sistema de automatización de hogar!
        System.out.println(localizationScript.translate("light_on", englishLocale)); // Output: Turn light on
        System.out.println(localizationScript.translate("light_on", spanishLocale)); // Output: Prender la luz
    }
}
