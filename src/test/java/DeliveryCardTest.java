import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCardTest {
    @DisplayName("Registration form for delivery card")
    @Test
    void registrationFormForDeliveryCard() {
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, 4);
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        String str = format1.format(c.getTime());
        open("http://localhost:9999");
        SelenideElement form = $("form");
        $("[data-test-id=city] input").setValue("Самара");
        $(byText("Дата встречи"));
        $("[data-test-id=name] input").setValue("Даньшин Алексей");
        $("[data-test-id=phone] input").setValue("+79854332355");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $("[data-test-id=notification]").waitUntil(visible, 15000);
    }

}
