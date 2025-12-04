package constants;

public enum HomeLinks {
    CONTEXT_MENU("Context Menu"),
    DROPDOWN("Dropdown"),
    DYNAMIC_LOADING("Dynamic Loading"),
    HORIZONTAL_SLIDER("Horizontal Slider"),
    HOVERS("Hovers"),
    JAVASCRIPT_ALERTS("JavaScript Alerts"),
    KEY_PRESSES("Key Presses"),
    FORM_AUTHENTICATION("Form Authentication"),
    WYSIWYG_EDITOR("WYSIWYG Editor");

    private final String text;

    HomeLinks(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
