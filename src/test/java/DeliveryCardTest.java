import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCardTest {
    String dateForInput;

    @DisplayName("Registration form for delivery card")
    @Test
    void registrationFormForDeliveryCard() {
        LocalDate today = LocalDate.now();
        LocalDate dateCorrect = today.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        dateForInput = dateCorrect.format(formatter);
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Самара");
        $("[data-test-id=date] input").setValue(dateForInput);
        $("[data-test-id=name] input").setValue("Даньшин Алексей");
        $("[data-test-id=phone] input").setValue("+79854332355");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно")).waitUntil(Condition.visible, 15000);
    }


}
