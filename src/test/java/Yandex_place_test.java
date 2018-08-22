import YadMark.RunTest;
import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import unittesting.UnitTestClassBase;

import java.util.concurrent.TimeUnit;

public class Yandex_place_test extends UnitTestClassBase {
    private WebDriver driver;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new RunTest();
        globalSetup( RunTest.class);
    }
    @Before
    public void setUpBefore() {

        //Пусть к селениуму
        System.setProperty("webdriver.chrome.driver", "C:\\bell\\Projects\\yandex_place\\chromedriver.exe");
        //Путь к селениуму
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test

    public void notebook_part() throws ReportException {

        Yandex_place marketPage = new Yandex_place(driver);

        driver.get(marketPage.MarketUrl );

        marketPage.YandexMarket.click();
        Reporter.reportEvent( "Переход на сайт ","Выполнено" );
        marketPage.computer.click();
        Reporter.reportEvent( "Переход в раздел компьютеры ","Выполнено" );
        marketPage.notebook.click();
        Reporter.reportEvent( "Переход в раздел ноутбуки ","Выполнено" );
        marketPage.maxPriceField.sendKeys("30000");
        Reporter.reportEvent( "Установка максимальной цены","Выполнено" );
        marketPage.selectCheckBox("HP");
        marketPage.selectCheckBox("Lenovo");
        //wait download page
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reporter.reportEvent( "Выбор Производителя","Выполнено" );
        //на странице 48 елемнтов по умолчанию
        Assert.assertEquals(48, marketPage.elements.size());

        String device = marketPage.elements.get(0).getText();
        String[] deviceParts = device.split("\n");

        marketPage.searchProduct.sendKeys(deviceParts[1]);
        marketPage.FindProduct.submit();
        Reporter.reportEvent( "Выбор элемента и поиск","Выполнено" );
        String deviceFind = marketPage.DeviseName.getText().substring(0, 35);

        Assert.assertEquals(deviceParts[1], deviceFind);
        System.out.println("Элементы совпадают!");
        Reporter.reportEvent( "Элементы совпадают!","Выполнено" );
    }

    @Test


    public void tablet_part() throws ReportException {

        Yandex_place marketPage = new Yandex_place(driver);

        driver.get(marketPage.MarketUrl );

        marketPage.YandexMarket.click();
        Reporter.reportEvent( "Переход на сайт ","Выполнено" );
        marketPage.computer.click();
        Reporter.reportEvent( "Переход в компьютеры ","Выполнено" );
        marketPage.tablet.click();
        Reporter.reportEvent( "Переход в планшеты ","Выполнено" );
        marketPage.minPriceField.sendKeys("20000");
        marketPage.maxPriceField.sendKeys("40000");
        Reporter.reportEvent( "Выбор  цен","Выполнено" );
        marketPage.selectCheckBox("ASUS");
        marketPage.selectCheckBox("Huawei");
        Reporter.reportEvent( "Выбор Производителя","Выполнено" );
        //wait download page
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //на странице 24 елемнтов по умолчанию
        Assert.assertEquals(25, marketPage.elements.size());

        String device = marketPage.elements.get(0).getText();
        String[] deviceParts = device.split("\n");

        marketPage.searchProduct.sendKeys(deviceParts[0]);
        marketPage.FindProduct.submit();
        Reporter.reportEvent( "Выбор элемента и поиск","Выполнено" );
        String deviceFind = marketPage.DeviseName.getText();

        Assert.assertEquals(deviceParts[0], deviceFind);

    }

    @After
    public void tearDownAfter() throws ReportException {
        Reporter.reportEvent( "Тест закончен","Выполнено" );
        driver.quit();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }
}
