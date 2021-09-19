import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class QAG2 {
    @Test
    void checkSoftAssertionsWiki() {
        open("https://github.com/selenide/selenide");
        $(byText("Wiki")).click();
        $((".wiki-rightbar")).$(byText("SoftAssertions")).should(exist);
        $((".wiki-rightbar")).$("button").click();
        $((".wiki-rightbar")).$(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
    @Test
    void drag_n_drop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(element("#column-a")).dragAndDropTo($(element("#column-b")));
        $$("header").shouldHave(texts("B", "A"));
    }
}
