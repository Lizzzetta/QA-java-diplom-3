package practicum;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import practicum.pageobject.MainPage;

import java.util.stream.Stream;

import static practicum.util.Pages.openMainPage;

public class MainPageTest extends TestBase
{
    public static Stream<Arguments> navigateToSectionParameters()
    {
        return Stream.of(
                Arguments.of("Начинки", "Булки"),
                Arguments.of("Начинки", "Соусы"),
                Arguments.of("Соусы", "Начинки")
        );
    }

    @ParameterizedTest
    @MethodSource("navigateToSectionParameters")
    @DisplayName("Click on section tab and check that section is visible")
    public void checkNavigateToSection(String sectionForRemoveFocusFromTargetSection, String targetSection)
    {
        openMainPage(webDriver);

        MainPage mainPage = new MainPage(webDriver);

        if (mainPage.isSectionVisibleInViewport(targetSection))
        {
            mainPage.clickOnSectionTab(sectionForRemoveFocusFromTargetSection);
            mainPage.waitUntilSectionVisible(sectionForRemoveFocusFromTargetSection);
        }

        mainPage.clickOnSectionTab(targetSection);
        mainPage.waitUntilSectionVisible(targetSection);
    }
}
